package com.example.conferencemanagmentapp.model.entity;

import com.example.conferencemanagmentapp.model.View;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.UserReservations.class)
    private Long id;

    @JsonView(View.UserReservations.class)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;

    @JsonView(View.UserReservations.class)
    private int lectureId;

    @JsonView(View.UserReservations.class)
    private int lectureRootMapKey;

    public Reservation(User user, int lectureId, int lectureRootMapKey) {
        this.user = user;
        this.lectureId = lectureId;
        this.lectureRootMapKey = lectureRootMapKey;
    }


}
