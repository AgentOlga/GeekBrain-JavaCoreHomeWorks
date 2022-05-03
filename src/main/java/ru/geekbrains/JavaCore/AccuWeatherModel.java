package ru.geekbrains.JavaCore;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.geekbrains.JavaCore.Entity.Weather;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccuWeatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/123094


    private static final String PROTOKOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String CITY_KEY = "123094";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAYS = "5day";
    private static final String API_KEY = "9be9E6LPcAKJcnfaIKqp8QLBjlQoLLfg";
    private static final String API_KEY_QUERY_PARAM = "apikey";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DataBaseRepository dataBaseRepository = new DataBaseRepository();

    public void getWeather() throws IOException {
        HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOKOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAYS)
                        .addPathSegment(CITY_KEY)
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

        Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

        Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
        WeatherResponse weatherResponse = new WeatherResponse(oneDayForecastResponse.body().string());


        System.out.println("5 days weather forecast for Copenhagen:");
        for (final Weather weather : weatherResponse.getResult().getForecast()) {
            System.out.println("В городе Copenhagen на дату " + weather.getLocalDate() + " ожидается " + weather.getConditions() + ", температура - " + String.format("%.2f", weather.getTemperature()));
        }

        try {
            dataBaseRepository.saveWeather(weatherResponse.getResult().getForecast());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }
}
