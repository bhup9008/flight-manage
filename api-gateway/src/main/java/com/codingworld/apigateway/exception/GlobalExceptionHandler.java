package com.codingworld.apigateway.exception;

import com.codingworld.apigateway.comman.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Map<String, Object> handleBadCredentialsException(
            BadCredentialsException e, WebRequest webRequest
    ){
        return createExceptionMessage(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED, webRequest);
    }

    @ExceptionHandler(TokenMissing.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidationException(TokenMissing e, WebRequest webRequest){
        System.out.println("nzdxnasndini");
        return createExceptionMessage(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST, webRequest);

    }


    private Map<String,Object> createExceptionMessage(String e, HttpStatus status, WebRequest webRequest) {

        Map <String, Object> error = new HashMap<>();
        String timestamp = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);

        if(webRequest instanceof ServletWebRequest){
            error.put("uri",
                    ((ServletWebRequest)webRequest).getRequest().getRequestURI());
        }
        error.put("message", e);
        error.put("status code", status.value());
        error.put("timestamp", timestamp);
        error.put("reason", status.getReasonPhrase());
        return error;
    }
}
