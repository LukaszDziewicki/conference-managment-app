package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.model.Email;
import com.example.conferencemanagmentapp.model.entity.User;
import com.example.conferencemanagmentapp.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean sendEmail(Email email) {
        //TODO mail do pliku o nazwie „powiadomienia”
        return false;
    }

}
