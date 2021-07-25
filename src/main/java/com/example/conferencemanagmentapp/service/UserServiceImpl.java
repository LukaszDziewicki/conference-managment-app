package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.model.entity.User;
import com.example.conferencemanagmentapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Set<User> findAll(){
        List<User> userList = null;
        userList = userRepository.findAll();
        Set<User> usersSet = new HashSet<User>(userList);
        return usersSet;
    }

    public boolean existsUserByLoginAndEmailIsNot(String login, String email){
        return userRepository.existsUserByLoginAndEmailIsNot(login, email);
    }





}
