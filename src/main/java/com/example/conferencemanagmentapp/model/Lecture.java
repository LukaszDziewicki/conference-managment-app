package com.example.conferencemanagmentapp.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

public class Lecture {
    private Long id;
    private LocalTime start;
    private LocalTime end;
    private Map<Integer, LectureRoot> lectureRoots;
    // TreeMap<>();
    //ścieżka_1:  key:1 value: lectureRoot

    private final Duration lectureBreak = Duration.parse("PT15M");

    public Lecture(Long id, LocalTime start, LocalTime end, Map<Integer, LectureRoot> lectureRoots) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.lectureRoots = lectureRoots;
    }
}
