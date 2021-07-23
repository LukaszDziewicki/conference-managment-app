package com.example.conferencemanagmentapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import java.time.LocalTime;

@Data
public class ConferenceBreak {

    @JsonView(View.ConferencePlan.class)
    private LocalTime breakFrom;

    @JsonView(View.ConferencePlan.class)
    private LocalTime breakTo;

    public ConferenceBreak(LocalTime breakFrom, LocalTime breakTo) {
        this.breakFrom = breakFrom;
        this.breakTo = breakTo;
    }
}
