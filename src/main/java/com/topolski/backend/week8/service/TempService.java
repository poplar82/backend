package com.topolski.backend.week8.service;

import com.topolski.backend.weather_app.controller.WeatherControllerClient;
import com.topolski.backend.week8.model.Temp;
import com.topolski.backend.week8.repo.TempRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class TempService {
    private final TempRepo tempRepo;
    private final WeatherControllerClient weatherControllerClient;

    @Autowired
    public TempService(final TempRepo tempRepo, final WeatherControllerClient weatherControllerClient) {
        this.tempRepo = tempRepo;
        this.weatherControllerClient = weatherControllerClient;
    }

    @Scheduled(fixedRate = 30000)
    public void saveTemp() {
        tempRepo.save(new Temp(
                weatherControllerClient
                        .getTemperature("Stockholm"),
                LocalDate.now(),
                LocalTime.now()));
    }
}
