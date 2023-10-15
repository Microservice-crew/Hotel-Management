package com.example.hotelmanagement.servicesHotel;

import com.example.hotelmanagement.dao.entities.Chambre;

import java.util.List;

public interface ChambreService {

    Chambre findById(Integer id);

    List<Chambre> findAll();

    List<Chambre> findByHotelId(Integer hotelId);

    List<Chambre> findAvailableRooms();

    void createChambre(Chambre chambre);

    void updateChambre(Chambre chambre);

    void deleteChambre(Integer id);
}
