package com.yanghaoyi.easyutandroid.presenter.chain.sunny;

import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */
public class LightBaskTest {

    private LightBask lightBask;
    private MiddleBask middleBask;
    private IWeatherView view;

    @Before
    public void setUp() {
        lightBask = new LightBask();
        //模拟责任链下级对象
        middleBask = mock(MiddleBask.class);
        //设置责任链下级对象
        lightBask.setSuccessor(middleBask);
        view = mock(IWeatherView.class);
    }


    @Test
    public void testSendHandler(){
        WeatherViewData viewData = new WeatherViewData();
        viewData.setUltraviolet(6);
        lightBask.handleBask(viewData,view);
        //验证超过临界值，责任下放
        verify(middleBask).handleBask(viewData,view);
    }

    @Test
    public void testHandlerBask(){
        WeatherViewData viewData = new WeatherViewData();
        viewData.setUltraviolet(1);
        lightBask.handleBask(viewData,view);
        //验证未超过临界值，责任人直接处理
        verify(view).showLightBaskNotice();
    }


}