package com.example.conferencemanagmentapp.init;

import com.example.conferencemanagmentapp.model.Email;
import com.example.conferencemanagmentapp.service.ReservationServiceImpl;
import com.example.conferencemanagmentapp.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner{


    private final UserServiceImpl userService;
    private final ReservationServiceImpl reservationService;

    public DatabaseInitializer(UserServiceImpl userService, ReservationServiceImpl reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @Override
    public void run(String... args) {
        reservationService.sendEmail(new Email("lukasz@gmail"));
    }


}
