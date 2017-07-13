package com.yanghaoyi.easyutandroid.view.holder;

import android.widget.TextView;

import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.activity.WeatherHelpCenterActivity;

/**
 * Created by YangHaoyi on 2017/7/13.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class HelpCenterViewHolder {

    private TextView tvTitle;
    private TextView btTel;


    public HelpCenterViewHolder(WeatherHelpCenterActivity activity){
        tvTitle = (TextView) activity.findViewById(R.id.tvTitle);
        btTel = (TextView) activity.findViewById(R.id.btTelephone);
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getBtTel() {
        return btTel;
    }
}
