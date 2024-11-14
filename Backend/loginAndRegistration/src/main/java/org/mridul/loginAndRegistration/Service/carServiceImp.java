package org.mridul.loginAndRegistration.Service;

import org.mridul.loginAndRegistration.DTO.carDto;
import org.mridul.loginAndRegistration.Entity.CarEntity;
import org.mridul.loginAndRegistration.Repository.carRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class carServiceImp implements carService {
    @Autowired
    carRepository carrepo;

    @Override
    public Boolean postCar(carDto cardto) throws IOException {
        try{
            CarEntity car = new CarEntity();
            car.setTitle(cardto.getTitle());
            car.setDescription(cardto.getDescription());
            car.setTag(cardto.getTag());
            car.setImage(cardto.getImage().getBytes());
            carrepo.save(car);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<carDto> listOfCars() {
        return carrepo.findAll().stream().map(CarEntity::getCarDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long id) {
        carrepo.deleteById(id);
    }

    @Override
    public carDto getCar(Long id) {
        Optional<CarEntity> optionalCar = carrepo.findById(id);
        return optionalCar.map(CarEntity::getCarDto).orElse(null);
    }

    @Override
    public Boolean updateCar(Long id, carDto cardto) throws IOException {
        Optional<CarEntity> optionalCar = carrepo.findById(id);
        if(optionalCar.isPresent()){
            CarEntity existingCar= optionalCar.get();
            if(cardto.getImage()!=null){
                existingCar.setImage(cardto.getImage().getBytes());}
                existingCar.setTitle(cardto.getTitle());
                existingCar.setTag(cardto.getTag());
                existingCar.setDescription(cardto.getDescription());
                carrepo.save(existingCar);
                return true;
            }
        else{return false;}
        }

    }

