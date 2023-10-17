package com.example.hotelmanagementservice.controller;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.entities.Hotel;
import com.example.hotelmanagementservice.dao.entities.Reservation;
import com.example.hotelmanagementservice.dao.repository.ChambreRepository;
import com.example.hotelmanagementservice.dao.repository.HotelRepository;
import com.example.hotelmanagementservice.servicesHotel.ReservationService;
import com.example.hotelmanagementservice.servicesHotel.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/reservations")
public class ReservationController {


    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HotelRepository hotelRepository; // Assurez-vous que HotelRepository est correctement configuré
    @Autowired
    private ChambreRepository chambreRepository; // Assurez-vous que ChambreRepository est correctement configuré

    @PostMapping("/add/{hotelId}/{chambreId}")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation, @PathVariable Integer hotelId, @PathVariable Integer chambreId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        Chambre chambre = chambreRepository.findById(chambreId).orElse(null);

        if (hotel != null && chambre != null) {
            Reservation addedReservation = reservationService.addReservation(reservation, hotel, chambre);
            return new ResponseEntity<>(addedReservation, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }







}