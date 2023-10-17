package com.example.hotelmanagementservice.servicesHotel;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.entities.Hotel;
import com.example.hotelmanagementservice.dao.entities.Reservation;
import com.example.hotelmanagementservice.dao.repository.ChambreRepository;
import com.example.hotelmanagementservice.dao.repository.HotelRepository;
import com.example.hotelmanagementservice.dao.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
    ReservationRepository reservationRepository;


    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation addReservationToHotelAndChambre(Integer idHotel, Integer idChambre, Reservation reserv) {
        Optional<Chambre> parentChambreOptional = chambreRepository.findById(idChambre);
        if (parentChambreOptional.isPresent()) {
            Chambre chambre = parentChambreOptional.get();
            Optional<Hotel> hotelOptional = hotelRepository.findById(idHotel);
            if (hotelOptional.isPresent()) {
                Hotel hotel = hotelOptional.get();
                reserv.setHotel(hotel);
                reserv.setChambre(chambre);
                return reservationRepository.save(reserv);
            }
        }
        return null;
    }

    public Reservation addReservation(Reservation reservation, Hotel hotel, Chambre chambre) {
        reservation.setHotel(hotel);
        reservation.setChambre(chambre);
        return reservationRepository.save(reservation);
    }



}



