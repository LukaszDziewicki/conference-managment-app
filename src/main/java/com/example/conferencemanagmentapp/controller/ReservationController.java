package com.example.conferencemanagmentapp.controller;

import com.example.conferencemanagmentapp.model.View;
import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.service.ReservationServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationServiceImpl reservationService;

    public ReservationController(ReservationServiceImpl reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @JsonView(View.UserReservations.class)
    public ResponseEntity<List<Reservation>> getUserReservations(@RequestParam(value = "login") String login) {
        try {
            List<Reservation> UserReservationsList = reservationService.findReservationsByUserLogin(login);

            if(UserReservationsList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else
                return new ResponseEntity<>(UserReservationsList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
