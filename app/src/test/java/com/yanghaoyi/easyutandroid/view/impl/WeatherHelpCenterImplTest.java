package com.yanghaoyi.easyutandroid.view.impl;

import android.app.Application;
import android.content.res.ColorStateList;
import android.widget.TextView;

import com.yanghaoyi.base.comp.TConfirmDialog;
import com.yanghaoyi.easyutandroid.BuildConfig;
import com.yanghaoyi.easyutandroid.MyRobolectricTestRunner;
import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.activity.WeatherHelpCenterActivity;
import com.yanghaoyi.easyutandroid.view.holder.HelpCenterViewHolder;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by YangHaoyi on 2017/7/13.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */
@RunWith(MyRobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class WeatherHelpCenterImplTest {

    private WeatherHelpCenterActivity activity;
    private WeatherHelpCenterImpl view;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(WeatherHelpCenterActivity.class);
        HelpCenterViewHolder viewHolder = new HelpCenterViewHolder(activity);
        view = new WeatherHelpCenterImpl(activity,viewHolder);
    }

    @Test
    public void testInitTitle(){
        TextView tvTitle = (TextView) activity.findViewById(R.id.tvTitle);
        view.initTitle();
        String title = tvTitle.getText().toString();
        assertEquals("验证标题初始化",title,"帮助中心");
        Application application = RuntimeEnvironment.application;
        ColorStateList color = ColorStateList.valueOf(application.getResources().getColor(R.color.colorWhite));
        assertEquals("验证颜色",color,tvTitle.getTextColors());
    }


    @Test
    public void testShowTelDialog(){
        view.showTelDialog();
        //因为提示框 dialog 在 view 中属于私有变量，不需要对外暴露方法，如果为了测试而写一个get set 方法似乎太过牵强
        //所以采用 Java 反射的方法获取dialog对象
        try {
            // /通过类的字节码得到该类中声明的所有属性，无论私有或公有
            Field field = WeatherHelpCenterImpl.class.getDeclaredField("telDialog");
            // 设置访问权限（这点对于有过android开发经验的可以说很熟悉）
            field.setAccessible(true);
            // 得到私有的变量值
            Object dialog = field.get(view);
            TConfirmDialog telDialog = (TConfirmDialog) dialog;

            //获取到Dialog对象之后，再通过反射获取Dialog中TextView对象
            Field fieldDialog = TConfirmDialog.class.getDeclaredField("tvTitle");
            // 设置访问权限
            fieldDialog.setAccessible(true);
            //获取telDialog中的TextView对象
            Object title = fieldDialog.get(telDialog);
            TextView tvTitle = (TextView) title;
            //通过assert方法验证标题
            assertEquals("验证标题",tvTitle.getText().toString(),"客服电话");

            //获取到Dialog对象之后，再通过反射获取Dialog中TextView对象
            fieldDialog = TConfirmDialog.class.getDeclaredField("tvConfirm");
            //获取telDialog中的TextView对象
            Object confirm = fieldDialog.get(telDialog);
            TextView tvConfirm = (TextView) confirm;
            //通过assert方法验证标题
            assertEquals("验证确定按钮",tvConfirm.getText().toString(),"拨打电话");

            //获取到Dialog对象之后，再通过反射获取Dialog中TextView对象
            fieldDialog = TConfirmDialog.class.getDeclaredField("tvCancel");
            //获取telDialog中的TextView对象
            Object cancel = fieldDialog.get(telDialog);
            TextView tvCancel = (TextView) cancel;
            //通过assert方法验证标题
            assertEquals("验证取消按钮",tvCancel.getText().toString(),"取消");


        } catch (Exception e) {
            //error
        }
    }

    @Test
    public void testExecuteCancel(){

       view.showTelDialog();
        try {
            // /通过类的字节码得到该类中声明的所有属性，无论私有或公有
            Field field = WeatherHelpCenterImpl.class.getDeclaredField("telDialog");
            // 设置访问权限（这点对于有过android开发经验的可以说很熟悉）
            field.setAccessible(true);
            // 得到私有的变量值
            Object dialog = field.get(view);
            TConfirmDialog telDialog = (TConfirmDialog) dialog;
            assertTrue("验证dialog显示",telDialog.isVisible());
            view.executeCancel();
            assertFalse("验证dialog隐藏",telDialog.isVisible());
            //验证dialog隐藏状态
            view.executeCancel();
        } catch (Exception e) {
            //error
        }

    }

    @Test
    public void testExecuteConfirm(){
        view.showTelDialog();
        try {
            // /通过类的字节码得到该类中声明的所有属性，无论私有或公有
            Field field = WeatherHelpCenterImpl.class.getDeclaredField("telDialog");
            // 设置访问权限（这点对于有过android开发经验的可以说很熟悉）
            field.setAccessible(true);
            // 得到私有的变量值
            Object dialog = field.get(view);
            TConfirmDialog telDialog = (TConfirmDialog) dialog;
            assertTrue("验证dialog显示",telDialog.isVisible());
            view.executeConfirm();
            assertFalse("验证dialog隐藏",telDialog.isVisible());
            Assert.assertEquals("电话拨打中。。。", ShadowToast.getTextOfLatestToast());
            //验证dialog隐藏状态
            view.executeConfirm();
        } catch (Exception e) {
            //error
        }
    }

}