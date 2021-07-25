package com.example.conferencemanagmentapp.repository;

import com.example.conferencemanagmentapp.model.entity.Reservation;
import com.example.conferencemanagmentapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findReservationsByUserLogin(String login);
    void deleteReservationByUserIdAndLectureId(Long UserId, int lectureId);

    boolean existsReservationByUserLoginAndUserEmailAndLectureId(String login, String email, int lectureId);

    boolean existsReservationByUserAndLectureId(User user, int lectureId);

}
