package com.example.conferencemanagmentapp.model;

import com.example.conferencemanagmentapp.model.entity.User;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class LectureRoot {
    private String title;
    private final int personsLimit = 5; //TODO extract to enum?
    private List<User> users = new ArrayList<>();

    public LectureRoot(String title) {
        this.title = title;
    }
}
