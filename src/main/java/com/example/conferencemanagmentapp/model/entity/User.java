package com.example.conferencemanagmentapp.model.entity;

import com.example.conferencemanagmentapp.model.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonView(View.UserReservations.class)
    private String login;

    private String email;

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }
}
