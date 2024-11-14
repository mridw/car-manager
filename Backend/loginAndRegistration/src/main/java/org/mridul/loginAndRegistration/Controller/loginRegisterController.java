//package org.mridul.loginAndRegistration.Controller;
//
//import org.mridul.loginAndRegistration.DTO.loginDto;
//import org.mridul.loginAndRegistration.DTO.userCredDto;
//import org.mridul.loginAndRegistration.Entity.userCredEntity;
//import org.mridul.loginAndRegistration.Response.loginResponse;
//import org.mridul.loginAndRegistration.Service.loginRegisterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api")
//@CrossOrigin("http://localhost:4444")
//public class loginRegisterController {
//    @Autowired
//    loginRegisterService service;
//
//    @PostMapping("add")
//    public userCredEntity addUser(@RequestBody userCredDto userData){
//        return service.addUsers(userData);
//    }
//    @PostMapping("login")
//    public Boolean loginUser(@RequestBody loginDto loginCreds){
//        return service.loginUser(loginCreds);
//    }
////    public ResponseEntity<?> loginUser(@RequestBody loginDto loginCreds){
////        loginResponse response = service.loginUser(loginCreds);
////        return ResponseEntity.ok(response);
////    }
//
//}
package org.mridul.loginAndRegistration.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.mridul.loginAndRegistration.DTO.loginDto;
import org.mridul.loginAndRegistration.DTO.userCredDto;
import org.mridul.loginAndRegistration.Entity.userCredEntity;
import org.mridul.loginAndRegistration.Service.loginRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin("http://localhost:4444")
public class loginRegisterController {

    @Autowired
    loginRegisterService service;

    /**
     * Endpoint to add a new user
     * @param userData The user credentials
     * @return The created user entity
     */
    @Operation(summary = "Add a new user",
            description = "Creates a new user in the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User created successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = userCredEntity.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid input data")
            })
    @PostMapping("add")
    public userCredEntity addUser(@RequestBody userCredDto userData) {
        return service.addUsers(userData);
    }

    /**
     * Endpoint for user login
     * @param loginCreds User's login credentials
     * @return True if login is successful, false otherwise
     */
    @Operation(summary = "User Login",
            description = "Validates user credentials and returns login success or failure.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successful",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(type = "boolean"))),
                    @ApiResponse(responseCode = "400", description = "Invalid login credentials")
            })
    @PostMapping("login")
    public Boolean loginUser(@RequestBody loginDto loginCreds) {
        return service.loginUser(loginCreds);
    }

}
