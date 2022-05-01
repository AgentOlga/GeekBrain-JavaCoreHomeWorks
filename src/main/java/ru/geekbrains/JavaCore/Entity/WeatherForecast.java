package ru.geekbrains.JavaCore.Entity;

import java.util.List;

public class WeatherForecast {
    private List<Weather> forecast;

    public WeatherForecast(List<Weather> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return forecast.toString();
    }

    public List<Weather> getForecast() {
        return forecast;
    }
}
