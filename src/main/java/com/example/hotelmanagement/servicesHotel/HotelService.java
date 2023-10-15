package com.example.hotelmanagement.servicesHotel;

import com.example.hotelmanagement.dao.entities.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Integer id);
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Integer id, Hotel hotel);
    void deleteHotel(Integer id);

}
