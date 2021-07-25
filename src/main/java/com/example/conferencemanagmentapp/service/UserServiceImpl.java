package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsUserByLoginAndEmailIsNot(String login, String email){
        return userRepository.existsUserByLoginAndEmailIsNot(login, email);
    }





}
