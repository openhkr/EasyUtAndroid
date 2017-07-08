package com.yanghaoyi.easyutandroid.presenter.chain.sunny;

import com.yanghaoyi.easyutandroid.view.IWeatherView;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;

/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public abstract class AbstractBaskHandler {
    /**
     * 持有下一个处理请求的对象
     */
    protected AbstractBaskHandler successor;
    /**
     * 设置下一个处理请求的对象
     */

    public void setSuccessor(AbstractBaskHandler successor) {
        this.successor = successor;
    }

    public abstract void handleBask(WeatherViewData viewData, IWeatherView view);

}
