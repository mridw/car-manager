package org.mridul.loginAndRegistration.Service;

import org.mridul.loginAndRegistration.DTO.loginDto;
import org.mridul.loginAndRegistration.DTO.userCredDto;
import org.mridul.loginAndRegistration.Entity.userCredEntity;
import org.mridul.loginAndRegistration.Response.loginResponse;

public interface loginRegisterService {
    userCredEntity addUsers(userCredDto userData);
//    loginResponse loginUser(loginDto logindto);
    Boolean loginUser(loginDto logindto);
}

