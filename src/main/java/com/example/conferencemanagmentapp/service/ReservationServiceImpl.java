package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ReservationServiceImpl {

   private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public void save(Reservation reservation){
        reservationRepository.save(reservation);
    }

    public List<Reservation> findReservationsByUserLogin(String login){
        return reservationRepository.findReservationsByUserLogin(login);
    }

}
