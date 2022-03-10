package pdp.uz.lesson10task1spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.lesson10task1spring.payload.RoomDto;
import pdp.uz.lesson10task1spring.service.RoomService;
import pdp.uz.lesson10task1spring.utills.AppConstants;

/**
 * @author Hulkar,
 * @time чт 10:38.
 * @project 10.03.2022
 */
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;


    @GetMapping("/all")
    public HttpEntity<?> getAllRooms(){
        return ResponseEntity.ok(roomService.getAllRoom());
    }

    @GetMapping("/byHotelId/{id}")
    public HttpEntity<?> getRoomsByHotelId(@PathVariable Integer id,
            @RequestParam(value = "page",defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(value = "size",defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size,
            @RequestParam(value = "all",defaultValue = "true") boolean all
    ){
        return ResponseEntity.ok(roomService.getRoomByHotelId(id,page,size,all));
    }

    @DeleteMapping("/id")
    public HttpEntity<?> delete(@PathVariable Integer id){

        return ResponseEntity.ok(roomService.delete(id));
    }

    @PostMapping("/addOrUpdate")
    public HttpEntity<?> saveOrEdit(@RequestBody RoomDto dto){
        return ResponseEntity.ok(roomService.addOrUpdate(dto));
    }

}
