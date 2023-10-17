package com.example.hotelmanagementservice.servicesHotel;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.entities.Hotel;
import com.example.hotelmanagementservice.dao.entities.Reservation;



public interface ReservationService {

    Reservation createReservation(Reservation reservation);

    public Reservation addReservation(Reservation reservation, Hotel hotel, Chambre chambre);
}