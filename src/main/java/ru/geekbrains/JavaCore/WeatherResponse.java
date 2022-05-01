package ru.geekbrains.JavaCore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ru.geekbrains.JavaCore.Entity.WeatherForecast;

public class WeatherResponse {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private WeatherForecast weatherForecast;

    public WeatherResponse(String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(WeatherForecast.class, new WeatherForecastDeserializer());
        mapper.registerModule(module);

        try {
            weatherForecast = mapper.readValue(json, WeatherForecast.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    public WeatherForecast getResult() {
        return weatherForecast;
    }

}

