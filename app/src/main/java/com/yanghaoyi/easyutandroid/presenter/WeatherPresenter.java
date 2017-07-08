package com.yanghaoyi.easyutandroid.presenter;

import com.yanghaoyi.easyutandroid.model.ModelFactory;
import com.yanghaoyi.easyutandroid.model.WeatherModel;
import com.yanghaoyi.easyutandroid.presenter.command.IControlUpdater;
import com.yanghaoyi.easyutandroid.presenter.command.WeatherControl;
import com.yanghaoyi.easyutandroid.presenter.command.WeatherControlFactory;
import com.yanghaoyi.easyutandroid.presenter.listener.IListenerUpdater;
import com.yanghaoyi.easyutandroid.presenter.listener.ListenerFactory;
import com.yanghaoyi.easyutandroid.presenter.listener.WeatherRequestListener;
import com.yanghaoyi.easyutandroid.view.IWeatherView;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class WeatherPresenter implements IModelUpdater,IControlUpdater, IListenerUpdater {

    private IWeatherView view;
    private WeatherModel model;
    private WeatherControl weatherControl;
    private WeatherRequestListener listener;

    public WeatherPresenter(IWeatherView view) {
        this.view = view;
        new ModelFactory().build().updateModel(this);
        new WeatherControlFactory().build(view).updateControl(this);
        new ListenerFactory().build(view).updateListener(this);
    }

    public void request(){
        model.request(listener,view.getLocationCity());
    }

    public void cancelRequest(){
        model.cancelRequest();
    }

    public void showHourTemperature(){
        weatherControl.buttonWasPressed(WeatherControl.TEMPERATURE);
    }

    public void showPrecipitation(){
        weatherControl.buttonWasPressed(WeatherControl.PRECIPITATION);
    }

    public void showWindPower(){
        weatherControl.buttonWasPressed(WeatherControl.WINDPOWER);
    }


    @Override
    public void updateWeatherModel(WeatherModel model) {
        this.model = model;
    }

    @Override
    public void updateControl(WeatherControl weatherControl) {
        this.weatherControl = weatherControl;
    }

    @Override
    public void updateListener(WeatherRequestListener listener) {
        this.listener = listener;
    }
}
