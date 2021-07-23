package com.example.conferencemanagmentapp.model.entity;

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
    private Long id;
    @ManyToOne
    @JoinColumn
    private User user;
    private int lectureId;
    private int lectureRootMapKey;

    public Reservation(User user, int lectureId, int lectureRootMapKey) {
        this.user = user;
        this.lectureId = lectureId;
        this.lectureRootMapKey = lectureRootMapKey;
    }


}
