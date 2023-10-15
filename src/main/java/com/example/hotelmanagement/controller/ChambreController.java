package com.example.hotelmanagement.controller;

import com.example.hotelmanagement.dao.entities.Chambre;
import com.example.hotelmanagement.servicesHotel.ChambreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chambres")
public class ChambreController {

    private final ChambreService chambreService;

    @Autowired
    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Integer id) {
        return chambreService.findById(id);
    }

    @GetMapping("/hotel/{hotelId}")
    public List<Chambre> getChambresByHotelId(@PathVariable Integer hotelId) {
        return chambreService.findByHotelId(hotelId);
    }

    @GetMapping("/disponibles")
    public List<Chambre> getChambresDisponibles() {
        return chambreService.findAvailableRooms();
    }


    @PostMapping("/creer")
    public void createChambre(@RequestBody Chambre chambre) {
        chambreService.createChambre(chambre);
    }

    @PutMapping("/modifier")
    public void updateChambre(@RequestBody Chambre chambre) {
        chambreService.updateChambre(chambre);
    }

    @DeleteMapping("/supprimer/{id}")
    public void deleteChambre(@PathVariable Integer id) {
        chambreService.deleteChambre(id);
    }
}

