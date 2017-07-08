package com.yanghaoyi.easyutandroid.presenter.listener;

import com.yanghaoyi.easyutandroid.view.IWeatherView;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class ListenerFactory {

    private WeatherRequestListener listener;

    public ListenerFactory build(IWeatherView view){
        listener = new WeatherRequestListener(view);
        return this;
    }

    public ListenerFactory updateListener(IListenerUpdater updater){
        updater.updateListener(listener);
        return this;
    }
}
