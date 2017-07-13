package com.yanghaoyi.easyutandroid.view.holder;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.activity.WeatherActivity;
import com.yanghaoyi.easyutandroid.view.comp.PeopleView;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class WeatherViewHolder{

    private FrameLayout room;
    private TextView tvTemperature;
    private TextView tvWeather;
    private TextView tvBaskNotice;
    private TextView tvHourTemperature;
    private TextView tvPrecipitation;
    private TextView tvWindPower;
    private TextView btHelp;
    private PeopleView vPeople;

    public WeatherViewHolder(WeatherActivity activity) {
        room = (FrameLayout) activity.findViewById(R.id.room);
        tvTemperature = (TextView) activity.findViewById(R.id.tvTemperature);
        tvWeather = (TextView) activity.findViewById(R.id.tvWeather);
        tvBaskNotice = (TextView) activity.findViewById(R.id.tvBaskNotice);
        vPeople = (PeopleView) activity.findViewById(R.id.vPeople);
        tvHourTemperature = (TextView) activity.findViewById(R.id.tvHourTemperature);
        tvPrecipitation = (TextView) activity.findViewById(R.id.tvPrecipitation);
        tvWindPower = (TextView) activity.findViewById(R.id.tvWindPower);
        btHelp = (TextView) activity.findViewById(R.id.btHelp);
    }

    public FrameLayout getRoom() {
        return room;
    }

    public TextView getTvTemperature() {
        return tvTemperature;
    }

    public TextView getTvWeather() {
        return tvWeather;
    }

    public TextView getTvBaskNotice() {
        return tvBaskNotice;
    }
    public PeopleView getvPeople() {
        return vPeople;
    }

    public TextView getTvHourTemperature() {
        return tvHourTemperature;
    }

    public TextView getTvPrecipitation() {
        return tvPrecipitation;
    }

    public TextView getTvWindPower() {
        return tvWindPower;
    }

    public TextView getBtHelp() {
        return btHelp;
    }
}
