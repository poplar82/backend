package com.topolski.backend.weather_app.controller;

import com.topolski.backend.weather_app.model.Weather;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class WeatherController {
    private final WeatherControllerClient weatherControllerClient;

    public WeatherController(WeatherControllerClient weatherControllerClient) {
        this.weatherControllerClient = weatherControllerClient;
    }
    @GetMapping("/weather/{city}")
    public ResponseEntity<Weather> getWeather(@PathVariable String city){
        return weatherControllerClient.getWeatherForCity(city);
    }
}
