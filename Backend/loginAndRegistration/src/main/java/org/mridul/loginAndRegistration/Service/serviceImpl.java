package org.mridul.loginAndRegistration.Service;

import org.mridul.loginAndRegistration.DTO.loginDto;
import org.mridul.loginAndRegistration.DTO.userCredDto;
import org.mridul.loginAndRegistration.Entity.userCredEntity;
import org.mridul.loginAndRegistration.ExceptionHandeler.UserAlreadyExistsException;
import org.mridul.loginAndRegistration.Repository.loginRegRepo;
import org.mridul.loginAndRegistration.Response.loginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class serviceImpl implements loginRegisterService{
    @Autowired
    loginRegRepo repo;

    @Override
    public userCredEntity addUsers(userCredDto userData) {
        userCredEntity userCreds = new userCredEntity();
        BeanUtils.copyProperties(userData,userCreds);
        userCredEntity check = repo.findByEmail(userData.getEmail());
        if(check!=null){
            throw new UserAlreadyExistsException("User Already Exists");
        }
        else{
            return repo.save(userCreds);
        }
//        if(check.isPresent()){
//            throw new ("User Already Exists");
//        }
//        else {
//            return repo.save(userCreds);
//        }
    }

    @Override
//    public loginResponse loginUser(loginDto logindto) {
//        String msg = "";
//        userCredEntity user =repo.findByEmail(logindto.getEmail());
//        if(user!=null){
//            String passwordFromUser = logindto.getPassword();
//            String passwordFromDb = user.getPassword();
//            Boolean isRight = passwordFromDb.equals(passwordFromUser);
//            if(isRight){
//                Optional<userCredEntity> user1 = repo.findOneByEmailAndPassword(logindto.getEmail(), passwordFromDb);
//                if(user1.isPresent()){
//                    return new loginResponse("Login Success",true);
//                }
//                else {
//                    return new loginResponse("Login Failed",false);
//                }
//            }
//            else {
//                return new loginResponse("Password Not Matched",false);
//            }
//        }
//        else{
//            return new loginResponse("Email doesn't Exist", false);
//
//        }
    public Boolean loginUser(loginDto logindto) {
        userCredEntity user =repo.findByEmail(logindto.getEmail());
        if(user!=null){
            String passwordFromUser = logindto.getPassword();
            String passwordFromDb = user.getPassword();
            Boolean isRight = passwordFromDb.equals(passwordFromUser);
            if(isRight){
                Optional<userCredEntity> user1 = repo.findOneByEmailAndPassword(logindto.getEmail(), passwordFromDb);
                if(user1.isPresent()){
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else{
            return false;

        }
    }
}
