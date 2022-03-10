package pdp.uz.lesson10task1spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pdp.uz.lesson10task1spring.entity.Hotel;
import pdp.uz.lesson10task1spring.payload.ApiResponse;
import pdp.uz.lesson10task1spring.repository.HotelRepo;

import java.util.Optional;

/**
 * @author Hulkar,
 * @time чт 10:17.
 * @project 10.03.2022
 */
@Service
public class HotelService {

    @Autowired
    HotelRepo hotelRepo;

    public ApiResponse getAll() {


        return new ApiResponse(true, "All hotels", hotelRepo.findAll());
    }

    public ApiResponse getHotelByID(Integer id) {
        Optional<Hotel> optional = hotelRepo.findById(id);
        return optional.map(hotel -> new ApiResponse(true, "Id= " + id, hotel))
                .orElseGet(() -> new ApiResponse(false, "Hotel Not found"));
    }

    public ApiResponse deleteHotel(Integer id) {
        hotelRepo.deleteById(id);
        return new ApiResponse(true, "Hotel Deleted");
    }

    public ApiResponse createOrUpdate(Hotel hotel) {
        if (hotel.getId()!=null){
            Hotel byId = hotelRepo.getById(hotel.getId());
            byId.setName(hotel.getName());
            hotelRepo.save(byId);
            return new ApiResponse(true, "Hotel Edited");
        }
        else {
            hotelRepo.save(hotel);
            return new ApiResponse(true,"Hotel Saved");
        }
    }
}
