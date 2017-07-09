package com.yanghaoyi.easyutandroid.view;

import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.easyutandroid.BuildConfig;
import com.yanghaoyi.easyutandroid.MyRobolectricTestRunner;
import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.activity.WeatherActivity;
import com.yanghaoyi.easyutandroid.view.comp.PeopleView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;
import com.yanghaoyi.easyutandroid.view.holder.WeatherViewHolder;
import com.yanghaoyi.easyutandroid.view.impl.WeatherViewImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowTextView;
import org.robolectric.shadows.ShadowToast;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WeatherViewImplTest {

    private WeatherActivity activity;
    private WeatherViewHolder viewHolder;
    private WeatherViewImpl view;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(WeatherActivity.class);
        viewHolder = new WeatherViewHolder(activity);
        view = new WeatherViewImpl(viewHolder,activity);
    }

    @Test
    public void testDressGlass(){
        view.dressSunGlass();
        TextView glass = (TextView) viewHolder.getvPeople().findViewById(R.id.tvGlass);
        //执行view对应方法
        view.dressSunGlass();
        //验证dressSunGlass函数执行情况
        assertTrue("验证太阳镜是否显示",glass.getVisibility()== View.VISIBLE);
    }

    @Test
    public void testShowDataError(){
        view.showDataError();
        assertEquals("数据转换异常", ShadowToast.getTextOfLatestToast());
    }




    /**
     *
     * Notice :对于多个函数操作同一个TextView的情况使用testDressGlass() case的方法会发生异常
     *         现象为多个case 互相影响，第一个case对TextView赋值，第二个再赋值验证的时候会取到
     *         第一个case的值，单个case 100%运行成功，多个case同时执行会有5%的几率产生相互影响
     *         事件。尝试Junit自带的 @After tearDown()方法未见明显效果，采用
     *         @FixMethodOrder(MethodSorters.NAME_ASCENDING) 来固定case执行顺序解决相互
     *         影响问题。
     *
     * **/

    @Test
    public void testShowSunny(){
        TextView sunny = (TextView) activity.findViewById(R.id.tvWeather);
        view.showSunny();
        ShadowTextView stv = Shadows.shadowOf(sunny);
        assertEquals("验证晴天显示",stv.innerText(),"晴天");
    }

    @Test
    public void testShowRainy(){
        TextView rainy = (TextView) activity.findViewById(R.id.tvWeather);
        view.showRainy();
        ShadowTextView stv = Shadows.shadowOf(rainy);
        assertEquals("验证雨天显示",stv.innerText(),"雨天");
    }

    @Test
    public void testShowCloudy(){
        TextView cloudy = (TextView) activity.findViewById(R.id.tvWeather);
        view.showCloudy();
        ShadowTextView stv = Shadows.shadowOf(cloudy);
        assertEquals("验证多云显示",stv.innerText(),"多云");
    }

    @Test
    public void testShowLightBaskNotice(){
        TextView lightBask = (TextView) activity.findViewById(R.id.tvBaskNotice);
        view.showLightBaskNotice();
        ShadowTextView stv = Shadows.shadowOf(lightBask);
        assertEquals("验证轻度紫外线",stv.innerText(),"紫外线指数良好");
    }

    @Test
    public void testShowMiddleBaskNotice(){
        TextView middleBask = (TextView) activity.findViewById(R.id.tvBaskNotice);
        view.showMiddleBaskNotice();
        ShadowTextView stv = Shadows.shadowOf(middleBask);
        assertEquals("验证中度紫外线",stv.innerText(),"太阳眼镜,尽量躲在阴凉处");
    }

    @Test
    public void testShowHighBaskNotice(){
        TextView highBask = (TextView) activity.findViewById(R.id.tvBaskNotice);
        view.showHighBaskNotice();
        ShadowTextView stv = Shadows.shadowOf(highBask);
        assertEquals("验证重度紫外线",stv.innerText(),"长袖衣物,上午十时至下午二时最好不要外出");
    }

    @Test
    public void testShowBaskDanger(){
        //通过Id找到View实体
        TextView dangerBask = (TextView) activity.findViewById(R.id.tvBaskNotice);
        //执行待验证方法
        view.showBaskDanger();
        ShadowTextView stv = Shadows.shadowOf(dangerBask);
        //验证TextView的文字显示
        assertEquals("验证危险紫外线",stv.innerText(),"紫外线指数过高，不建议出行");
    }

    @Test
    public void testDressLongSleeve(){
        //执行待验证方法
        view.dressLongSleeve();
        //通过Id找到View实体
        PeopleView peopleView = (PeopleView) activity.findViewById(R.id.vPeople);
        //验证View的显示与隐藏
        assertTrue(peopleView.getTvLongSleeve().getVisibility()==View.VISIBLE);
    }

    @Test
    public void testDressSunGlass(){
        view.dressSunGlass();
        //通过Id找到View实体
        PeopleView peopleView = (PeopleView) activity.findViewById(R.id.vPeople);
        //验证View的显示与隐藏
        assertTrue(peopleView.getTvGlass().getVisibility()==View.VISIBLE);

    }



    @Test
    public void testShowTemperature(){
        //模拟视图数据
        WeatherViewData viewData = new WeatherViewData();
        viewData.setTemperature(23.1D);
        view.updateCache(viewData);
        //执行待测函数
        view.showTemperature();
        //通过Id获得view实体
        TextView tvTemperature = (TextView) activity.findViewById(R.id.tvTemperature);
        String text = tvTemperature.getText().toString();
        //验证文字显示
        assertEquals("验证温度",text,"23.1");
    }

    @Test
    public void testShowHourTemperature(){
        //模拟视图数据
        WeatherViewData viewData = new WeatherViewData();
        viewData.setHourTemperature("26");
        view.updateCache(viewData);
        //执行待测函数
        view.showHourTemperature();
        //通过Id获得view实体
        TextView tvHourTemperature = (TextView) activity.findViewById(R.id.tvHourTemperature);
        String text = tvHourTemperature.getText().toString();
        //验证文字显示
        assertEquals("验证温度",text,"24小时温度均值26");
    }

    @Test
    public void testShowPrecipitation(){
        //模拟视图数据
        WeatherViewData viewData = new WeatherViewData();
        viewData.setRainfall("30");
        view.updateCache(viewData);
        //执行待测函数
        view.showPrecipitation();
        //通过Id获得view实体
        TextView tvPrecipitation = (TextView) activity.findViewById(R.id.tvPrecipitation);
        String text = tvPrecipitation.getText().toString();
        //验证文字显示
        assertEquals("验证降雨量",text,"降雨量均值30");
    }

    @Test
    public void testShowWindPower(){
        //模拟视图数据
        WeatherViewData viewData = new WeatherViewData();
        viewData.setWindPower("5");
        view.updateCache(viewData);
        //执行待测函数
        view.showWindPower();
        //通过Id获得view实体
        TextView tvWindPower = (TextView) activity.findViewById(R.id.tvWindPower);
        String text = tvWindPower.getText().toString();
        //验证文字显示
        assertEquals("验证风力",text,"风力均值5");
    }

    @Test
    public void testResetCommandTab(){
        //执行待测函数
        view.resetCommandTab();
        //通过Id获得view实体
        TextView tvPrecipitation = (TextView) activity.findViewById(R.id.tvPrecipitation);
        TextView tvWindPower = (TextView) activity.findViewById(R.id.tvWindPower);
        TextView tvHourTemperature = (TextView) activity.findViewById(R.id.tvHourTemperature);
        String hourTemperature = tvHourTemperature.getText().toString();
        String precipitation = tvPrecipitation.getText().toString();
        String windPower = tvWindPower.getText().toString();
        //验证文字显示
        assertEquals("验证温度",hourTemperature,"24小时温度均值");
        assertEquals("验证降雨量",precipitation,"降雨量均值");
        assertEquals("验证风力",windPower,"风力均值");
    }


    @Test
    public void testLocationCity(){
        String city = view.getLocationCity();
        assertEquals("验证返回城市",city,"沈阳");
    }


    @After
    public void tearDown(){
        activity.finish();
        TextView tvWeather = (TextView) activity.findViewById(R.id.tvWeather);
        tvWeather.setText("");
        TextView tvBaskNotice = (TextView) activity.findViewById(R.id.tvBaskNotice);
        tvBaskNotice.setText("");
    }

}
