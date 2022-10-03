package com.driveCar.model.exception;

public class NoSuchDriverException extends RuntimeException{

    public NoSuchDriverException(String message) {
        super(message);
    }
}