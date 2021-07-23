package com.example.conferencemanagmentapp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Email {
    private LocalDateTime sendDateTime;
    private String recipient;
    private String content;
}
