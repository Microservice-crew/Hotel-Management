package com.example.hotelmanagementservice.dao.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;
    private String fullName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private role role;
    private String gender;
    private String picture;
    private String coverPhoto;
    private String numTel;
    private String city;
    private String expertise;




    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", gender='" + gender + '\'' +
                ", picture='" + picture + '\'' +
                ", coverPhoto='" + coverPhoto + '\'' +
                ", numTel='" + numTel + '\'' +
                ", city='" + city + '\'' +
                ", expertise='" + expertise + '\'' +
                '}';
    }
}
