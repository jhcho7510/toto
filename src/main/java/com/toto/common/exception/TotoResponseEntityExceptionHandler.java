package com.toto.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class TotoResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> operateAllException(
            Exception ex, WebRequest request) {
        TotoExceptionResponse response =
                new TotoExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false)
                );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TotoException.class)
    public final ResponseEntity<Object> operateTotoException(
            Exception ex, WebRequest request) {
        TotoExceptionResponse response =
                new TotoExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false)
                );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


}
