package com.example.hotelmanagement.dao.repository;

import com.example.hotelmanagement.dao.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository  extends JpaRepository<Reservation,Integer> {
}
