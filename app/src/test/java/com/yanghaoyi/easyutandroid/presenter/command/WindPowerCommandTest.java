package com.yanghaoyi.easyutandroid.presenter.command;

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
public class WindPowerCommandTest {

    private WindPowerCommand command;
    private IWeatherView view;

    @Before
    public void setUp(){
        //setUp方法为每个测试case执行之前所执行的方法
        view = mock(IWeatherView.class);
        //要在new出测试对象前对mock对象赋值，否则会造成NPE
        command = new WindPowerCommand(view);
    }

    @Test
    public void testExecute(){
        //执行测试函数
        command.execute();
        //验证测试函数执行情况
        verify(view).resetCommandTab();
        verify(view).showWindPower();
    }


}