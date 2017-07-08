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
public class MiddleBaskTest {

    private MiddleBask middleBask;
    private HighBask highBask;
    private IWeatherView view;

    @Before
    public void setUp() {
        middleBask = new MiddleBask();
        //模拟责任链下级对象
        highBask = mock(HighBask.class);
        //设置责任链下级对象
        middleBask.setSuccessor(highBask);
        view = mock(IWeatherView.class);
    }


    @Test
    public void testSendHandler(){
        WeatherViewData viewData = new WeatherViewData();
        viewData.setUltraviolet(9);
        middleBask.handleBask(viewData,view);
        //验证超过临界值，责任下放
        verify(highBask).handleBask(viewData,view);
    }

    @Test
    public void testHandlerBask(){
        WeatherViewData viewData = new WeatherViewData();
        viewData.setUltraviolet(5);
        middleBask.handleBask(viewData,view);
        //验证未超过临界值，责任人直接处理
        verify(view).showMiddleBaskNotice();
        verify(view).dressSunGlass();
    }
}