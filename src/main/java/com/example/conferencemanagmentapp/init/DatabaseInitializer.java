package com.example.conferencemanagmentapp.init;

import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.model.entity.User;
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
        addExampleUsersToDB();
    }





    public void addExampleUsersToDB(){
        User firstUser = new User("lukasz", "lukasz@gmail.com");
        User secondUser = new User("adam", "adam@gmail.com");
        User thirdUser = new User("krzysztof", "krzysztof@gmail.com");

        userService.save(firstUser);
        userService.save(secondUser);
        userService.save(thirdUser);

        //TODO add users to DB as list

        makeReservation(firstUser, 1, 1);
        makeReservation(firstUser, 2, 1);
        makeReservation(firstUser, 3, 1);
    }


    public void makeReservation(User user, int lectureId, int lectureRootMapKey){
        Reservation reservation = new Reservation(user, lectureId, lectureRootMapKey);

        ConferenceInitializer.CONFERENCE.getLectures().get(lectureId - 1).getLectureRoots().get(lectureRootMapKey).getUsers().add(user);
        // TODO zminiejszyć ilość miejsc na prelekcji po rezerwacji
        // TODO upewniamy się czy user nie ma już zrobionej rezerwacji
        // TODO czy są miejsca
        reservationService.save(reservation);

    }

}
