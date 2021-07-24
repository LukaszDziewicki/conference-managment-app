package com.example.conferencemanagmentapp.controller;

import com.example.conferencemanagmentapp.model.View;
import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.service.ConferencesServiceImpl;
import com.example.conferencemanagmentapp.service.ReservationServiceImpl;
import com.example.conferencemanagmentapp.service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
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

   /* // TODO:
    @PostMapping("/{lectureId}/{lectureRootMapKey}")
    @JsonView(View.ConferencePlan.class)
    public ResponseEntity<String> makeReservation(@PathVariable(value = "lectureId") int lectureId,
                                                  @PathVariable(value = "lectureRootMapKey") int lectureRootMapKey,
                                                  @RequestBody User user){


        if(userService.existsUserByLoginAndEmailIsNotLike(user.getLogin(), user.getEmail())){
            //TODO: komunikat (Podany login jest już zajęty”.)
        }else if (reservationService.makeReservation(user, lectureId, lectureRootMapKey)){
           //TODO: komunikat rezerwacja się powiodła
        }
        }

        return ResponseEntity.ok("Possible reservations, Email sended");
    }*/
}
