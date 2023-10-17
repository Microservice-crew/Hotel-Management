package com.example.hotelmanagementservice.dao.repository;


import com.example.hotelmanagementservice.dao.entities.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository  extends JpaRepository<Chambre,Integer> {


    List<Chambre> findByDisponibilite(boolean b);

}
