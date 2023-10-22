package com.example.hotelmanagementservice.servicesHotel;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.entities.Hotel;
import com.example.hotelmanagementservice.dao.entities.Reservation;
import com.example.hotelmanagementservice.dao.entities.User;
import com.example.hotelmanagementservice.dao.repository.ChambreRepository;
import com.example.hotelmanagementservice.dao.repository.HotelRepository;
import com.example.hotelmanagementservice.dao.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    ChambreRepository chambreRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    userServices userServices;


    @Override
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation addReservation(Reservation reservation, Hotel hotel, Chambre chambre,String userId) {
        User user = userServices.getUserById(userId);
        reservation.setUserId(user.get_id());
        reservation.setHotel(hotel);
        reservation.setChambre(chambre);
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Integer idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation updateReservation(Integer idReservation, Reservation reservation) {

        Reservation existingReservation = reservationRepository.findById(idReservation).orElse(null);
        if (existingReservation != null) {
            // Mettez à jour les champs nécessaires de l'employé existant avec les nouvelles valeurs
            existingReservation.setHotel(reservation.getHotel());
            existingReservation.setChambre(reservation.getChambre());
            existingReservation.setDateArrivee(reservation.getDateArrivee());
            existingReservation.setDateDepart(reservation.getDateDepart());
            existingReservation.setStatut(reservation.getStatut());

            // Enregistrez les modifications dans la base de données
            return reservationRepository.save(existingReservation);
        }
        return null;


    }

    @Override
    public void deleteReservation(Integer idReservation) {
        reservationRepository.deleteById(idReservation);
    }


}



