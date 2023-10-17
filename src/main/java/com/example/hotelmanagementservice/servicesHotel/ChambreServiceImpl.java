package com.example.hotelmanagementservice.servicesHotel;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.dao.repository.ChambreRepository;
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
    public Chambre findById(Integer idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> findAll() {
        return chambreRepository.findAll();
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
    public Chambre updateChambre(Integer idChambre, Chambre chambre) {

        Chambre existingChambre = chambreRepository.findById(idChambre).orElse(null);
        if (existingChambre != null) {
            // Mettez à jour les champs nécessaires de l'employé existant avec les nouvelles valeurs
            existingChambre.setNumeroChambre(chambre.getNumeroChambre());
            existingChambre.setCapacite(chambre.getCapacite());
            existingChambre.setType(chambre.getType());
            existingChambre.setDisponibilite(chambre.getDisponibilite());
            existingChambre.setPrixParNuit(chambre.getPrixParNuit());

            // Enregistrez les modifications dans la base de données
            return chambreRepository.save(existingChambre);
        }
        return null;
    }


    @Override
    public void deleteChambre(Integer idChambre) {
        chambreRepository.deleteById(idChambre);
    }
}

