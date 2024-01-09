package com.michael.webapi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.michael.webapi.exceptions.ToDoExceptions;
import com.michael.webapi.mapper.UserInDtoToUser;
import com.michael.webapi.persistence.entity.User;
import com.michael.webapi.persistence.repository.UserRepository;
import com.michael.webapi.service.dto.UserInDto;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;
    private final UserInDtoToUser mapper;

    public UserService(UserRepository repository, UserInDtoToUser mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public User createUser(UserInDto userInDto) {

        if (userInDto.getName() == null) {
            logger.warn("Object UserInDto is empty");
            throw new ToDoExceptions("Invalid object", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        try {
            user = mapper.map(userInDto);
            logger.debug("start function createUser parameter: " + user.getName());  

            user = this.repository.save(user);

            logger.debug("End function createUser result: " + user.getId() + " - " + user.getName());  
        } catch (Exception e) {
            logger.error("Error trying insert user: ",e);  
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
            logger.error("Error trying get all users: ",e);  
            throw new ToDoExceptions("failed to get users", HttpStatus.BAD_REQUEST);
        }        
        return users;
    }

}
