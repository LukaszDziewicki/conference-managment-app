package com.example.conferencemanagmentapp.repository;

import com.example.conferencemanagmentapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    User findUserByLogin(String login);
    User findUserByLoginAndEmail(String login, String email);

    boolean existsUserByLoginAndEmailIsNotLike(String login, String email);

    boolean existsUserByLoginAndEmail(String login, String email);

    @Override
    <S extends User> List<S> saveAll(Iterable<S> iterable);
}
