package com.example.conferencemanagmentapp.repository;

import com.example.conferencemanagmentapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    User findUserByLogin(String login);
    User findUserByLoginAndEmail(String login, String email);
    boolean existsUserByLogin(String login);
    boolean existsUserByLoginAndEmail(String login, String email);
}