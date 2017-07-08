package com.yanghaoyi.easyutandroid.presenter;

import com.yanghaoyi.easyutandroid.model.WeatherModel;
import com.yanghaoyi.easyutandroid.view.IWeatherView;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class PresenterFactory {


    private WeatherPresenter presenter;
    private WeatherModel model;

    public PresenterFactory build(IWeatherView view){
        presenter = new WeatherPresenter(view);
        return this;
    }

    public void updatePresenter(IPresenterUpdater updater){
        updater.updatePresenter(presenter);
    }

}
