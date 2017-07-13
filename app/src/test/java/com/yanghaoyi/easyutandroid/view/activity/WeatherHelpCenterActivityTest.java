package com.yanghaoyi.easyutandroid.view.activity;

import android.widget.TextView;

import com.yanghaoyi.easyutandroid.BuildConfig;
import com.yanghaoyi.easyutandroid.MyRobolectricTestRunner;
import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.impl.WeatherHelpCenterImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;

import java.lang.reflect.Field;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by YangHaoyi on 2017/7/13.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class WeatherHelpCenterActivityTest {

    private WeatherHelpCenterActivity activity;
    private WeatherHelpCenterImpl view;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(WeatherHelpCenterActivity.class);
        view = mock(WeatherHelpCenterImpl.class);
    }


    @Test
    public void testClick(){

        TextView btTel = (TextView) activity.findViewById(R.id.btTelephone);
        btTel.performClick();
        try {
            // /通过类的字节码得到该类中声明的所有属性，无论私有或公有
            Field field = WeatherHelpCenterActivity.class.getDeclaredField("view");
            // 设置访问权限（这点对于有过android开发经验的可以说很熟悉）
            field.setAccessible(true);
            // 得到私有的变量值
            field.set(activity, view);
            btTel.performClick();
            verify(view).showTelDialog();
        } catch (Exception e) {
            //error
        }
    }

}