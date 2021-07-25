package com.example.conferencemanagmentapp.controller;

import com.example.conferencemanagmentapp.model.Conference;
import com.example.conferencemanagmentapp.model.View;
import com.example.conferencemanagmentapp.service.ConferencesServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {
    private final ConferencesServiceImpl conferencesService;

    public ConferenceController(ConferencesServiceImpl conferencesService) {
        this.conferencesService = conferencesService;
    }


    @GetMapping("/plan")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.ConferencePlan.class)
    public ResponseEntity<Conference>  getConferencePlan(){
       Conference conference = conferencesService.getConference();
       if (Objects.isNull(conference)) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       } else
           return new ResponseEntity<>(conference, HttpStatus.OK);
    }

}
