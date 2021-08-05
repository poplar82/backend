package com.topolski.backend.weather_app.controller;

import com.topolski.backend.weather_app.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class WeatherController {
    private final WeatherControllerClient weatherControllerClient;
    @Autowired
    public WeatherController(final WeatherControllerClient weatherControllerClient) {
        this.weatherControllerClient = weatherControllerClient;
    }
    @GetMapping("/weather/{city}")
    public ResponseEntity<Weather> getWeather(@PathVariable final String city) {
        return weatherControllerClient.getWeatherForCity(city);
    }
}
