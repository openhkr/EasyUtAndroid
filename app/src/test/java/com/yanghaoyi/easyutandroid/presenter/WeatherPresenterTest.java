package com.yanghaoyi.easyutandroid.presenter;

import com.yanghaoyi.easyutandroid.model.WeatherModel;
import com.yanghaoyi.easyutandroid.presenter.command.WeatherControl;
import com.yanghaoyi.easyutandroid.presenter.listener.WeatherRequestListener;
import com.yanghaoyi.easyutandroid.view.IWeatherView;

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
public class WeatherPresenterTest {

    private WeatherPresenter presenter;
    private IWeatherView view;
    private WeatherControl control;
    private WeatherModel weatherModel;
    private WeatherRequestListener listener;




    @Before
    public void setUp(){
        view = mock(IWeatherView.class);
        control = mock(WeatherControl.class);
        weatherModel = mock(WeatherModel.class);
        listener = mock(WeatherRequestListener.class);
        presenter = new WeatherPresenter(view);
        presenter.updateWeatherModel(weatherModel);
        presenter.updateControl(control);
        presenter.updateListener(listener);
    }


    @Test
    public void testRequest(){
        presenter.request();
        verify(weatherModel).request(listener,view.getLocationCity());
    }


    @Test
    public void testCancelRequest(){
        presenter.cancelRequest();
        verify(weatherModel).cancelRequest();
    }

    @Test
    public void testShowHourTemperature(){
        presenter.showHourTemperature();
        verify(control).buttonWasPressed(WeatherControl.TEMPERATURE);
    }

    @Test
    public void testShowPrecipitation(){
        presenter.showPrecipitation();
        verify(control).buttonWasPressed(WeatherControl.PRECIPITATION);
    }

    @Test
    public void testShowWindPower(){
        presenter.showWindPower();
        verify(control).buttonWasPressed(WeatherControl.WINDPOWER);
    }

}