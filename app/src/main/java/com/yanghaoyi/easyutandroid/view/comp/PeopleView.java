package com.yanghaoyi.easyutandroid.view.comp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yanghaoyi.easyutandroid.R;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class PeopleView extends LinearLayout{

    private TextView tvGlass;
    private TextView tvLongSleeve;

    public PeopleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_people, this);
        init();
    }


    private void init(){
        tvGlass = (TextView) findViewById(R.id.tvGlass);
        tvLongSleeve = (TextView) findViewById(R.id.tvLongSleeve);
    }

    public void dressGlass(){
        tvGlass.setVisibility(VISIBLE);
    }

    public void dressLongSleeve(){
        tvLongSleeve.setVisibility(VISIBLE);
    }

    public TextView getTvGlass() {
        return tvGlass;
    }

    public TextView getTvLongSleeve() {
        return tvLongSleeve;
    }
}
