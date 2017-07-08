package com.yanghaoyi.easyutandroid.presenter.strategy.weather;

import org.junit.Test;

import static com.yanghaoyi.easyutandroid.presenter.strategy.weather.WeatherType.SUNNY;
import static org.junit.Assert.assertEquals;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */
public class WeatherTypeTest {

    @Test
    public void testValueOf(){
        assertEquals("",WeatherType.valueOf("SUNNY"), SUNNY);
    }

}