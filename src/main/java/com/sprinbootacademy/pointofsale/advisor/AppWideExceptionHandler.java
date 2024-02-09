package com.sprinbootacademy.pointofsale.advisor;

import com.sprinbootacademy.pointofsale.exception.NotFoundException;
import com.sprinbootacademy.pointofsale.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)// customize class e-massage
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Error", e.getMessage()),
                HttpStatus.OK

        );
    }
}
