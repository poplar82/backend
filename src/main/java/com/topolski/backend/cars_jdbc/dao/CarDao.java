package com.topolski.backend.cars_jdbc.dao;

import com.topolski.backend.cars_jdbc.model.Car;
import com.topolski.backend.cars_jdbc.model.Color;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> getAllCars();
    List<Car> getCarsByColor(Color color);
    Optional<Car> getCarById(Long id);
    boolean addCar(Car car);
    boolean deleteCarById(Long id);
    boolean updateCarById(Car car);
}
