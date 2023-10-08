package com.example.garden;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeatherModel extends ViewModel {
    public int temp;
    public int humidity;

    public WeatherModel() {
        this.temp = 0;
        this.humidity = 0;
    }

    private final MutableLiveData<WeatherState> uiState = new MutableLiveData(new WeatherState(temp, humidity));
    public LiveData<WeatherState> getUiState() {
        return uiState;
    }

    public void setTemp(int temp) {
        this.temp = temp;
        uiState.setValue(new WeatherState(this.temp, this.humidity));
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        uiState.setValue(new WeatherState(this.temp, this.humidity));
    }



}

