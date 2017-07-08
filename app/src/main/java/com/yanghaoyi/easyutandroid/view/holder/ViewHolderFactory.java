package com.yanghaoyi.easyutandroid.view.holder;

import com.yanghaoyi.easyutandroid.view.activity.WeatherActivity;

/**
 * Created by YangHaoyi on 2017/7/8.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class ViewHolderFactory {

    private WeatherViewHolder viewHolder;

    public ViewHolderFactory build(WeatherActivity activity){
        viewHolder = new WeatherViewHolder(activity);
        return this;
    }

    public void updateViewHolder(IViewHolderUpdater updater){
        updater.updateViewHolder(viewHolder);
    }

}
