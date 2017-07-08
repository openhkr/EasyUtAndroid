package com.yanghaoyi.easyutandroid.model;

import com.yanghaoyi.easyutandroid.presenter.IModelUpdater;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class ModelFactory {

    private WeatherModel model;

    public ModelFactory build(){
        model = new WeatherModel();
        return this;
    }

    public ModelFactory updateModel(IModelUpdater updater){
        updater.updateWeatherModel(model);
        return this;
    }
}
