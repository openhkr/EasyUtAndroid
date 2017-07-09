package com.yanghaoyi.easyutandroid.presenter.listener;

import com.yanghaoyi.easyutandroid.presenter.strategy.weather.WeatherType;
import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;
import com.yanghaoyi.net.RequestListener;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class WeatherRequestListener implements RequestListener<WeatherViewData> {

    private IWeatherView view;

    public WeatherRequestListener(IWeatherView view) {
        this.view = view;
    }

    @Override
    public void success(WeatherViewData viewData) {
        try {
            WeatherType.get(viewData.getWeatherType()).handleWeather(viewData,view);
        } catch (Exception e) {
            view.showDataError();
        }
        view.updateCache(viewData);
    }

    @Override
    public void fail(WeatherViewData response, String msg) {
        view.hideLoading();
    }

    @Override
    public void showLoading() {
        view.showLoading();
    }

    @Override
    public void hideLoading() {
        view.hideLoading();
    }
}
