package org.mridul.loginAndRegistration.Service;

import org.mridul.loginAndRegistration.DTO.carDto;

import java.io.IOException;
import java.util.List;

public interface carService {
    Boolean postCar(carDto cardto) throws IOException;
    List<carDto> listOfCars();
    void deleteCar(Long id);
    carDto getCar(Long id);
    Boolean updateCar(Long id,carDto cardto) throws IOException;
}
