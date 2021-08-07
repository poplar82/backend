package com.topolski.backend.week8.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "temperatures")
public class Temp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double temperature;
    private LocalDate date;
    private LocalTime time;


    public Temp() {
    }

    public Temp(Double temperature, LocalDate date, LocalTime time) {
        this.temperature = temperature;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Double getTemperature() {
        return temperature;
    }
    public void setTemperature(Double temp) {
        this.temperature = temp;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
