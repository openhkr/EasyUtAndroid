package com.yanghaoyi.net;


import com.yanghaoyi.net.bean.WeatherData;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Author : YangHaoyi on 2017/6/14.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/14.
 * Version : V 1.0
 */

public interface ApiService {

    @GET("weather_mini")
    Observable<WeatherData> getWeather(@QueryMap Map<String, String> queryMap);

}
