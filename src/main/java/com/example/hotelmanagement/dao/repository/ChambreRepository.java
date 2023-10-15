package com.example.hotelmanagement.dao.repository;

import com.example.hotelmanagement.dao.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository  extends JpaRepository<Chambre,Integer> {
    List<Chambre> findByHotelId(Integer hotelId);

    List<Chambre> findByDisponibilite(boolean b);

}
