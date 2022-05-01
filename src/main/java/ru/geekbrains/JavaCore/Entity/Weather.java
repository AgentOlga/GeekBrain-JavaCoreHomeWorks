package ru.geekbrains.JavaCore.Entity;

public class Weather {
    private String city;
    private String localDate;
    private double temperature;
    private String conditions;

    public Weather(String city, String localDate, double temperature, String conditions) {
        this.city = city;
        this.localDate = localDate;
        this.temperature = temperature;
        this.conditions = conditions;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getConditions() {
        return conditions;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", temperature=" + String.format("%.2f", temperature) + '\'' +
                ", conditions=" + conditions +
                '}';
    }
}
