package com.yanghaoyi.easyutandroid.model;

import com.yanghaoyi.easyutandroid.model.convert.WeatherDataConvert;
import com.yanghaoyi.easyutandroid.view.data.WeatherViewData;
import com.yanghaoyi.net.RequestListener;
import com.yanghaoyi.net.bean.WeatherData;
import com.yanghaoyi.net.code.ServerCode;
import com.yanghaoyi.net.model.AbstractBaasModel;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Author : YangHaoyi on 2017/6/15.
 * Email  :  yanghaoyi@neusoft.com
 * Description :数据请求model
 * Change : YangHaoYi on 2017/6/15.
 * Version : V 1.0
 */

public class WeatherModel extends AbstractBaasModel{

    private static final String CITY = "city";
    private WeatherDataConvert convert;

    public WeatherModel() {
        convert = new WeatherDataConvert();
    }

    public void request(final RequestListener<WeatherViewData> listener, String cityName) {
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put(CITY,cityName);
        listener.showLoading();
        subscription = apiService.getWeather(queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherData>() {
                    @Override
                    public void onCompleted() {
                        listener.hideLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.fail(null,e.getLocalizedMessage());
                    }

                    @Override
                    public void onNext(WeatherData netData) {
                        if(netData.getStatus()== ServerCode.CODE_SUCCESS.getCode()){
                            listener.success(convert.convertData(netData));
                        }else {
                            listener.fail(null,ServerCode.get(netData.getStatus()).getMessage());
                        }
                    }
                });

    }

    //页面关闭解注册，关闭请求
    public void cancelRequest(){
        subscription.unsubscribe();
    }

    public void setConvert(WeatherDataConvert convert) {
        this.convert = convert;
    }
}
