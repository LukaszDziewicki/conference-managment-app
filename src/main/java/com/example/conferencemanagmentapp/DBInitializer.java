package com.example.conferencemanagmentapp;

import com.example.conferencemanagmentapp.model.Conference;
import com.example.conferencemanagmentapp.model.Lecture;
import com.example.conferencemanagmentapp.model.ConferenceBreak;
import com.example.conferencemanagmentapp.model.LectureRoot;
import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.model.entity.User;
import com.example.conferencemanagmentapp.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Component
public class DBInitializer implements CommandLineRunner{
    private final UserServiceImpl userService;

    public DBInitializer(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
    generateConference();
    addExampleUsersToDB();
    }


    private Conference generateConference(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s");

        return new Conference(
                1L,
                LocalDateTime.parse("2021-01-06 10:00:00", dateTimeFormatter),
                LocalDateTime.parse("2021-01-06 15:45:00", dateTimeFormatter),
                generateLectures(),
                generateConferenceBreaks()
        );
    }

    private Map<LocalTime, Lecture> generateLectures(){
        Map<LocalTime, Lecture> lectures = new TreeMap<>();

        lectures.put(
                LocalTime.of(10, 0),
                new Lecture(
                        1L,
                        LocalTime.of(10, 0),
                        LocalTime.of(11, 45),
                        generateThreeExampleLectureRoots()
                )
        );

        lectures.put(
                LocalTime.of(12, 0),
                new Lecture(
                        2L,
                        LocalTime.of(10, 0),
                        LocalTime.of(11, 45),
                        generateThreeExampleLectureRoots()
                )
        );

        lectures.put(
                LocalTime.of(12, 0),
                new Lecture(
                        3L,
                        LocalTime.of(10, 0),
                        LocalTime.of(11, 45),
                        generateThreeExampleLectureRoots()
                )
        );

        return lectures;
    }

    private Map<Integer, LectureRoot> generateThreeExampleLectureRoots(){
        Map<Integer, LectureRoot> lectureRoots = new TreeMap<>();
        lectureRoots.put(1, new LectureRoot("Backend Development"));
        lectureRoots.put(2, new LectureRoot("Frontend Development"));
        lectureRoots.put(3, new LectureRoot("Web Development"));
        return lectureRoots;
    }

    private Set<ConferenceBreak> generateConferenceBreaks(){
    Set<ConferenceBreak> conferenceBreaks = new HashSet<>();
    conferenceBreaks.add(
            new ConferenceBreak(
                    LocalTime.of(11, 45),
                    LocalTime.of(12, 0)
            )
    );

        conferenceBreaks.add(
                new ConferenceBreak(
                        LocalTime.of(13, 45),
                        LocalTime.of(14, 0)
                )
        );

        return conferenceBreaks;
    }

    //TODO add method addExampleUsersToDB()
    private void addExampleUsersToDB(){
        Set<Reservation> reservations = new HashSet<>();
        User user = new User("Login", "email", reservations);
        Reservation reservation = new Reservation(user, 1L, 1);
        user.getReservations().add(reservation);
        userService.save(user);
    }

}
