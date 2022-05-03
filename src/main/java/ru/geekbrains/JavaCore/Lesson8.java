package ru.geekbrains.JavaCore;

import ru.geekbrains.JavaCore.Entity.Weather;

import java.io.IOException;
import java.util.List;

public class Lesson8 {
    public static void main(String[] args) {
        AccuWeatherModel model = new AccuWeatherModel();
        try {
            model.getWeather();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //не понятно что значит чтение из базы по пункту меню???
        List<Weather> weathers = model.getSavedToDBWeather();
    }
}
