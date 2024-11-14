//package org.mridul.loginAndRegistration.Controller;
//
//import org.mridul.loginAndRegistration.DTO.carDto;
//import org.mridul.loginAndRegistration.Service.carService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("api/car")
//@CrossOrigin("http://localhost:4444")
//public class carController {
//    @Autowired
//    carService carservice;
//    @PostMapping("addCar")
//    public ResponseEntity<?> postCar(@ModelAttribute carDto cardto) throws IOException {
//        boolean success =  carservice.postCar(cardto);
//        if(success){
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }
//        else{
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }
//    @GetMapping("getCars")
//    public ResponseEntity<?> getAllCars(){
//        return  ResponseEntity.ok(carservice.listOfCars());
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteCar(@PathVariable Long id){
//        carservice.deleteCar(id);
//        return ResponseEntity.ok(null);
//    }
//    @GetMapping("{id}")
//    public ResponseEntity<carDto> getCar(@PathVariable Long id){
//        carDto cardto =  carservice.getCar(id);
//        return ResponseEntity.ok(cardto);
//    }
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Void> updateCar(@PathVariable Long id,@ModelAttribute carDto cardto) throws IOException {
//        try {
//            boolean success = carservice.updateCar(id, cardto);
//            if (success)
//                return ResponseEntity.status(HttpStatus.OK).build();
//
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//    }
//}
package org.mridul.loginAndRegistration.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.mridul.loginAndRegistration.DTO.carDto;
import org.mridul.loginAndRegistration.Service.carService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("api/car")
@CrossOrigin("http://localhost:4444")
public class carController {

    @Autowired
    carService carservice;

    /**
     * Endpoint to add a new car
     * @param cardto Car details to be added
     * @return ResponseEntity indicating the success or failure of the operation
     */
    @Operation(summary = "Add a new car",
            description = "Creates a new car in the system.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Car created successfully",
                            content = @Content(mediaType = "application/json")),
                    @ApiResponse(responseCode = "400", description = "Invalid car data provided")
            })
    @PostMapping("addCar")
    public ResponseEntity<?> postCar(@ModelAttribute carDto cardto) throws IOException {
        boolean success = carservice.postCar(cardto);
        if(success){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    /**
     * Endpoint to fetch all cars
     * @return List of all cars
     */
    @Operation(summary = "Get all cars",
            description = "Retrieves a list of all cars.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of cars retrieved successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = carDto.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("getCars")
    public ResponseEntity<?> getAllCars() {
        return ResponseEntity.ok(carservice.listOfCars());
    }

    /**
     * Endpoint to delete a car by ID
     * @param id ID of the car to be deleted
     * @return ResponseEntity indicating the success or failure of the operation
     */
    @Operation(summary = "Delete a car",
            description = "Deletes a car from the system by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Car deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "Car not found")
            })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carservice.deleteCar(id);
        return ResponseEntity.ok(null);
    }

    /**
     * Endpoint to get details of a car by ID
     * @param id ID of the car to fetch
     * @return Car details
     */
    @Operation(summary = "Get car by ID",
            description = "Fetches details of a car by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Car details retrieved successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = carDto.class))),
                    @ApiResponse(responseCode = "404", description = "Car not found")
            })
    @GetMapping("{id}")
    public ResponseEntity<carDto> getCar(@PathVariable Long id) {
        carDto cardto = carservice.getCar(id);
        return ResponseEntity.ok(cardto);
    }

    /**
     * Endpoint to update an existing car's details
     * @param id ID of the car to update
     * @param cardto Updated car details
     * @return ResponseEntity indicating the success or failure of the operation
     */
    @Operation(summary = "Update car by ID",
            description = "Updates the details of an existing car.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Car updated successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid car data"),
                    @ApiResponse(responseCode = "404", description = "Car not found")
            })
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable Long id, @ModelAttribute carDto cardto) throws IOException {
        try {
            boolean success = carservice.updateCar(id, cardto);
            if (success) {
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
