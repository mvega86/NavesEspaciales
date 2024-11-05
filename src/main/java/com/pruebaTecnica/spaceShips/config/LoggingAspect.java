package com.pruebaTecnica.spaceShips.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.spaceships.SpaceShipController.getById(..)) && args(id)")
    public void logNegativeId(Long id) {
        if (id < 0) {
            logger.warn("A spacecraft with a negative ID was requested: {}", id);
        }
    }
}
