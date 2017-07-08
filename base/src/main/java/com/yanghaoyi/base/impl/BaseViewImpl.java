package com.yanghaoyi.base.impl;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.yanghaoyi.base.ILoadingView;
import com.yanghaoyi.base.comp.LoadingView;
import com.yanghaoyi.base.holder.BaseViewHolder;


/**
 * Author : YangHaoyi on 2017/6/27.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/6/27.
 * Version : V 1.0
 */

public class BaseViewImpl implements ILoadingView {

    private FrameLayout room;
    private Context mContext;
    private View cover;

    public BaseViewImpl(BaseViewHolder viewHolder, Context context) {
        this.mContext = context;
        room = viewHolder.getRoom();
    }

    @Override
    public void showLoading() {
        hideLoading();
        cover = new LoadingView(mContext);
        room.addView(cover);
    }

    @Override
    public void hideLoading() {
        if (null != cover) {
            room.removeView(cover);
            cover = null;
        }
    }
}
