package com.example.conferencemanagmentapp.model;

import com.example.conferencemanagmentapp.model.entity.User;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class LectureRoot {

    @JsonView(View.ConferencePlan.class)
    private String title;

    @JsonView(View.ConferencePlan.class)
    private int freeSpace = 5;

    private List<User> users = new ArrayList<>();

    public LectureRoot(String title) {
        this.title = title;
    }
}
