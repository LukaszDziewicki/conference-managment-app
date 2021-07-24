package com.example.conferencemanagmentapp.controller;

import com.example.conferencemanagmentapp.error.exception.ConferenceNotFoundException;
import com.example.conferencemanagmentapp.model.Conference;
import com.example.conferencemanagmentapp.model.View;
import com.example.conferencemanagmentapp.service.ConferencesServiceImpl;
import com.example.conferencemanagmentapp.service.ReservationServiceImpl;
import com.example.conferencemanagmentapp.service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {
    private final ReservationServiceImpl reservationService;
    private final UserServiceImpl userService;
    private final ConferencesServiceImpl conferencesService;

    public ConferenceController(ReservationServiceImpl reservationService, UserServiceImpl userService, ConferencesServiceImpl conferencesService) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.conferencesService = conferencesService;
    }

    @GetMapping("/plan")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.ConferencePlan.class)
    public Conference getConferencePlan(){
        try {
            return conferencesService.getConference();
        }catch (RuntimeException e){
            throw new ConferenceNotFoundException();
        }
    }

}
