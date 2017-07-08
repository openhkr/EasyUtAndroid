package com.yanghaoyi.easyutandroid.presenter.command;

import com.yanghaoyi.easyutandroid.view.IWeatherView;

import org.junit.Test;

import static org.mockito.Mockito.mock;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */
public class WeatherControlTest {


    @Test
    public void testButtonPress(){
        IWeatherView view = mock(IWeatherView.class);
        WeatherControl weatherControl = new WeatherControl(view);
        weatherControl.buttonWasPressed(0);
    }
}