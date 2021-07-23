package com.example.conferencemanagmentapp.init;

import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.model.entity.User;
import com.example.conferencemanagmentapp.service.ReservationServiceImpl;
import com.example.conferencemanagmentapp.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitializer implements CommandLineRunner{


    private final UserServiceImpl userService;
    private final ReservationServiceImpl reservationService;

    public DBInitializer(UserServiceImpl userService, ReservationServiceImpl reservationService) {
        this.userService = userService;
        this.reservationService = reservationService;
    }

    @Override
    public void run(String... args) {



        addExampleUsersToDB();
    }





    public void addExampleUsersToDB(){
        User user = new User("Login", "email");
        userService.save(user);
        makeReservation(user, 1, 1);
        makeReservation(user, 2, 1);
        makeReservation(user, 3, 1);
    }


    public void makeReservation(User user, int lectureId, int lectureRootMapKey){
        Reservation reservation = new Reservation(user, lectureId, lectureRootMapKey);

        ConferenceInitializer.CONFERENCE_PLAN.getLectures().get(lectureId - 1).getLectureRoots().get(lectureRootMapKey).getUsers().add(user);

        //upewniamy się czy user nie ma już zrobionej rezerwacji
        //czy są miejsca
        reservationService.save(reservation);

    }

}
