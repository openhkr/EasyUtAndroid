package com.yanghaoyi.easyutandroid.model;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.plugins.RxJavaPlugins;
import rx.plugins.RxJavaSchedulersHook;
import rx.schedulers.Schedulers;

/**
 * Author : YangHaoyi on 2017/4/12.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 */

public final class RxUnitTestTools {
    private static boolean isInitRxTools;


    private RxUnitTestTools(){
        throw new IllegalAccessError("Utility class");
    }


    /**
     * 把异步变成同步，方便测试
     */
    public static void openRxTools() {
        if (isInitRxTools) {
            return;
        }
        isInitRxTools = true;




        RxAndroidSchedulersHook rxAndroidSchedulersHook = new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        };
        // reset()不是必要，实践中发现不写reset()，偶尔会出错，所以写上保险^_^
        RxAndroidPlugins.getInstance().reset();
        RxAndroidPlugins.getInstance().registerSchedulersHook(rxAndroidSchedulersHook);
        RxJavaPlugins.getInstance().reset();
        RxJavaSchedulersHook rxJavaSchedulersHook = new RxJavaSchedulersHook() {
            @Override
            public Scheduler getIOScheduler() {
                return Schedulers.immediate();
            }
        };
        RxJavaPlugins.getInstance().registerSchedulersHook(rxJavaSchedulersHook);
    }
}
