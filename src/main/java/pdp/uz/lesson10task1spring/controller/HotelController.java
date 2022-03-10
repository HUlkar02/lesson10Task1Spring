package pdp.uz.lesson10task1spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.lesson10task1spring.entity.Hotel;
import pdp.uz.lesson10task1spring.repository.HotelRepo;
import pdp.uz.lesson10task1spring.service.HotelService;

/**
 * @author Hulkar,
 * @time чт 9:59.
 * @project 10.03.2022
 */

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @GetMapping("/allHotel")
    public HttpEntity<?> getAllHotel() {
        return ResponseEntity.ok(hotelService.getAll());
    }


    @GetMapping("/getHotelById/{id}")
    public HttpEntity<?> getHotelById(@PathVariable Integer id){
        return ResponseEntity.ok(hotelService.getHotelByID(id));
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteHotel(@PathVariable Integer id){
        return ResponseEntity.ok(hotelService.deleteHotel(id));
    }

    @PostMapping("/createOrUpdate")
    public HttpEntity<?> saveOrEdit(@RequestBody Hotel hotel){
        return ResponseEntity.ok(hotelService.createOrUpdate(hotel));
    }




}
