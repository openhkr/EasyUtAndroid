package com.yanghaoyi.easyutandroid.presenter.strategy.weather;

import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :晴天状态
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class CloudyStrategy implements WeatherStrategy {
    @Override
    public void handleWeather(WeatherViewData viewData,IWeatherView view) {
        view.showCloudy();
    }
}
