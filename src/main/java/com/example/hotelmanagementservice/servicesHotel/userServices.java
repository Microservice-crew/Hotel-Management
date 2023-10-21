package com.example.hotelmanagementservice.servicesHotel;


import com.example.hotelmanagementservice.dao.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "nodejs-service")
public interface userServices {


    @GetMapping("/users")
    public List<User> findAll();

    @GetMapping("/users/{idUser}")
    public User findById(@PathVariable String idUser);



}
