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
    private static final String KEY = "##########################";

    public ResponseEntity<Weather> getWeatherForCity(String city) {
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
            return new ResponseEntity<>(setWeather(jsonNode), HttpStatus.OK);
        } catch (RestClientResponseException e) {
            return new ResponseEntity<>(HttpStatus.valueOf(e.getRawStatusCode()));
        }

    }

    private Weather setWeather(JsonNode jsonNode) {
        final String LOCATION = "location";
        final String CURRENT = "current";
        final String AIR_QUALITY = "air_quality";

        Weather weather = new Weather();
        weather.setLocationCountry(jsonNode.get(LOCATION).get("country").asText());
        weather.setLocationCity(jsonNode.get(LOCATION).get("name").asText());
        weather.setCurrentTempC(jsonNode.get(CURRENT).get("temp_c").asDouble());
        weather.setCurrentFeelsLikeC(jsonNode.get(CURRENT).get("feelslike_c").asDouble());
        weather.setCurrentConditionText(jsonNode.get(CURRENT).get("condition").get("text").asText());
        weather.setCurrentConditionIcon(jsonNode.get(CURRENT).get("condition").get("icon").asText());
        weather.setCurrentWindKM(jsonNode.get(CURRENT).get("wind_kph").asDouble());
        weather.setCurrentWindDir(jsonNode.get(CURRENT).get("wind_dir").asText());
        weather.setCurrentPressureMB(jsonNode.get(CURRENT).get("pressure_mb").asInt());
        weather.setCurrentUV(jsonNode.get(CURRENT).get("uv").asInt());
        weather.setCurrentPrecipMM(jsonNode.get(CURRENT).get("precip_mm").asDouble());
        weather.setCurrentHumidity(jsonNode.get(CURRENT).get("humidity").asInt());
        weather.setCo(jsonNode.get(CURRENT).get(AIR_QUALITY).get("co").asDouble());
        weather.setNo2(jsonNode.get(CURRENT).get(AIR_QUALITY).get("no2").asDouble());
        weather.setO3(jsonNode.get(CURRENT).get(AIR_QUALITY).get("o3").asDouble());
        weather.setSo2(jsonNode.get(CURRENT).get(AIR_QUALITY).get("so2").asDouble());
        weather.setPm25(jsonNode.get(CURRENT).get(AIR_QUALITY).get("pm2_5").asDouble());
        weather.setPm10(jsonNode.get(CURRENT).get(AIR_QUALITY).get("pm10").asDouble());
        return weather;
    }
}
