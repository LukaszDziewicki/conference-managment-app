package com.example.conferencemanagmentapp.model.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;


}
