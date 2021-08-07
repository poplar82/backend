package com.topolski.backend.weather_app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.topolski.backend.weather_app.model.Weather;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherControllerClient {
    private static final String KEY = "###########################";

    public ResponseEntity<Weather> getWeatherForCity(final String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            JsonNode jsonNode = restTemplate
                    .getForObject(
                            "https://api.weatherapi.com/v1/current.json?key="
                                    + KEY
                                    + "&q="
                                    + city
                                    + "&aqi=yes",
                            JsonNode.class
                    );
            assert jsonNode != null;
            return new ResponseEntity<>(setWeather(jsonNode),
                    HttpStatus.OK);
        } catch (RestClientResponseException e) {
            return new ResponseEntity<>(HttpStatus
                    .valueOf(e.getRawStatusCode()));
        }

    }

    private Weather setWeather(JsonNode jsonNode) {
        final String LOCATION = "location";
        final String CURRENT = "current";
        final String AIR_QUALITY = "air_quality";
        return Weather.builder()
                .locationCountry(jsonNode
                                .get(LOCATION)
                                .get("country")
                                .asText())
                .locationCity(jsonNode
                                .get(LOCATION)
                                .get("name")
                                .asText())
                .currentTempC(jsonNode
                        .get(CURRENT)
                        .get("temp_c")
                        .asDouble())
                .currentFeelsLikeC(jsonNode
                        .get(CURRENT)
                        .get("feelslike_c")
                        .asDouble())
                .currentConditionText(jsonNode
                        .get(CURRENT)
                        .get("condition")
                        .get("text")
                        .asText())
                .currentConditionIcon(jsonNode
                        .get(CURRENT)
                        .get("condition")
                        .get("icon")
                        .asText())
                .currentWindKM(jsonNode
                        .get(CURRENT)
                        .get("wind_kph")
                        .asDouble())
                .currentWindDir(jsonNode
                        .get(CURRENT)
                        .get("wind_dir")
                        .asText())
                .currentPressureMB(jsonNode
                        .get(CURRENT)
                        .get("pressure_mb")
                        .asInt())
                .currentUV(jsonNode
                        .get(CURRENT)
                        .get("uv")
                        .asInt())
                .currentPrecipitationMM(jsonNode
                        .get(CURRENT)
                        .get("precip_mm")
                        .asDouble())
                .currentHumidity(jsonNode
                        .get(CURRENT)
                        .get("humidity")
                        .asInt())
                .co(jsonNode
                        .get(CURRENT)
                        .get(AIR_QUALITY)
                        .get("co")
                        .asDouble())
                .no2(jsonNode
                        .get(CURRENT)
                        .get(AIR_QUALITY)
                        .get("no2")
                        .asDouble())
                .o3(jsonNode
                        .get(CURRENT)
                        .get(AIR_QUALITY)
                        .get("o3")
                        .asDouble())
                .so2(jsonNode
                        .get(CURRENT)
                        .get(AIR_QUALITY)
                        .get("so2")
                        .asDouble())
                .pm25(jsonNode
                        .get(CURRENT)
                        .get(AIR_QUALITY)
                        .get("pm2_5")
                        .asDouble())
                .pm10(jsonNode
                        .get(CURRENT)
                        .get(AIR_QUALITY)
                        .get("pm10")
                        .asDouble())
                .build();
    }
    public double getTemperature(final String city) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            JsonNode jsonNode = restTemplate
                    .getForObject(
                            "https://api.weatherapi.com/v1/current.json?key="
                                    + KEY
                                    + "&q="
                                    + city
                                    + "&aqi=no",
                            JsonNode.class
                    );
            assert jsonNode != null;
            return jsonNode.get("current").get("temp_c").asDouble();
        } catch (RestClientResponseException e) {
            return 0.0;
        }
    }

}
