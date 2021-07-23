package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.init.ConferenceInitializer;
import com.example.conferencemanagmentapp.model.Conference;
import org.springframework.stereotype.Service;

@Service
public class ConferencesService {
    public Conference getConference(){
        return ConferenceInitializer.CONFERENCE;
    }
}
