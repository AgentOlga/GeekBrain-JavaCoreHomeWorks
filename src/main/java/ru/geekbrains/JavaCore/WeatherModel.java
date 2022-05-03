package ru.geekbrains.JavaCore;

import ru.geekbrains.JavaCore.Entity.Weather;

import java.io.IOException;
import java.util.List;

public interface WeatherModel {
    void getWeather() throws IOException;

    public List<Weather> getSavedToDBWeather();
}
