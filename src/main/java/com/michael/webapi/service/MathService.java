package com.michael.webapi.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.michael.webapi.exceptions.ToDoExceptions;
import com.michael.webapi.service.interfaces.MathInterface;

@Service
public class MathService implements MathInterface {

    @Override
    public double square(double number) {

        try {
            
            if(number < 0 || Double.isInfinite(number) || Double.isNaN(number))
            {
                throw new ToDoExceptions("Invalid number", HttpStatus.BAD_REQUEST);
            }

            return Math.sqrt(number);

        } catch (Exception e) {
            throw new ToDoExceptions("The operation could no be performed", HttpStatus.BAD_REQUEST);
        }
    }

}
