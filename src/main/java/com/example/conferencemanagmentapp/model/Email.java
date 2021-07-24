package com.example.conferencemanagmentapp.model;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Email {
    private String userEmail;
    private final LocalDate sendDateTime = LocalDate.now();
    private final String emailContent = "Rezerwacja zakończyła się pomyślnie";

    public Email(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return userEmail + "\n"+
                sendDateTime + "\n"+
                emailContent + "\n"+
                "\n";

    }
}
