package com.yanghaoyi.easyutandroid.presenter.command;

import com.yanghaoyi.easyutandroid.view.IWeatherView;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class WeatherControlFactory {

    private WeatherControl control;
    public WeatherControlFactory build(IWeatherView view){
        WeatherControl control = new WeatherControl(view);
        return this;
    }

    public void updateControl(IControlUpdater updater){
        updater.updateControl(control);
    }
}
