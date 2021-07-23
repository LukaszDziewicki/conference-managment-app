package com.example.conferencemanagmentapp.error.exception;

public class ConferenceNotFoundException extends RuntimeException {
    public ConferenceNotFoundException() {
        super("Conference not found");
    }
}
