package com.michael.webapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.michael.webapi.exceptions.ToDoExceptions;
import com.michael.webapi.service.interfaces.MathInterface;

@Service
public class MathService implements MathInterface {

    private static final Logger logger = LoggerFactory.getLogger(MathService.class);

    @Override
    public double square(double number) {

        try {

            logger.debug("start function square parameter: " + number);

            if (number < 0 || Double.isInfinite(number) || Double.isNaN(number)) {
                logger.warn("Invalid number for the function square");
                throw new ToDoExceptions("Invalid number", HttpStatus.BAD_REQUEST);
            }

            double result = Math.sqrt(number);
            logger.debug("End function square result: " + result);
            return result;

        } catch (Exception e) {

            logger.error("Error trying  to execute function square", e);
            throw new ToDoExceptions("The operation could no be performed", HttpStatus.BAD_REQUEST);
        }
    }

}
