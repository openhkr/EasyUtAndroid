package com.yanghaoyi.easyutandroid.presenter.command;

import com.yanghaoyi.easyutandroid.view.IWeatherView;

/**
 * Author : YangHaoyi on 2017/6/28.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/28.
 * Version : V 1.0
 */

public class TemperatureCommand implements WeatherCommand{

    private IWeatherView view;

    public TemperatureCommand(IWeatherView view) {
        this.view = view;
    }

    @Override
    public void execute() {
        view.resetCommandTab();
        view.showHourTemperature();
    }
}
