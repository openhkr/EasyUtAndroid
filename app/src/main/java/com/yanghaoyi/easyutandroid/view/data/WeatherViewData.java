package com.yanghaoyi.easyutandroid.view.data;

/**
 * Author : YangHaoyi on 2017/6/23.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/23.
 * Version : V 1.0
 */

public class WeatherViewData {

    private double temperature;
    private int weatherType;
    private int ultraviolet;
    private String rainfall;
    private String hourTemperature;
    private String windPower;


    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(int weatherType) {
        this.weatherType = weatherType;
    }

    public int getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(int ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getHourTemperature() {
        return hourTemperature;
    }

    public void setHourTemperature(String hourTemperature) {
        this.hourTemperature = hourTemperature;
    }


    public String getWindPower() {
        return windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }
}
