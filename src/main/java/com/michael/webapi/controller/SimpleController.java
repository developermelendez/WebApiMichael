package com.michael.webapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.michael.webapi.service.MathService;

@RestController
@RequestMapping("/api")
public class SimpleController {

    private final MathService mathService;  

    public SimpleController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/greet")
    public String greet()
    {
        return "Hello, welcome to the Spring Boot REST API!";
    }

    @GetMapping("/api/echo")
    public String echo(@RequestParam String message) {
        return message;
    }

    @GetMapping("/api/square")
    public double square(@RequestParam double number) {
        return mathService.square(number);
    }

}
