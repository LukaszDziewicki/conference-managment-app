package com.example.conferencemanagmentapp.model;

import lombok.Data;

import java.time.LocalTime;
import java.util.Map;

@Data
public class Lecture {
    private Long id;
    private LocalTime start;
    private LocalTime end;
    private Map<Integer, LectureRoot> lectureRoots;

    public Lecture(Long id, LocalTime start, LocalTime end, Map<Integer, LectureRoot> lectureRoots) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.lectureRoots = lectureRoots;
    }
}
