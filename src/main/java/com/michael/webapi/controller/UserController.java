package com.michael.webapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.michael.webapi.persistence.entity.User;
import com.michael.webapi.service.UserService;
import com.michael.webapi.service.dto.UserInDto;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public User createUser(@RequestBody UserInDto userInDto) {
        return this.userService.createUser(userInDto);
    }

    @GetMapping("/users")
    public List<User> users() {
        return this.userService.findAllUsers();
    }
    

    

}
