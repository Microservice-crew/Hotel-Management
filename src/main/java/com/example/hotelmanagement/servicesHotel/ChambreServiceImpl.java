package com.example.hotelmanagement.servicesHotel;

import com.example.hotelmanagement.dao.entities.Chambre;
import com.example.hotelmanagement.dao.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreServiceImpl implements ChambreService {

    private final ChambreRepository chambreRepository;

    @Autowired
    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Chambre findById(Integer id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
    }

    @Override
    public List<Chambre> findByHotelId(Integer hotelId) {
        return chambreRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Chambre> findAvailableRooms() {
        return chambreRepository.findByDisponibilite(true);
    }

    @Override
    public void createChambre(Chambre chambre) {
        chambreRepository.save(chambre);
    }

    @Override
    public void updateChambre(Chambre chambre) {
        chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Integer id) {
        chambreRepository.deleteById(id);
    }
}

