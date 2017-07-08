package com.yanghaoyi.easyutandroid.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.presenter.IPresenterUpdater;
import com.yanghaoyi.easyutandroid.presenter.PresenterFactory;
import com.yanghaoyi.easyutandroid.presenter.WeatherPresenter;
import com.yanghaoyi.easyutandroid.view.IViewUpdater;
import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.holder.IViewHolderUpdater;
import com.yanghaoyi.easyutandroid.view.holder.ViewHolderFactory;
import com.yanghaoyi.easyutandroid.view.holder.WeatherViewHolder;
import com.yanghaoyi.easyutandroid.view.impl.ViewFactory;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :天气显示页面Activity
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class WeatherActivity extends FragmentActivity implements IPresenterUpdater, IViewHolderUpdater, IViewUpdater {



    private WeatherPresenter presenter;
    private WeatherViewHolder viewHolder;
    private IWeatherView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        new ViewHolderFactory().build(this).updateViewHolder(this);
        new ViewFactory().build(viewHolder,this).updateView(this);
        new PresenterFactory().build(view).updatePresenter(this);
        initEvent();
    }

    private void initEvent(){
        presenter.request();
        viewHolder.getTvHourTemperature().setOnClickListener(view->presenter.showHourTemperature());
        viewHolder.getTvPrecipitation().setOnClickListener(view -> presenter.showPrecipitation());
        viewHolder.getTvWindPower().setOnClickListener(view -> presenter.showWindPower());
    }

    @Override
    protected void onDestroy() {
        //Activity销毁关闭异步请求，防止内存泄漏
        presenter.cancelRequest();
        super.onDestroy();
    }

    public void setPresenter(WeatherPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updatePresenter(WeatherPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateViewHolder(WeatherViewHolder viewHolder) {
        this.viewHolder = viewHolder;
    }

    @Override
    public void updateView(IWeatherView view) {
        this.view = view;
    }
}
