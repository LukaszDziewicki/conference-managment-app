package com.example.conferencemanagmentapp.controller;

import com.example.conferencemanagmentapp.model.View;
import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.model.entity.User;
import com.example.conferencemanagmentapp.service.ConferencesServiceImpl;
import com.example.conferencemanagmentapp.service.ReservationServiceImpl;
import com.example.conferencemanagmentapp.service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationServiceImpl reservationService;
    private final UserServiceImpl userService;
    private final ConferencesServiceImpl conferencesService;

    public ReservationController(ReservationServiceImpl reservationService, UserServiceImpl userService, ConferencesServiceImpl conferencesService) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.conferencesService = conferencesService;
    }

    @PostMapping("/")
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


    @PostMapping("/{lectureId}/{lectureRootMapKey}")
    @JsonView(View.ConferencePlan.class)
    public ResponseEntity<String> makeReservation(@PathVariable(value = "lectureId") @Valid @Min(1)@Max(3) int lectureId,
                                                  @PathVariable(value = "lectureRootMapKey")@Valid @Min(1)@Max(3) int lectureRootMapKey,
                                                  @RequestBody User user){


        if(userService.existsUserByLoginAndEmailIsNot(user.getLogin(), user.getEmail())){
            return new ResponseEntity<>("Podany login jest już zajęty", HttpStatus.NOT_FOUND);
        } else if(reservationService.makeReservation(user, lectureId, lectureRootMapKey)){
            return ResponseEntity.ok("Possible reservations, Email sended");
        }
        return new ResponseEntity<>("Brak miejsc lub jesteś już zarejestrowany", HttpStatus.NOT_FOUND);


    }
}
