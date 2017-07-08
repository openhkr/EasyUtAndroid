package com.yanghaoyi.easyutandroid.presenter.strategy.weather;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public enum WeatherType {
    SUNNY(1,"晴天", SunnyStrategy.class),
    RAINY(2,"雨天",RainyStrategy.class),
    CLOUDY(4,"多云",CloudyStrategy.class);

    private int code;
    private Class<WeatherStrategy> clazz;


    WeatherType(int code, String name, Class clazz) {
        this.code = code;
        this.clazz = clazz;
    }


    public static WeatherStrategy get(int code) throws IllegalAccessException, InstantiationException {
        for (WeatherType value: WeatherType.values()) {
            if(value.code==code){
                return value.clazz.newInstance();
            }
        }
        return null;
    }
}
