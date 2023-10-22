package com.example.hotelmanagementservice.servicesHotel;


import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.entities.Hotel;

import java.util.List;

public interface ChambreService {

    Chambre findById(Integer idChambre);

    List<Chambre> findAll();

    List<Chambre> getAllChambres();


    List<Chambre> findAvailableRooms();

    void createChambre(Chambre chambre);

    Chambre updateChambre(Integer idChambre, Chambre chambre);
    void deleteChambre(Integer idChambre);
}
