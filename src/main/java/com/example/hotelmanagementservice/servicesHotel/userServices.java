package com.example.hotelmanagementservice.servicesHotel;


import com.example.hotelmanagementservice.dao.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "nodejs-service", url = "http://localhost:9000")
public interface userServices {
    @GetMapping(value = "/user/user/{userId}", produces = "application/json")
    public User getUserById( @PathVariable String userId);
    @GetMapping("/users")
    public List<User> getAllUsers();






}
