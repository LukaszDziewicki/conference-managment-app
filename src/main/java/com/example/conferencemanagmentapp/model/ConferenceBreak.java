package com.example.conferencemanagmentapp.model;

import lombok.Data;
import java.time.LocalTime;

@Data
public class ConferenceBreak {
    private LocalTime breakFrom;
    private LocalTime breakTo;

    public ConferenceBreak(LocalTime breakFrom, LocalTime breakTo) {
        this.breakFrom = breakFrom;
        this.breakTo = breakTo;
    }
}
