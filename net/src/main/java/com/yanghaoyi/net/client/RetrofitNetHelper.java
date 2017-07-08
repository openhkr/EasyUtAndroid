package com.yanghaoyi.net.client;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Author : YangHaoyi on 2017/6/14.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/14.
 * Version : V 1.0
 */

public class RetrofitNetHelper {

    public static RetrofitNetHelper mInstance;

    public Retrofit mRetrofit;
    //本地ip为192.168.1.103
    public static final String BASE_URL = "http://wthrcdn.etouch.cn/";
    private String baseUrl = BASE_URL;
    private RetrofitNetHelper(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
    }
    public static RetrofitNetHelper getInstance(){
        if(mInstance==null){
            synchronized (RetrofitNetHelper.class){
                if(mInstance==null)
                    mInstance = new RetrofitNetHelper();
            }
        }
        return mInstance ;
    }

    public Retrofit init(String tag){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mRetrofit;
    }
}
