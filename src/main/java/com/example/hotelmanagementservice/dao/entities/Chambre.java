package com.example.hotelmanagementservice.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table (name = "chambres")
public class Chambre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idChambre;
    private int numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre type;
    private int capacite;
    private double prixParNuit;
    private boolean disponibilite;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    public Chambre(int numeroChambre, TypeChambre type, int capacite, double prixParNuit, boolean disponibilite) {
        this.numeroChambre = numeroChambre;
        this.type = type;
        this.capacite = capacite;
        this.prixParNuit = prixParNuit;
        this.disponibilite = disponibilite;
    }


    public Integer getId() {
        return idChambre;
    }

    public void setId(Integer idChambre) {
        this.idChambre = idChambre;
    }

    public int numeroChambre() {
        return numeroChambre;
    }

    public void numeroChambre(int numero) {
        this.numeroChambre = numero;
    }


    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public double getPrixParNuit() {
        return prixParNuit;
    }

    public void setPrixParNuit(double prixParNuit) {
        this.prixParNuit = prixParNuit;
    }

    public boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }





}
