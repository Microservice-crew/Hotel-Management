package com.example.hotelmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class HotelManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagementServiceApplication.class, args);
    }

}
