package com.example.conferencemanagmentapp.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    @OneToMany(cascade=CascadeType.ALL)
    Set<Reservation> reservations = new HashSet<>();


    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }

    public User(String login, String email, Set<Reservation> reservations) {
        this.login = login;
        this.email = email;
        this.reservations = reservations;
    }
}
