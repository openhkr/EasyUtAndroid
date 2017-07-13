package com.yanghaoyi.easyutandroid.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.IHelpCenterView;
import com.yanghaoyi.easyutandroid.view.holder.HelpCenterViewHolder;
import com.yanghaoyi.easyutandroid.view.impl.WeatherHelpCenterImpl;

/**
 * Created by YangHaoyi on 2017/7/13.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class WeatherHelpCenterActivity extends FragmentActivity{

    private IHelpCenterView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);
        HelpCenterViewHolder viewHolder = new HelpCenterViewHolder(this);
        view = new WeatherHelpCenterImpl(this,viewHolder);
        view.initTitle();
        viewHolder.getBtTel().setOnClickListener(v -> view.showTelDialog());
    }
}
