package com.example.conferencemanagmentapp.model;

import com.example.conferencemanagmentapp.model.entity.User;
import lombok.Data;

@Data
public class LectureRoot {
    private String title;
    private final int personsLimit = 5; //TODO extract to enum?
    private User[] users = new User[personsLimit];

    public LectureRoot(String title) {
        this.title = title;
    }
}
