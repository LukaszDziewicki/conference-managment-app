package com.example.conferencemanagmentapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import java.time.LocalTime;
import java.util.Map;

@Data
public class Lecture {
    private int id;

    @JsonView(View.ConferencePlan.class)
    private LocalTime start;

    @JsonView(View.ConferencePlan.class)
    private LocalTime end;

    @JsonView(View.ConferencePlan.class)
    private Map<Integer, LectureRoot> lectureRoots;

    public Lecture(int id, LocalTime start, LocalTime end, Map<Integer, LectureRoot> lectureRoots) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.lectureRoots = lectureRoots;
    }
}
