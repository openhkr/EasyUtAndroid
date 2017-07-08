package com.yanghaoyi.easyutandroid.view.impl;

import android.content.Context;

import com.yanghaoyi.easyutandroid.view.IViewUpdater;
import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.holder.WeatherViewHolder;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class ViewFactory {

    private IWeatherView view;

    public ViewFactory build(WeatherViewHolder viewHolder, Context context){
        view = new WeatherViewImpl(viewHolder,context);
        return this;
    }

    public void updateView(IViewUpdater updater){
        updater.updateView(view);

    }
}
