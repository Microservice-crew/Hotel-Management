package com.example.hotelmanagementservice.dao.repository;


import com.example.hotelmanagementservice.dao.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository  extends JpaRepository<Reservation,Integer> {
}
