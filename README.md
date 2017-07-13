# EasyUtAndroid
全面的android应用单元测试方法及案例
1.0版本
结合Junit Mockito与Robolectric实现对MVP架构下数据层，视图层，逻辑层覆盖率100%的全面单元测试

![](https://github.com/openhkr/EasyUtAndroid/blob/master/screenshots/jacoco.png)

环境搭建

   由于基于Android sdk 环境的安卓单元测试存在依赖安卓设备，需要打包安装，运行速度慢等原因，故单元测试选型为Junit与mockito相结合并配合robolectric基于纯Java环境下的单元测试。
首先在build.gradle文件的dependencies下添加test依赖，对于担心添加依赖影响安卓apk安装包大小的同学可以不必担心，因为testCompile的依赖仅供test文件使用，是不会打包的apk中的。如果你愿意，其实添加多少test依赖都无所谓。

    testCompile 'junit:junit:4.12'
    testCompile "org.mockito:mockito-core:1.9.5"
    testCompile 'org.robolectric:robolectric:3.3.2'
    testCompile 'org.robolectric:shadows-support-v4:3.0'

  依赖添加完成不要忘记点击工程右上角Sync Now 来同步
  如果testCompile依赖下载很慢，可以尝试在整个工程的build.gradle文件下修改Jcenter()如下

    repositories {
        jcenter(){ url 'http://jcenter.bintray.com/'}
        mavenCentral()
    }
    
  原理其实很简单，Jcenter默认是以https形式进行从仓库下载资源，这里是修改其下载资源的url为http。
  同理由于robolectric需要从oss.sonatype.org下载一些必要的依赖包，但是oss.sonatype.org是国外的网站，下载速度感人。这里同样需要修改整个工程的build.gradle文件，不过这次是修改maven{}为阿里云的代理。

  gradle task使用方法如下图
  
  ![](https://github.com/openhkr/EasyUtAndroid/blob/master/screenshots/jacoco_task.png)



   对于私有变量private的测试

  //因为提示框 dialog 在 view 中属于私有变量，不需要对外暴露方法，如果为了测试而写一个get set 方法似乎太过牵强
  //所以采用 Java 反射的方法获取dialog对象
   
   
        view.showTelDialog();
        try {
            // /通过类的字节码得到该类中声明的所有属性，无论私有或公有
            Field field = WeatherHelpCenterImpl.class.getDeclaredField("telDialog");
            // 设置访问权限（这点对于有过android开发经验的可以说很熟悉）
            field.setAccessible(true);
            // 得到私有的变量值
            Object dialog = field.get(view);
            TConfirmDialog telDialog = (TConfirmDialog) dialog;

            //获取到Dialog对象之后，再通过反射获取Dialog中TextView对象
            Field fieldDialog = TConfirmDialog.class.getDeclaredField("tvTitle");
            // 设置访问权限
            fieldDialog.setAccessible(true);
            //获取telDialog中的TextView对象
            Object title = fieldDialog.get(telDialog);
            TextView tvTitle = (TextView) title;
            //通过assert方法验证标题
            assertEquals("验证标题",tvTitle.getText().toString(),"客服电话");

            //获取到Dialog对象之后，再通过反射获取Dialog中TextView对象
            fieldDialog = TConfirmDialog.class.getDeclaredField("tvConfirm");
            //获取telDialog中的TextView对象
            Object confirm = fieldDialog.get(telDialog);
            TextView tvConfirm = (TextView) confirm;
            //通过assert方法验证标题
            assertEquals("验证确定按钮",tvConfirm.getText().toString(),"拨打电话");

            //获取到Dialog对象之后，再通过反射获取Dialog中TextView对象
            fieldDialog = TConfirmDialog.class.getDeclaredField("tvCancel");
            //获取telDialog中的TextView对象
            Object cancel = fieldDialog.get(telDialog);
            TextView tvCancel = (TextView) cancel;
            //通过assert方法验证标题
            assertEquals("验证取消按钮",tvCancel.getText().toString(),"取消");


        } catch (Exception e) {
            //error
        }   



















问题反馈回执：   

   感谢Jaggerer同学的反馈，为了响应谷歌kotlin第一开发言语的号召，同时也因为java8 Optional需要api 24以致无法广泛推广等原因，工程中对数据判空类
WeatherDataConvert参与了kontlin编写，愿意尝试kontlin的同学可以使用Android Studio下载Kotlin相关插件    

   执行 Settings -> plugins -> BrowseRepositories中搜索“Kotlin”   
   
   暂时还不愿意下载插件的同学可以将WeatherDataConvert转成java文件以使用。    
   
 public class WeatherDataConvert {

    public WeatherViewData convertData(WeatherData netData){

        WeatherViewData viewData = new WeatherViewData();
        if(null!=netData.getData()&&null!=netData.getData().getTemperature()){
            viewData.setTemperature(netData.getData().getTemperature());
        }else {
            viewData.setTemperature(0.0);
        }
        if(null!=netData.getData()&&null!=netData.getData().getWeatherType()){
            viewData.setWeatherType(netData.getData().getWeatherType());
        }else {
            viewData.setWeatherType(1);
        }
        if(null!=netData.getData()&&null!=netData.getData().getUltraviolet()){
            viewData.setUltraviolet(netData.getData().getUltraviolet());
        }else {
            viewData.setUltraviolet(0);
        }
        if(null!=netData.getData()&&null!=netData.getData().getRainfall()){
            viewData.setRainfall(netData.getData().getRainfall());
        }else {
            viewData.setRainfall("0");
        }
        if(null!=netData.getData()&&null!=netData.getData().getHourTemperature()){
            viewData.setHourTemperature(netData.getData().getHourTemperature());
        }else {
            viewData.setHourTemperature("10");
        }
        if(null!=netData.getData()&&null!=netData.getData().getWindPower()){
            viewData.setWindPower(netData.getData().getWindPower());
        }else {
            viewData.setWindPower("2");
        }
        return viewData;
    }

}




