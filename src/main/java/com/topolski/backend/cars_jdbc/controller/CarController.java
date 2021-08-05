package com.topolski.backend.cars_jdbc.controller;

import com.topolski.backend.cars_jdbc.dao.CarDao;
import com.topolski.backend.cars_jdbc.model.Car;
import com.topolski.backend.cars_jdbc.model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/cars")
@CrossOrigin
public class CarController {
    private final CarDao carDao;
    @Autowired
    public CarController(final CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<Car>> getAllCars() {
        List<Car> cars = carDao.getAllCars();
        setHATEOAS(cars);
        if (cars.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CollectionModel.of(cars,
                        linkTo(CarController.class)
                                .withSelfRel()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Car>> getCarById(@PathVariable final long id) {
        Optional<Car> carOptional = carDao.getCarById(id);
        return carOptional.map(car ->
                new ResponseEntity<>(
                        EntityModel
                                .of(carOptional.get(),
                                        linkTo(CarController.class)
                                                .withSelfRel()),
                        HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<CollectionModel<Car>> getCarsByColor(@PathVariable final String color) {
        List<Car> cars = carDao.getCarsByColor(
                Color.valueOf(color.toUpperCase()));
        setHATEOAS(cars);
        if (cars.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                CollectionModel.of(cars,
                        linkTo(CarController.class)
                                .withSelfRel()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addCar(@RequestBody final Car car) {
        if (carDao.addCar(car)) {
            return new ResponseEntity<>("Car has been added",
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went wrong",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity<String> modCar(@RequestBody final Car newCar) {
        Optional<Car> carOptional = carDao.getCarById(newCar.getId());
        if (carOptional.isPresent() && carDao.updateCarById(newCar)) {
            return new ResponseEntity<>("Modified",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong",
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable final long id) {
        if (carDao.deleteCarById(id)) {
            return new ResponseEntity<>("Deleted.",
                    HttpStatus.OK);
        }
        return new ResponseEntity<>("Car is not found.",
                HttpStatus.NOT_FOUND);
    }

    private void setHATEOAS(final List<Car> cars) {
        for (Car car : cars) {
            car.addIf(!car.hasLinks(), () -> linkTo(CarController.class)
                    .slash(car.getId())
                    .withRel("carLink"));
        }
    }
}
