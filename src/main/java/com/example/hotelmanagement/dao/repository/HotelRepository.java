package com.example.hotelmanagement.dao.repository;

import com.example.hotelmanagement.dao.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
