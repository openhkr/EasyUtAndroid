package com.yanghaoyi.easyutandroid;

import org.junit.runners.model.InitializationError;
import org.robolectric.RoboSettings;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.internal.bytecode.ShadowMap;

/**
 * Created by YangHaoyi on 2017/5/15.
 * Email  : yanghaoyi@neusoft.com
 * Description :
 * Version :
 */

public class MyRobolectricTestRunner extends RobolectricTestRunner {
    public MyRobolectricTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);

        // 从源码知道MavenDependencyResolver默认以RoboSettings的repositoryUrl和repositoryId为默认值，因此只需要对RoboSetting进行赋值即可
        RoboSettings.setMavenRepositoryId("alimaven");
        RoboSettings.setMavenRepositoryUrl("http://maven.aliyun.com/nexus/content/groups/public/");
    }

    @Override
    protected ShadowMap createShadowMap() {
        return super.createShadowMap()
                .newBuilder()
                .build();
    }
}
