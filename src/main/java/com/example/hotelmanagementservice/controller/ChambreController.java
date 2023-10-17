package com.example.hotelmanagementservice.controller;

import com.example.hotelmanagementservice.dao.entities.Chambre;
import com.example.hotelmanagementservice.servicesHotel.ChambreService;
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

    @GetMapping("/{idChambre}")
    public Chambre getChambreById(@PathVariable Integer idChambre) {
        return chambreService.findById(idChambre);
    }


    @GetMapping("/disponibles")
    public List<Chambre> getChambresDisponibles() {
        return chambreService.findAvailableRooms();
    }


    @PostMapping("/creer")
    public void createChambre(@RequestBody Chambre chambre) {
        chambreService.createChambre(chambre);
    }


    @PutMapping("/{idChambre}")
    public Chambre updateChambre(@PathVariable Integer idChambre, @RequestBody Chambre chambre) {
        return chambreService.updateChambre(idChambre, chambre);
    }


    @DeleteMapping("/supprimer/{idChambre}")
    public void deleteChambre(@PathVariable Integer idChambre) {
        chambreService.deleteChambre(idChambre);
    }
}

