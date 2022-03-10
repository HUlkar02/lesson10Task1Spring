package pdp.uz.lesson10task1spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import pdp.uz.lesson10task1spring.entity.Room;
import pdp.uz.lesson10task1spring.exceptions.PageSizeException;
import pdp.uz.lesson10task1spring.payload.ApiResponse;
import pdp.uz.lesson10task1spring.payload.RoomDto;
import pdp.uz.lesson10task1spring.repository.RoomRepo;
import pdp.uz.lesson10task1spring.utills.CommandUtills;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Hulkar,
 * @time чт 10:17.
 * @project 10.03.2022
 */

@Service
public class RoomService {

    @Autowired
    RoomRepo roomRepo;

    public ApiResponse getAllRoom() {

        return new ApiResponse(true,"All rooms",roomRepo.findAll());
    }

    public ApiResponse getRoomByHotelId(Integer id, Integer page, Integer size, boolean all) {
        List<RoomDto> roomDtoList = null;
        try {
            List<Room> roomList = null;
            Page<Room> roomPage = roomRepo.findAll(CommandUtills.simplePageable(page-1,size));

            for (Room room : roomPage.getContent()) {
                if (Objects.equals(room.getHotel().getId(), id)){
                    roomList.add(room);
                }
            }

            roomDtoList = roomList.stream()
                    .map(this::generateRoomDto).collect(Collectors.toList());
            return new ApiResponse(true,"All Rooms",roomDtoList,roomPage.getTotalElements());
        } catch (PageSizeException e) {
            e.printStackTrace();
            return new ApiResponse(false,"Error!..");
        }
    }

    public ApiResponse delete(Integer id) {
        Optional<Room> optional = roomRepo.findById(id);
        if (optional.isPresent()){
            roomRepo.deleteById(id);
            return new ApiResponse(true,"Room Deleted");
        }
        else{
            return new ApiResponse(false,"Room Not found room");
        }
    }

    private RoomDto generateRoomDto(Room room) {
        return new RoomDto(
                room.getId(),
                room.getNumber(),
                room.getFloor(),
                room.getSize(),
                room.getHotel()
        );
    }

    public ApiResponse addOrUpdate(RoomDto roomDto) {
        if (roomDto.getId() != null){
            Room byId = roomRepo.getById(roomDto.getId());
            byId.setFloor(roomDto.getFloor());
            byId.setHotel(roomDto.getHotel());
            byId.setNumber(roomDto.getNumber());
            byId.setSize(roomDto.getSize());
            roomRepo.save(byId);
            return new ApiResponse(true,"Edited");
        }
        else {
            roomRepo.save(generateRoom(roomDto));
            return new ApiResponse(true,"Saved");
        }
    }

    private Room generateRoom(RoomDto dto) {
        Room room = new Room();
        room.setSize(dto.getSize());
        room.setHotel(dto.getHotel());
        room.setNumber(dto.getNumber());
        room.setFloor(dto.getFloor());
        return room;
    }
}
