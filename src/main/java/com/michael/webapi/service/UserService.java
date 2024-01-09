package com.michael.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.michael.webapi.exceptions.ToDoExceptions;
import com.michael.webapi.mapper.UserInDtoToUser;
import com.michael.webapi.persistence.entity.User;
import com.michael.webapi.persistence.repository.UserRepository;
import com.michael.webapi.service.dto.UserInDto;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserInDtoToUser mapper;

    public UserService(UserRepository repository, UserInDtoToUser mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public User createUser(UserInDto userInDto) {
        User user = new User();
        try {
            user = mapper.map(userInDto);
            user = this.repository.save(user);
        } catch (Exception e) {
            throw new ToDoExceptions("failed to insert user", HttpStatus.BAD_REQUEST);
        }
        return user;
    }

    public List<User> findAllUsers()
    {
        List<User> users = new ArrayList<>();

        try {
            users = repository.findAll();
        } catch (Exception e) {
            throw new ToDoExceptions("failed to get users", HttpStatus.BAD_REQUEST);
        }
        return users;
    }

}
