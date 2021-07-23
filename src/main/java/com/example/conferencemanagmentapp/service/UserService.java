package com.example.conferencemanagmentapp.service;

import com.example.conferencemanagmentapp.model.Email;
import com.example.conferencemanagmentapp.model.entity.User;

public interface UserService {
    void save(User user);

    boolean sendEmail(Email email);

}
