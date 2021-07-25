package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.model.Email;
import com.example.conferencemanagmentapp.model.LectureRoot;
import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.model.entity.User;
import com.example.conferencemanagmentapp.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl {

    private final ReservationRepository reservationRepository;
    private final UserServiceImpl userService;
    private final ConferencesServiceImpl conferencesService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserServiceImpl userService, ConferencesServiceImpl conferencesService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.conferencesService = conferencesService;
    }

    public boolean makeReservation(User user, int lectureId, int lectureRootMapKey) {
        LectureRoot lectureRoot = conferencesService.getLectureRootByIdAndKey(lectureId, lectureRootMapKey);
        Reservation reservation = new Reservation(user, lectureId, lectureRootMapKey);
        Email email = new Email(user.getEmail());

        if (existsReservation(user.getLogin(), user.getEmail(), lectureId)) {
            return false;
        } else if (conferencesService.isSpaceAvailable(lectureRoot)) {
            save(reservation);
            sendEmail(email);
            return true;
        }
        return false;
    }

    private boolean existsReservation(String login, String email, int lectureId){
        return reservationRepository.existsReservationByUserLoginAndUserEmailAndLectureId(login, email, lectureId);
    }

    private void save(Reservation reservation) {
        reservationRepository.save(reservation);
       conferencesService.saveUserToLecture(
                reservation.getUser(),
                reservation.getLectureId(),
                reservation.getLectureRootMapKey()
        );
    }

    private void sendEmail(Email email) {
        String filePath = "src/main/resources/powiadomienia.txt";

        try {
            Files.write(
                    Paths.get(filePath),
                    email.toString().getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    public List<Reservation> findReservationsByUserLogin(String login) {
        return reservationRepository.findReservationsByUserLogin(login);
    }




}
