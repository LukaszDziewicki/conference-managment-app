package com.example.conferencemanagmentapp.model.entity;

import com.example.conferencemanagmentapp.model.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView({View.UserReservations.class, View.UserList.class})
    private String login;

    @JsonView(View.UserList.class)
    private String email;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Reservation> reservations = new ArrayList<>();

    public User(String login, String email) {
        this.login = login;
        this.email = email;
    }


}
