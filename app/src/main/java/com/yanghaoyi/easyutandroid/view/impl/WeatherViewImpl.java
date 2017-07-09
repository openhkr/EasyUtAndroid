package com.yanghaoyi.easyutandroid.view.impl;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.yanghaoyi.base.comp.LoadingView;
import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;
import com.yanghaoyi.easyutandroid.view.holder.WeatherViewHolder;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :天气显示面板实现view
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class WeatherViewImpl implements IWeatherView{



    private FrameLayout room;
    private Context mContext;
    private WeatherViewHolder mViewHolder;
    private WeatherViewData mViewDataCache;
    private View cover;

    public WeatherViewImpl(WeatherViewHolder viewHolder, Context context) {
        this.mContext = context;
        this.mViewHolder = viewHolder;
        room = viewHolder.getRoom();
    }

    @Override
    public void showLoading() {
        hideLoading();
        cover = new LoadingView(mContext);
        room.addView(cover);
    }

    @Override
    public void hideLoading() {
        if (null != cover) {
            room.removeView(cover);
            cover = null;
        }
    }

    @Override
    public void showDataError() {
        Toast.makeText(mContext, R.string.weather_data_error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateCache(WeatherViewData viewData) {
        this.mViewDataCache = viewData;
    }

    @Override
    public void showSunny() {
        mViewHolder.getTvWeather().setText(R.string.weather_sunny);
    }

    @Override
    public void showRainy() {
        mViewHolder.getTvWeather().setText(R.string.weather_rainy);
    }

    @Override
    public void showCloudy() {
        mViewHolder.getTvWeather().setText(R.string.weather_cloudy);
    }

    @Override
    public void showLightBaskNotice() {
        mViewHolder.getTvBaskNotice().setText(R.string.weather_light_bask);
    }

    @Override
    public void showMiddleBaskNotice() {
        mViewHolder.getTvBaskNotice().setText(R.string.weather_middle_bask);
    }

    @Override
    public void showHighBaskNotice() {
        mViewHolder.getTvBaskNotice().setText(R.string.weather_high_bask);
    }

    @Override
    public void showBaskDanger() {
        mViewHolder.getTvBaskNotice().setText(R.string.weather_danger_bask);
    }


    @Override
    public void dressLongSleeve() {
        mViewHolder.getvPeople().dressLongSleeve();
    }

    @Override
    public void dressSunGlass() {
        mViewHolder.getvPeople().dressGlass();
    }

    @Override
    public void showTemperature() {
        //显示当前温度
        mViewHolder.getTvTemperature().setText(String.valueOf(mViewDataCache.getTemperature()));
    }

    @Override
    public void showHourTemperature() {
        //显示实时温度详情
        mViewHolder.getTvHourTemperature().setText(mContext.getString(R.string.weather_temperature_24)+mViewDataCache.getHourTemperature());
    }

    @Override
    public void showPrecipitation() {
        //显示实时降水量详情
        mViewHolder.getTvPrecipitation().setText(mContext.getString(R.string.weather_rainfall_24)+mViewDataCache.getRainfall());
    }

    @Override
    public void showWindPower() {
        //显示实时风力详情
        mViewHolder.getTvWindPower().setText(mContext.getString(R.string.weather_wind_power_24)+mViewDataCache.getWindPower());
    }

    @Override
    public void resetCommandTab() {
        //重置控制面板文字显示
        mViewHolder.getTvHourTemperature().setText(mContext.getString(R.string.weather_temperature_24));
        mViewHolder.getTvPrecipitation().setText(mContext.getString(R.string.weather_rainfall_24));
        mViewHolder.getTvWindPower().setText(mContext.getString(R.string.weather_wind_power_24));
    }

    @Override
    public String getLocationCity() {
        //获取定位城市（真实情况下应该通过SDK进行定位获取，因为这只是一个Demo，故返回固定值“沈阳”）
        return mContext.getString(R.string.weather_location);
    }
}
