package com.example.hotelmanagementservice.dao.repository;


import com.example.hotelmanagementservice.dao.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
