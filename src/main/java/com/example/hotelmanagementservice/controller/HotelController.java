package com.example.hotelmanagementservice.controller;

import com.example.hotelmanagementservice.dao.entities.Hotel;
import com.example.hotelmanagementservice.servicesHotel.HotelServiceImpl;
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

    @GetMapping("/{idHotel}")
    public Hotel getHotelById(@PathVariable Integer idHotel) {
        return hotelService.getHotelById(idHotel);
    }

    @PostMapping
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    @PutMapping("/{idHotel}")
    public Hotel updateHotel(@PathVariable Integer idHotel, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(idHotel, hotel);
    }

    @DeleteMapping("/{id}")
    public void deleteHotel(@PathVariable Integer idHotel) {
        hotelService.deleteHotel(idHotel);
    }
}
