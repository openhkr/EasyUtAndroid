package com.yanghaoyi.base.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by YangHaoyi on 2017/7/13.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class ScreenUtils {

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager)context.getSystemService("window");
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }
}
