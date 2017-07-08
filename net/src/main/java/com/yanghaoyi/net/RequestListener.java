package com.yanghaoyi.net;

/**
 * Author : YangHaoyi on 2017/6/15.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/15.
 * Version : V 1.0
 */

public interface RequestListener<T> {

    void success(T response);

    void fail(T response, String msg);

    void showLoading();

    void hideLoading();
}
