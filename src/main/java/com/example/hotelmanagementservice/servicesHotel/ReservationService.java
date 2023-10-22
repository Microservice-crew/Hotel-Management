package com.example.hotelmanagementservice.servicesHotel;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.entities.Hotel;
import com.example.hotelmanagementservice.dao.entities.Reservation;

import java.util.List;


public interface ReservationService {

    Reservation createReservation(Reservation reservation);

    public Reservation addReservation(Reservation reservation, Hotel hotel, Chambre chambre ,String userId);

    List<Reservation> getAllReservations();
    Reservation getReservationById(Integer idReservation);

    Reservation updateReservation(Integer idReservation, Reservation reservation);

    void deleteReservation(Integer idReservation);
}