package ru.geekbrains.JavaCore;

import com.fasterxml.jackson.databind.JsonNode;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.JavaCore.Entity.Weather;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class lesson6 {
    public static void main(String[] args) {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("123094")
                .addQueryParameter("apikey", "9be9E6LPcAKJcnfaIKqp8QLBjlQoLLfg")
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response oneDayForecastResponse = null;
        try {
            oneDayForecastResponse = okHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        WeatherResponse weatherResponse = null;
        try {
            weatherResponse = new WeatherResponse(oneDayForecastResponse.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }



        if (weatherResponse != null)
            System.out.println(weatherResponse.getResult().toString());

        System.out.println("5 days weather forecast for Copenhagen:");
        for (final Weather weather : weatherResponse.getResult().getForecast()) {
            System.out.println("В городе Copenhagen на дату " + weather.getLocalDate() + " ожидается " + weather.getConditions() + ", температура - " + String.format("%.2f", weather.getTemperature()));
        }

        //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
        //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night
        //dataBaseRepository.saveWeatherToDataBase(new Weather()) - тут после парсинга добавляем данные в БД

        //UserInterfaceView userInterfaceView = new UserInterfaceView();
        //userInterfaceView.runInterface();
    }
}


