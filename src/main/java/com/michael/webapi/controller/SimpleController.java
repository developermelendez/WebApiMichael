package com.michael.webapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping("/greet")
    public String greet()
    {
        return "Hello, welcome to the Spring Boot REST API!";
    }

    @GetMapping("/api/echo")
    public String echo(@RequestParam String message) {
        return message;
    }

}
