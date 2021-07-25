package com.example.conferencemanagmentapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Conference {
    private Long id;

    @JsonView(View.ConferencePlan.class)
    private LocalDateTime fromDateTime;

    @JsonView(View.ConferencePlan.class)
    private LocalDateTime toDateTime;

    @JsonView(View.ConferencePlan.class)
    private List<Lecture> lectures;

    @JsonView(View.ConferencePlan.class)
    private List<ConferenceBreak> breaksBetweenLectures;

    public Conference(Long id, LocalDateTime fromDateTime, LocalDateTime toDateTime, List<Lecture> lectures, List<ConferenceBreak> breaksBetweenLectures) {
        this.id = id;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.lectures = lectures;
        this.breaksBetweenLectures = breaksBetweenLectures;
    }
}
