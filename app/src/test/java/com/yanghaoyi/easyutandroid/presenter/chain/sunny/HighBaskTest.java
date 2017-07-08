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
 * Description : 这是一条对责任链其中一条责任人的单元测试，对于嵌套逻辑，测试case要想覆盖的全面，
 *               就必须覆盖每一个条件分支，过程繁琐且容易遗漏，设计模式的引入可以有效的避免逻辑
 *               嵌套，方便写测试代码的同时也促进着业务代码写的更整洁。
 * Version :
 */
public class HighBaskTest {

    private HighBask highBask;
    private IWeatherView view;

    @Before
    public void setUp(){
        //创建测试对象
        highBask = new HighBask();
        //创建mock对象
        view = mock(IWeatherView.class);
    }

    @Test
    public void testHandleBaskOverHigh(){
        WeatherViewData viewData = new WeatherViewData();
        //对判断条件进行预期值赋值(预期值是>9的int型执行if语句)
        viewData.setUltraviolet(10);
        //执行待测函数
        highBask.handleBask(viewData,view);
        //验证mock对象的方法是否得到了正确调用
        verify(view).showBaskDanger();
    }

    @Test
    public void testHandleBask(){
        WeatherViewData viewData = new WeatherViewData();
        //对判断条件进行预期值赋值(预期值是>9的int型执行if语句)
        viewData.setUltraviolet(8);
        //执行待测函数
        highBask.handleBask(viewData,view);
        //验证mock对象的方法是否得到了正确调用
        verify(view).showHighBaskNotice();
        verify(view).dressLongSleeve();
    }


}