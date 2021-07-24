package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.model.Email;
import com.example.conferencemanagmentapp.model.entity.User;
import com.example.conferencemanagmentapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void save(User user) {
        userRepository.save(user);
    }

    public void saveAll(List<User> users){
        userRepository.saveAll(users);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public boolean existsUserByLoginAndEmailIsNotLike(String login, String email){
        return userRepository.existsUserByLoginAndEmailIsNotLike(login, email);
    }

    public boolean existsUserByLoginAndEmail(String login, String email){
        return userRepository.existsUserByLoginAndEmail(login, email);
    }



}
