package com.topolski.backend.weather_app.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Weather {
    private String locationCountry;
    private String locationCity;
    private Double currentTempC;
    private Double currentFeelsLikeC;
    private String currentConditionText;
    private String currentConditionIcon;
    private Double currentWindKM;
    private String currentWindDir;
    private Integer currentPressureMB;
    private Integer currentUV;
    private Double currentPrecipitationMM;
    private Integer currentHumidity;
    private Double co;
    private Double no2;
    private Double o3;
    private Double so2;
    private Double pm25;
    private Double pm10;
}
