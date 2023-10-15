package com.example.hotelmanagement.servicesHotel;

import com.example.hotelmanagement.dao.entities.Hotel;
import com.example.hotelmanagement.dao.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{


    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }


    @Override
    public Hotel updateHotel(Integer id, Hotel hotel) {
        Hotel existingHotel = hotelRepository.findById(id).orElse(null);
        if (existingHotel != null) {
            // Mettez à jour les champs nécessaires de l'employé existant avec les nouvelles valeurs
            existingHotel.setNom(hotel.getNom());
            existingHotel.setAdresse(hotel.getAdresse());
            existingHotel.setDescription(hotel.getDescription());
            existingHotel.setEtoiles(hotel.getEtoiles());
            existingHotel.setPrixParNuit(hotel.getPrixParNuit());

            // Enregistrez les modifications dans la base de données
            return hotelRepository.save(existingHotel);
        }
        return null;
    }

    @Override
    public void deleteHotel(Integer id) {
        hotelRepository.deleteById(id);
    }


}
