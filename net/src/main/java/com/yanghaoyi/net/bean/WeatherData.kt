package com.yanghaoyi.net.bean

/**
 * Author : YangHaoyi on 2017/6/23.
 * Email  :  yanghaoyi@neusoft.com
 * Description :中国天气网数据Data
 * Change : YangHaoYi on 2017/6/23.
 * Version : V 1.0
 */

class WeatherData : ResponseDataBean<WeatherData.DataBean>() {


    class DataBean {
        var temperature:Double ? =null
        var weatherType:Int ? =null
        var ultraviolet:Int ?= null
        var rainfall :String ?= null
        var hourTemperature:String ?=null
        var windPower:String ?=null
    }
}
