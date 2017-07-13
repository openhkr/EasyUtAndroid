package com.yanghaoyi.easyutandroid.view;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.easyutandroid.BuildConfig;
import com.yanghaoyi.easyutandroid.MyRobolectricTestRunner;
import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.activity.WeatherActivity;
import com.yanghaoyi.easyutandroid.view.activity.WeatherHelpCenterActivity;
import com.yanghaoyi.easyutandroid.view.comp.PeopleView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;
import com.yanghaoyi.easyutandroid.view.holder.WeatherViewHolder;
import com.yanghaoyi.easyutandroid.view.impl.WeatherViewImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
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


    @Test
    public void testShowWeather(){
        TextView sunny = (TextView) activity.findViewById(R.id.tvWeather);
        view.showSunny();
        ShadowTextView stv = Shadows.shadowOf(sunny);
        assertEquals("验证晴天显示",stv.innerText(),"晴天");
        view.showRainy();
        assertEquals("验证雨天显示",stv.innerText(),"雨天");
        view.showCloudy();
        assertEquals("验证多云显示",stv.innerText(),"多云");
    }


    @Test
    public void testShowLightBaskNotice(){
        TextView lightBask = (TextView) activity.findViewById(R.id.tvBaskNotice);
        view.showLightBaskNotice();
        ShadowTextView stv = Shadows.shadowOf(lightBask);
        assertEquals("验证轻度紫外线",stv.innerText(),"紫外线指数良好");
        view.showMiddleBaskNotice();
        assertEquals("验证中度紫外线",stv.innerText(),"太阳眼镜,尽量躲在阴凉处");
        view.showHighBaskNotice();
        assertEquals("验证重度紫外线",stv.innerText(),"长袖衣物,上午十时至下午二时最好不要外出");
        view.showBaskDanger();
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

    @Test
    public void testToHelpCenter(){
        view.toHelpCenter();
        //设置期待Intent
        Intent expectedIntent = new Intent(activity, WeatherHelpCenterActivity.class);
        //获取实际Intent
        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();
        //通过Assert验证
        Assert.assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
    }

}
