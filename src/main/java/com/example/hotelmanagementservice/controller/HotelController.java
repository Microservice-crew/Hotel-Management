package com.example.hotelmanagementservice.controller;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.entities.Hotel;
import com.example.hotelmanagementservice.dao.entities.Reservation;
import com.example.hotelmanagementservice.dao.entities.User;
import com.example.hotelmanagementservice.dao.repository.ChambreRepository;
import com.example.hotelmanagementservice.dao.repository.HotelRepository;
import com.example.hotelmanagementservice.servicesHotel.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/hotel")
@CrossOrigin(origins = "*")
public class HotelController {



    @Autowired
    private HotelServiceImpl hotelService;

    @Autowired
   private ChambreServiceImpl chambreService;

    @Autowired
    private ReservationService reservationService;

   @Autowired
   userServices userService ;


    @Autowired
    private HotelRepository hotelRepository; // Assurez-vous que HotelRepository est correctement configuré
    @Autowired
    private ChambreRepository chambreRepository; // Assurez-vous que ChambreRepository est correctement configuré




    @GetMapping(value="/hotel/all")
    public List<Hotel> getAllHotel() {
        return hotelService.getAllHotels();
    }



    @GetMapping("/hotel/{idHotel}")
    public Hotel getHotelById(@PathVariable Integer idHotel) {
        return hotelService.getHotelById(idHotel);
    }

    @PostMapping("/hotel/creer")
    public Hotel createHotel(@RequestBody Hotel hotel) {
        return hotelService.createHotel(hotel);
    }

    @PutMapping("/hotel/{idHotel}")
    public Hotel updateHotel(@PathVariable Integer idHotel, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(idHotel, hotel);
    }

    @DeleteMapping("/hotel/supprimer/{id}")
    public void deleteHotel(@PathVariable Integer idHotel) {
        hotelService.deleteHotel(idHotel);
    }



    //chambres Controller


  //  @Autowired

   // public ChambreController(ChambreService chambreService) {
    //    this.chambreService = chambreService;
   // }

    @GetMapping("/chambre/{idChambre}")
    public Chambre getChambreById(@PathVariable Integer idChambre) {
        return chambreService.findById(idChambre);
    }

    @GetMapping(value="/chambre/all")
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }

    @GetMapping("/chambre/disponibles")
    public List<Chambre> getChambresDisponibles() {
        return chambreService.findAvailableRooms();
    }


    @PostMapping("/chambre/creer")
    public void createChambre(@RequestBody Chambre chambre) {
        chambreService.createChambre(chambre);
    }


    @PutMapping("/chambre/update/{idChambre}")
    public Chambre updateChambre(@PathVariable Integer idChambre, @RequestBody Chambre chambre) {
        return chambreService.updateChambre(idChambre, chambre);
    }


    @DeleteMapping("/chambre/supprimer/{idChambre}")
    public void deleteChambre(@PathVariable Integer idChambre) {
        chambreService.deleteChambre(idChambre);
    }



    // Réservation Controller




    @GetMapping(value="/reservation/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/reservation/{idReservation}")
    public Reservation getReservationById(@PathVariable Integer idReservation) {
        return reservationService.getReservationById(idReservation);
    }


    @PostMapping("/reservation/add/{hotelId}/{chambreId}/{userId}")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation, @PathVariable Integer hotelId, @PathVariable Integer chambreId, @PathVariable String userId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElse(null);
        Chambre chambre = chambreRepository.findById(chambreId).orElse(null);
        User user = userService.getUserById(userId);

        if (hotel != null && chambre != null) {
            Reservation addedReservation = reservationService.addReservation(reservation, hotel, chambre ,user.get_id());
            return new ResponseEntity<>(addedReservation, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/reservation/update/{idReservation}")
    public Reservation updateReservation(@PathVariable Integer idReservation, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(idReservation, reservation);
    }



    @DeleteMapping("/reservation/supprimer/{idReservation}")
    public void deleteReservation(@PathVariable Integer idReservation) {
        reservationService.deleteReservation(idReservation);
    }







}
