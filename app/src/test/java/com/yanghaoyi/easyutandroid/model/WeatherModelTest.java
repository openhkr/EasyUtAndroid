package com.yanghaoyi.easyutandroid.model;

import com.google.gson.Gson;
import com.yanghaoyi.easyutandroid.model.convert.WeatherDataConvert;
import com.yanghaoyi.easyutandroid.presenter.listener.WeatherRequestListener;
import com.yanghaoyi.net.ApiService;
import com.yanghaoyi.net.bean.WeatherData;
import com.yanghaoyi.net.code.ServerCode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Author : YangHaoyi on 2017/6/30.
 * Email  :  yanghaoyi@neusoft.com
 * Description :MVP---M test case example.
 * Change : YangHaoYi on 2017/6/30.
 * Version : V 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class WeatherModelTest {

    private WeatherModel model;

    @Mock
    ApiService api;
    @Mock
    WeatherDataConvert convertData;
    @Mock
    WeatherRequestListener listener;

    private static final String JSON_ROOT_PATH = "/json/";
    private String jsonFullPath;
    private WeatherData netData;
    private Map<String, String> queryMap;


    @Before
    public void setUp(){
        //Rx工具类把异步变成同步，方便测试
        RxUnitTestTools.openRxTools();
        model = new WeatherModel();
    }



    @Test
    @SuppressWarnings("unchecked")
    public void testParams(){
        model.request(listener,"沈阳");
        try {
            Field fieldParam = WeatherModel.class.getDeclaredField("queryMap");
            Field fieldKey = WeatherModel.class.getDeclaredField("CITY");
            fieldParam.setAccessible(true);
            setFinalStatic(fieldKey, true);
            Map<String, String> queryMaps = (Map<String, String>) fieldParam.get(model);
            String key = (String) fieldKey.get(model);
            assertEquals("验证queryMap的Key",key,"city");
            String city = queryMaps.get("city");
            assertEquals("验证queryMap的value",city,"沈阳");
        } catch (Exception e) {
            //no use
        }
    }


    @Test
    @SuppressWarnings("unchecked")
    public void testRequestSuccess(){
        //Initialize the Api call back data.
        //初始化模拟Api返回数据
        initResponse();
        //Make interface call back rule,when request getWeather then return the data we mocked.
        //设定模拟规则，当Api发送getWeather请求，返回预先模拟的返回结构体
        Mockito.when(api.getWeather(queryMap)).thenReturn(Observable.just(netData));
        ArgumentCaptor<WeatherData> captor = ArgumentCaptor.forClass(WeatherData.class);
        model.request(listener,"沈阳");
        //Execute the method
        //执行测试函数
        Mockito.verify(api).getWeather(queryMap);
        //验证显示加载进度条是否得到了调用
        Mockito.verify(listener).showLoading();
        //验证隐藏加载进度条是否得到了调用
        Mockito.verify(listener).hideLoading();
        //验证网络数据与视图数据转换是否得到了调用
        Mockito.verify(convertData).convertData(captor.capture());
        //参数捕获
        WeatherData result = captor.getValue();
        int status = result.getStatus();
        //验证参数捕获与模拟参数中code字段是否一致
        assertEquals("验证code",status,1000);
    }

    @Test
    public void testStatusError(){
        //Initialize the Api call back data.
        //初始化模拟Api返回数据
        initResponse();
        netData.setStatus(1001);
        //Make interface call back rule,when request getWeather then return the data we mocked.
        //设定模拟规则，当Api发送getWeather请求，返回预先模拟的返回结构体
        Mockito.when(api.getWeather(queryMap)).thenReturn(Observable.just(netData));
        ArgumentCaptor<WeatherData> captor = ArgumentCaptor.forClass(WeatherData.class);
        //Execute the method
        //执行测试函数
        model.request(listener,"沈阳");
        Mockito.verify(api).getWeather(queryMap);
        //验证显示加载进度条是否得到了调用
        Mockito.verify(listener).showLoading();
        //验证隐藏加载进度条是否得到了调用
        Mockito.verify(listener).fail(null, ServerCode.get(netData.getStatus()).getMessage());
    }


    @Test
    public void testRequestFail(){
        initResponse();
        //模拟一个异常信息
        Exception exception = new Exception("exception");
        //设定模拟规则，当Api发送getWeather请求，返回预先设定的异常
        Mockito.when(api.getWeather(queryMap)).thenReturn(Observable.error(exception));
        //Execute the method
        //执行测试函数
        model.request(listener,"沈阳");
        //验证listener执行fail函数
        Mockito.verify(listener).fail(null,"exception");
    }




    @Test
    public void testCancelRequest(){
        //创建mock模拟对象
        Subscription subscription = mock(Subscription.class);
        //将mock对象传入待测class
        model.setSubscription(subscription);
        //调用对应函数方法
        model.cancelRequest();
        //验证模拟class方法执行情况
        verify(subscription).unsubscribe();
    }


    private void initResponse(){
        //获取与服务端接口定义的Api返回Json体以.json的形式保留在本地test目录下的resources文件下
       try {
            jsonFullPath = getClass().getResource(JSON_ROOT_PATH).toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //weather.json与目录下的文件名保持一致
        String json = getResponseString("weather.json");
        //通过Gson将Json字符串转换成Java Bean
        Gson gson = new Gson();
        netData = gson.fromJson(json, WeatherData.class);
        model.setApiService(api);
        //Set the mock object into test class.
        //将mock对象赋值给待测类
        try {
            Field field = WeatherModel.class.getDeclaredField("convert");
            field.setAccessible(true);
            field.set(model, convertData);
        } catch (Exception e) {
            //no use
        }
        //Verify parameters if queryMap.city isn't equals "沈阳",this case will be fail.
        //验证请求参数“沈阳”的一致性
        queryMap = new HashMap<>();
        queryMap.put("city", "沈阳");
    }
    private String getResponseString(String fileName) {
        return FileUtil.readFile(jsonFullPath + fileName, "UTF-8").toString();
    }

    private void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
    }


}