package com.example.conferencemanagmentapp.repository;

import com.example.conferencemanagmentapp.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationsByUserLogin(String login);

    boolean existsReservationByUserLoginAndUserEmailAndLectureId(String login, String email, int lectureId);


}
