package com.yanghaoyi.net.model;


import android.content.Context;

import com.yanghaoyi.net.ApiService;
import com.yanghaoyi.net.RequestListener;
import com.yanghaoyi.net.client.RetrofitNetHelper;
import com.yanghaoyi.net.params.BaseRequestParam;

import rx.Subscription;

/**
 * Author : YangHaoyi on 2017/6/15.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/15.
 * Version : V 1.0
 */

public abstract class AbstractBaasModel {

    protected RetrofitNetHelper client;
    protected ApiService apiService;
    protected String tag = "Hkr_";
    protected Subscription subscription;


    public AbstractBaasModel() {
        client = RetrofitNetHelper.getInstance();
        apiService = client.init(tag).create(ApiService.class);
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public void setApiService(ApiService apiService) {
        this.apiService = apiService;
    }
}
