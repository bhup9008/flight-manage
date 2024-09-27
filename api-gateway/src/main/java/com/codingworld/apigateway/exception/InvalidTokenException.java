package com.codingworld.apigateway.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidTokenException extends ResponseStatusException {
    private String msg;
    public InvalidTokenException(HttpStatus status,String msg) {
        super(status,msg);
        //this.msg=msg;
    }
}
