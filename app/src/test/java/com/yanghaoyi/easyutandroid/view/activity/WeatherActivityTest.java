package com.yanghaoyi.easyutandroid.view.activity;

import android.widget.TextView;

import com.yanghaoyi.easyutandroid.BuildConfig;
import com.yanghaoyi.easyutandroid.MyRobolectricTestRunner;
import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.presenter.WeatherPresenter;
import com.yanghaoyi.easyutandroid.view.holder.WeatherViewHolder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Author : YangHaoyi on 2017/6/28.
 * Email  :  yanghaoyi@neusoft.com
 * Description :WeatherActivity测试类
 * Change : YangHaoYi on 2017/6/28.
 * Version : V 1.0
 */

@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class WeatherActivityTest {

    private WeatherActivity activity;
    private WeatherPresenter presenter;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(WeatherActivity.class);
        presenter = mock(WeatherPresenter.class);
        activity.setPresenter(presenter);
    }

    @Test
    public void testHourTemperatureClick(){
        TextView tvHourTemperature = (TextView) activity.findViewById(R.id.tvHourTemperature);
        //执行view点击方法
        tvHourTemperature.performClick();
        //验证点击事件执行情况
        verify(presenter).showHourTemperature();
    }

    @Test
    public void testPrecipitationClick(){
        TextView tvPrecipitation = (TextView) activity.findViewById(R.id.tvPrecipitation);
        //执行view点击方法
        tvPrecipitation.performClick();
        //验证点击事件执行情况
        verify(presenter).showPrecipitation();
    }

    @Test
    public void testWindPower(){
        TextView tvWindPower = (TextView) activity.findViewById(R.id.tvWindPower);
        //执行view点击方法
        tvWindPower.performClick();
        //验证点击事件执行情况
        verify(presenter).showWindPower();
    }

    @Test
    public void testOnDestroy(){
        activity.onDestroy();
        verify(presenter).cancelRequest();
    }

}