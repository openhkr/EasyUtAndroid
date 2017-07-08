package com.yanghaoyi.easyutandroid.model.convert;

import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;
import com.yanghaoyi.net.bean.WeatherData;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author : YangHaoyi on 2017/7/7.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/7/7.
 * Version : V 1.0
 */
public class WeatherDataConvertTest {

    private WeatherDataConvert convert;
    private static double DETAL = 0.1D;

    @Before
    public void setUp(){
        convert = new WeatherDataConvert();
    }

    @Test
    public void testTemperature(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        dataBean.setTemperature(10D);
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        //断言double不可以用assertEquals(message,double1,double2)
        //需要改用下面的方法，DETAL为误差值
        assertEquals(viewData.getTemperature(),10D,DETAL);
    }

    @Test
    public void testTemperatureNull(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        //断言double不可以用assertEquals(message,double1,double2)
        //需要改用下面的方法，DETAL为误差值
        assertEquals(viewData.getTemperature(),0D,DETAL);
    }

    @Test
    public void testTemperatureCauseDataNull(){
        WeatherData netData = new WeatherData();
        netData.setData(null);
        WeatherViewData viewData = convert.convertData(netData);
        //断言double不可以用assertEquals(message,double1,double2)
        //需要改用下面的方法，DETAL为误差值
        assertEquals(viewData.getTemperature(),0D,DETAL);
    }


    @Test
    public void testWeatherType(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        dataBean.setWeatherType(1);
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证天气类型不为空",viewData.getWeatherType(),1);
    }
    @Test
    public void testWeatherTypeNull(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证天气类型为空",viewData.getWeatherType(),0);
    }

    @Test
    public void testWeatherTypeCauseDataNull(){
        WeatherData netData = new WeatherData();
        netData.setData(null);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证天气类型为空",viewData.getWeatherType(),0);
    }

    @Test
    public void testUltraviolet(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        dataBean.setUltraviolet(2);
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证紫外线强度不为空",viewData.getUltraviolet(),2);
    }

    @Test
    public void testUltravioletNull(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证紫外线强度为空",viewData.getUltraviolet(),0);
    }
    @Test
    public void testUltravioletCauseDataNull(){
        WeatherData netData = new WeatherData();
        netData.setData(null);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证紫外线强度为空",viewData.getUltraviolet(),0);
    }

    @Test
    public void testRainFall(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        dataBean.setRainfall("20");
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证降雨量不为空",viewData.getRainfall(),"20");
    }

    @Test
    public void testRainFallNull(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证降雨量为空",viewData.getRainfall(),"");
    }

    @Test
    public void testRainFallCauseDataNull(){
        WeatherData netData = new WeatherData();
        netData.setData(null);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证降雨量为空",viewData.getRainfall(),"");
    }

    @Test
    public void testHourTemperature(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        dataBean.setHourTemperature("50");
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证小时温度不为空",viewData.getHourTemperature(),"50");
    }

    @Test
    public void testHourTemperatureNull(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证小时温度为空",viewData.getHourTemperature(),"");
    }
    @Test
    public void testHourTemperatureCauseNull(){
        WeatherData netData = new WeatherData();
        netData.setData(null);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证小时温度为空",viewData.getHourTemperature(),"");
    }

    @Test
    public void testWindPower(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        dataBean.setWindPower("100");
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证风力不为空",viewData.getWindPower(),"100");
    }

    @Test
    public void testWindPowerNull(){
        WeatherData netData = new WeatherData();
        WeatherData.DataBean dataBean = new WeatherData.DataBean();
        netData.setData(dataBean);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证风力为空",viewData.getWindPower(),"");
    }
    @Test
    public void testWindPowerCauseNull(){
        WeatherData netData = new WeatherData();
        netData.setData(null);
        WeatherViewData viewData = convert.convertData(netData);
        assertEquals("验证风力为空",viewData.getWindPower(),"");
    }


}