package com.yanghaoyi.easyutandroid.view.impl;

import android.widget.Toast;

import com.yanghaoyi.base.comp.JConfirmEvent;
import com.yanghaoyi.base.comp.TConfirmDialog;
import com.yanghaoyi.easyutandroid.R;
import com.yanghaoyi.easyutandroid.view.IHelpCenterView;
import com.yanghaoyi.easyutandroid.view.activity.WeatherHelpCenterActivity;
import com.yanghaoyi.easyutandroid.view.holder.HelpCenterViewHolder;

/**
 * Created by YangHaoyi on 2017/7/13.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class WeatherHelpCenterImpl implements IHelpCenterView, JConfirmEvent {

    private static final String TEL_DIALOG = "telDialog";
    private WeatherHelpCenterActivity mContext;
    private HelpCenterViewHolder mViewHolder;
    private TConfirmDialog telDialog;

    public WeatherHelpCenterImpl(WeatherHelpCenterActivity context,HelpCenterViewHolder viewHolder) {
        this.mContext = context;
        this.mViewHolder = viewHolder;
        telDialog = new TConfirmDialog();
    }

    @Override
    public void initTitle() {
        mViewHolder.getTvTitle().setText(mContext.getResources().getString(R.string.weather_help_center));
    }

    @Override
    public void showTelDialog() {
        telDialog.title(mContext.getResources().getString(R.string.weather_help_tel))
                .confirmText(mContext.getResources().getString(R.string.weather_help_tel_sure))
                .cancelText(mContext.getResources().getString(R.string.weather_help_tel_cancel))
                .event(this)
                .show(mContext.getSupportFragmentManager(), TEL_DIALOG);
    }

    @Override
    public void executeCancel() {
        if(telDialog.isVisible()){
            telDialog.dismiss();
        }
    }

    @Override
    public void executeConfirm() {
        if(telDialog.isVisible()){
            telDialog.dismiss();
            Toast.makeText(mContext, R.string.weather_teling,Toast.LENGTH_SHORT).show();
        }
    }
}
