package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dao.entities.Hotel;
import com.example.hotelmanagement.servicesHotel.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/hotel")
public class HotelController {



    @Autowired
    private HotelServiceImpl hotelService;


    @GetMapping
    public List<Hotel> getAllHotel() {
        return hotelService.getAllHotels();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Integer id) {
        return hotelService.getHotelById(id);
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Integer id, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Integer id) {
        hotelService.deleteHotel(id);
    }

}
