package com.example.hotelmanagementservice.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "hotels")
public class Hotel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idHotel;
    private String nom;
    private String adresse;
    private String description;
    private int etoiles;
    private double prixParNuit;

    @OneToMany(mappedBy = "hotel")
    private List<Chambre> chambres;


    public Hotel(String nom, String adresse, String description, int etoiles, double prixParNuit) {
        this.nom = nom;
        this.adresse = adresse;
        this.description = description;
        this.etoiles = etoiles;
        this.prixParNuit = prixParNuit;
    }

    public Integer getId() {
        return idHotel;
    }

    public void setId(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

}
