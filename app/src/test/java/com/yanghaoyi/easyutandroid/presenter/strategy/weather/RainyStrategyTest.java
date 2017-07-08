package com.yanghaoyi.easyutandroid.presenter.strategy.weather;

import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */
public class RainyStrategyTest {
    @Test
    public void testHandlerWeather(){
        IWeatherView view = mock(IWeatherView.class);
        WeatherViewData viewData = new WeatherViewData();
        RainyStrategy rainyStrategy = new RainyStrategy();
        rainyStrategy.handleWeather(viewData,view);
        verify(view).showRainy();
    }
}