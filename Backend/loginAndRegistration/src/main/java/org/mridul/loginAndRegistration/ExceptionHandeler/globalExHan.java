package org.mridul.loginAndRegistration.ExceptionHandeler;

import org.mridul.loginAndRegistration.Response.loginResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class globalExHan {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<loginResponse> handleUserAlreadyExistsException(UserAlreadyExistsException exception){
        String message = exception.getMessage();
        loginResponse response = new loginResponse(message,false);
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);

    }
}
