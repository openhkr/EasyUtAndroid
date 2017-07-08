package com.yanghaoyi.net.params;

/**
 * Author : YangHaoyi on 2017/6/15.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/15.
 * Version : V 1.0
 */

public class BaseRequestParam <T> {

    protected T params;

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}
