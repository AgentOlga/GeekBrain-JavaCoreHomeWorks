package ru.geekbrains.JavaCore;

import ru.geekbrains.JavaCore.Entity.Weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private String insertWeather = "insert into weather (city, localDate, temperature, weatherText) values (?, ?, ?, ?)";
    private String getWeather = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:C:\\Users\\agent\\geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWeather(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            connection.setAutoCommit(true);
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setDouble(3, weather.getTemperature());
            saveWeather.setString(4, weather.getConditions());
            saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void saveWeather(List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            connection.setAutoCommit(true);
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setDouble(3, weather.getTemperature());
                saveWeather.setString(4, weather.getConditions());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Weather> getSavedToDBWeather() {
        List<Weather> weathers = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                Weather weather = new Weather(resultSet.getString("city"),
                        resultSet.getString("localDate"),
                        resultSet.getDouble("temperature"),
                        resultSet.getString("weatherText"));
                weathers.add(weather);

                System.out.print(resultSet.getInt("id"));
                System.out.println(" ");
                System.out.print(weather.getCity());
                System.out.println(" ");
                System.out.print(weather.getLocalDate());
                System.out.println(" ");
                System.out.print(weather.getTemperature());
                System.out.println(" ");
                System.out.print(weather.getConditions());
                System.out.println(" ");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weathers;
    }
}
