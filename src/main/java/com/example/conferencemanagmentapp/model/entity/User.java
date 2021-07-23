package com.example.conferencemanagmentapp.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    @OneToMany
    Set<Reservation> reservations = new HashSet<>();
}
