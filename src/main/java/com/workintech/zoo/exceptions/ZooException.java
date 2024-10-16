package com.workintech.zoo.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ZooException extends RuntimeException{
    private HttpStatus httpStatus;

    public ZooException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
