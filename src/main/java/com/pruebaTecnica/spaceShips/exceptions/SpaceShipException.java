package com.pruebaTecnica.spaceShips.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SpaceShipException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;

    public SpaceShipException(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
