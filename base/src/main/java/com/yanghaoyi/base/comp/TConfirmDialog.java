package com.yanghaoyi.base.comp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yanghaoyi.base.R;
import com.yanghaoyi.base.utils.ScreenUtils;


/**
 * Created by YangHaoyi on 2017/5/20.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class TConfirmDialog extends DialogFragment implements View.OnClickListener {

    private View dialog;
    private View view;


    private TextView tvTitle;
    private TextView tvConfirm;
    private TextView tvCancel;

    private FrameLayout room;
    private FrameLayout btConfirm;
    private FrameLayout btCancel;

    private String titleText = "";
    private String confirmText = "";
    private String cancelText = "";

    private JConfirmEvent event;


    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog = inflater.inflate(R.layout.pop_layer, container, false);
        initView();
        return dialog;
    }


    public void initView(){

        room = (FrameLayout)dialog.findViewById(R.id.room);
        view = inflater.inflate(R.layout.dialog_confirm, null);
        tvTitle = (TextView) view.findViewById(R.id.textView1);
        tvConfirm = (TextView)view.findViewById(R.id.confirmBtnText);
        tvCancel = (TextView)view.findViewById(R.id.cancelBtnText);

        btConfirm = (FrameLayout) view.findViewById(R.id.confirmBtn);
        btCancel = (FrameLayout) view.findViewById(R.id.cancelBtn);

        tvTitle.setText(titleText);
        tvConfirm.setText(confirmText);
        tvCancel.setText(cancelText);
        btConfirm.setOnClickListener(this);
        btCancel.setOnClickListener(this);

        FrameLayout.LayoutParams layoutParam = new FrameLayout.LayoutParams((int) (ScreenUtils.getScreenWidth(this.getContext())*0.7),
                android.app.ActionBar.LayoutParams.WRAP_CONTENT);
        layoutParam.gravity = Gravity.CENTER;
        room.addView(view,layoutParam);

    }


    public TConfirmDialog title(String titleText){
        this.titleText = titleText;
        return this;
    }

    public TConfirmDialog confirmText(String confirmText){
        this.confirmText = confirmText;
        return this;
    }
    public TConfirmDialog cancelText(String cancelText){
        this.cancelText = cancelText;
        return this;
    }
    public TConfirmDialog event(JConfirmEvent event){
        this.event = event;
        return this;
    }


    @Override
    public void onClick(View v) {
        if(btConfirm == v&&null!=event){
            event.executeConfirm();
        }
        if(btCancel == v&&null!=event){
            event.executeCancel();
        }
    }


    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvConfirm() {
        return tvConfirm;
    }

    public TextView getTvCancel() {
        return tvCancel;
    }

    public FrameLayout getBtConfirm() {
        return btConfirm;
    }

    public FrameLayout getBtCancel() {
        return btCancel;
    }
}
