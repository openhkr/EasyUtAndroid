package com.yanghaoyi.easyutandroid.view;

import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;

/**
 * Author : YangHaoyi on 2017/6/23.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/23.
 * Version : V 1.0
 */

public interface IWeatherView {

    void showLoading();
    void hideLoading();

    void showDataError();

    void updateCache(WeatherViewData viewData);
    void showSunny();
    void showRainy();
    void showCloudy();

    void showLightBaskNotice();
    void showMiddleBaskNotice();
    void showHighBaskNotice();
    void showBaskDanger();

    void dressLongSleeve();
    void dressSunGlass();

    void showTemperature();
    void showPrecipitation();
    void showWindPower();
    void resetCommandTab();
    void showHourTemperature();
    void toHelpCenter();

    String getLocationCity();
}
