package org.mridul.loginAndRegistration.ExceptionHandeler;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String message){
    super(message);
    }
}
