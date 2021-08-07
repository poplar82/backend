package com.topolski.backend.week8.controller;

import com.topolski.backend.week8.model.Temp;
import com.topolski.backend.week8.repo.TempRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/")
public class TempController {
    TempRepo tempRepo;
    @Autowired
    public TempController(TempRepo tempRepo) {
        this.tempRepo = tempRepo;
    }
    @GetMapping("/weather/history")
    public List<Temp> getTempHistory() {
        return tempRepo.findAll();
    }
}
