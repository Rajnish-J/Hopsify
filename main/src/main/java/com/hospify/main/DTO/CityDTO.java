package com.hospify.main.DTO;

public class CityDTO {

    private long cityId;

    private String cityName;

    private StatesDTO state;

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public StatesDTO getState() {
        return state;
    }

    public void setState(StatesDTO state) {
        this.state = state;
    }
}
