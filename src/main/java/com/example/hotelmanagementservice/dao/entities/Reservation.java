package com.example.hotelmanagementservice.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "reservations")
public class Reservation {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReservation;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;


    private String userId ;

    private LocalDate dateArrivee;
    private LocalDate dateDepart;

    private StatutReservation statut;

    // getters et setters


    // Constructeur avec tous les champs
    public Reservation ( Hotel hotel, Chambre chambre, LocalDate dateArrivee, LocalDate dateDepart, StatutReservation statut) {

        this.hotel = hotel;
        this.chambre = chambre;
        this.dateArrivee = dateArrivee;
        this.dateDepart = dateDepart;
        this.statut = statut;
    }

    // Getters
    public Integer getId() {
        return idReservation;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public LocalDate getDateArrivee() {
        return dateArrivee;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public StatutReservation getStatut() {
        return statut;
    }


    // Setters
    public void setId(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setDateArrivee(LocalDate dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }

}

