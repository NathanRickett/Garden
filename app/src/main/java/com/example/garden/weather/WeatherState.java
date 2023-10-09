package com.example.garden.weather;

public class WeatherState {
    private int temp;
    private int humidity;

    public WeatherState(int temp, int humidity) {
        this.temp = temp;
        this.humidity = humidity;
    }

    public int getTemp() {
        return this.temp;
    }

    public int getHumidity() {
        return this.humidity;
    }
}
