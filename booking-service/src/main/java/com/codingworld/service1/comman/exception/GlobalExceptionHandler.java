package com.codingworld.service1.comman.exception;

import com.codingworld.service1.book.modal.Book;
import com.codingworld.service1.comman.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GenericResponse> resourceNotFoundException(ResoureNotFoundException ex){
        //ex.getMsg();
        //HttpStatus status = HttpStatus.NOT_FOUND;
        HttpStatus status = HttpStatus.NOT_FOUND; // 404

        return new ResponseEntity<>(
                new GenericResponse(
                        status,
                        ex.getMessage()
                ),
                status
        );
    }


}
