package com.example.conferencemanagmentapp.model;

import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.TreeMap;

@Data
public class Conference {
    private Long id;

    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;

    private Map<LocalTime, Lecture> lectures;
    //TreeMap

    public Conference(Long id, LocalDateTime fromDateTime, LocalDateTime toDateTime, Map<LocalTime, Lecture> lectures) {
        this.id = id;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.lectures = lectures;
    }

  /*
    private Set<Lecture> lectureSet;
    private List<Lecture> lectureList;
    */
}
