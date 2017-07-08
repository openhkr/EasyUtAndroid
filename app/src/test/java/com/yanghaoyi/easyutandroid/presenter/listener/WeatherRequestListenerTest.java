package com.yanghaoyi.easyutandroid.presenter.listener;

import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */
public class WeatherRequestListenerTest {

    private WeatherRequestListener listener;
    private IWeatherView view;


    @Before
    public void setUp(){
        view = mock(IWeatherView.class);
        listener = new WeatherRequestListener(view);
    }


    @Test
    public void testSuccess(){
        WeatherViewData viewData = new WeatherViewData();
        viewData.setWeatherType(1);
        listener.success(viewData);
        verify(view).updateCache(viewData);
    }



    @Test
    public void testSuccessNullPointer(){
        WeatherViewData viewData = new WeatherViewData();
        viewData.setWeatherType(12);
        try {
            listener.success(viewData);
        } catch (Exception e) {
            verify(view).showDataError();
            assertTrue(e instanceof NullPointerException );
        }

    }

}