package com.topolski.backend.cars_jdbc.dao;

import com.topolski.backend.cars_jdbc.model.Car;
import com.topolski.backend.cars_jdbc.model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarImpl implements CarDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String CAR_ID = "car_id";
    private static final String MARK = "mark";
    private static final String MODEL = "model";
    private static final String COLOR = "color";
    private static final String YEAR_OF_PRODUCTION = "year_of_production";

    @Autowired
    public CarImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> getAllCars() {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM cars",
                    (resultSet, rowNum) -> Car.builder()
                            .id(resultSet
                                    .getLong(CAR_ID))
                            .mark(resultSet
                                    .getString(MARK))
                            .model(resultSet
                                    .getString(MODEL))
                            .color(Color.valueOf(resultSet
                                    .getString(COLOR)))
                            .yearOfProduction(resultSet
                                    .getString(YEAR_OF_PRODUCTION))
                            .build());
        } catch (DataAccessException e) {
            return List.of();
        }
    }

    @Override
    public List<Car> getCarsByColor(final Color color) {
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM cars WHERE " +
                            "color = '" + color + "'",
                    (resultSet, rowNum) -> Car.builder()
                            .id(resultSet
                                    .getLong(CAR_ID))
                            .mark(resultSet
                                    .getString(MARK))
                            .model(resultSet
                                    .getString(MODEL))
                            .color(Color.valueOf(resultSet
                                    .getString(COLOR)))
                            .yearOfProduction(resultSet
                                    .getString(YEAR_OF_PRODUCTION))
                            .build());
        } catch (DataAccessException e) {
            return List.of();
        }
    }

    @Override
    public Optional<Car> getCarById(final Long id) {
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            "SELECT * FROM cars WHERE car_id = "
                                    + id.toString(),
                            (resultSet, rowNum) -> Car.builder()
                                    .id(resultSet
                                            .getLong(CAR_ID))
                                    .mark(resultSet
                                            .getString(MARK))
                                    .model(resultSet
                                            .getString(MODEL))
                                    .color(Color.valueOf(resultSet
                                            .getString(COLOR)))
                                    .yearOfProduction(resultSet
                                            .getString(YEAR_OF_PRODUCTION))
                                    .build()));
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean addCar(final Car car) {
        try {
            jdbcTemplate.update(
                    "INSERT INTO cars (mark, model, color, year_of_production) VALUES (?, ?, ?, ?)",
                    car.getMark(),
                    car.getModel(),
                    car.getColor().toString(),
                    car.getYearOfProduction());
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean deleteCarById(final Long id) {
        try {
            jdbcTemplate.update(
                    "DELETE FROM cars WHERE car_id = ?",
                    id);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }

    @Override
    public boolean updateCarById(final Car car) {
        try {
            jdbcTemplate.update(
                    "UPDATE cars SET " +
                            "mark = ? ," +
                            "model = ? ," +
                            "color = ? ," +
                            "year_of_production = ? " +
                            "WHERE car_id = ?",
                    car.getMark(),
                    car.getModel(),
                    car.getColor().toString(),
                    car.getYearOfProduction(),
                    car.getId());
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
}
