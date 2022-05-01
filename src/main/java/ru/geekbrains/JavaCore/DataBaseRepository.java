package ru.geekbrains.JavaCore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseRepository {
    private String insertWeather = "insert into weather (city, localdate, temperature) values (?, ?, ?)";
    private String getWeather = "select * from weather";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather1 weather1) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather1.getCity());
            saveWeather.setString(2, weather1.getLocalDate());
            saveWeather.setDouble(3, weather1.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void saveWeatherToDataBase(List<Weather1> weather1List) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather1 weather1 : weather1List) {
                saveWeather.setString(1, weather1.getCity());
                saveWeather.setString(2, weather1.getLocalDate());
                saveWeather.setDouble(3, weather1.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Weather1> getSavedToDBWeather() {
        List<Weather1> weather1s = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.println(" ");
                System.out.print(resultSet.getString("city"));
                System.out.println(" ");
                System.out.print(resultSet.getString("localdate"));
                System.out.println(" ");
                System.out.print(resultSet.getDouble("temperature"));
                System.out.println(" ");
                weather1s.add(new Weather1(resultSet.getString("city"),
                        resultSet.getString("localdate"),
                        resultSet.getDouble("temperature")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return weather1s;
    }

    public static void main(String[] args) throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        System.out.println(dataBaseRepository.getSavedToDBWeather());
    }
}
