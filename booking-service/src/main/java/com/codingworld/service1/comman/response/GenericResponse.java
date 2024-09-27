package com.codingworld.service1.comman.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    private String stackTrace;

    private Object data;

    public GenericResponse() {
        timestamp = new Date();
    }

    public GenericResponse(
            HttpStatus httpStatus,
            String message
    ) {
        this();

        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public GenericResponse(
            HttpStatus httpStatus,
            String message,
            String stackTrace
    ) {
        this(
                httpStatus,
                message
        );

        this.stackTrace = stackTrace;
    }

    public GenericResponse(
            HttpStatus httpStatus,
            String message,
            String stackTrace,
            Object data
    ) {
        this(
                httpStatus,
                message,
                stackTrace
        );

        this.data = data;
    }
    /*private boolean success;
    private String message;
    private T data;
    private String stackTrace;
    private int code;*/

   /* public static <T> GenericResponse<T> empty() {
        return success(null);
    }

    public static <T> GenericResponse<T> success(T data) {
        return GenericResponse.<T>builder()
                .message("SUCCESS!")
                .data(data)
                .success(true)
                .build();
    }

    public static <T> GenericResponse<T> error(int status,) {
        return GenericResponse.<T>builder()
                .message("ERROR!")
                .success(false)
                .data(data)
                .build();
    }*/
}
