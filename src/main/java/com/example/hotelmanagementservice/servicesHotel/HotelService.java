package com.example.hotelmanagementservice.servicesHotel;

import com.example.hotelmanagementservice.dao.entities.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotels();
    Hotel getHotelById(Integer idHotel);
    Hotel createHotel(Hotel hotel);
    Hotel updateHotel(Integer idHotel, Hotel hotel);
    void deleteHotel(Integer idHotel);

}
