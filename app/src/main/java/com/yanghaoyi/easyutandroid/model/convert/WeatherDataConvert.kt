package com.yanghaoyi.easyutandroid.model.convert

import com.yanghaoyi.easyutandroid.view.data.WeatherViewData
import com.yanghaoyi.net.bean.WeatherData

/**
 * Author : YangHaoyi on 2017/6/28.
 * Email  :  yanghaoyi@neusoft.com
 * Description :网络数据与视图数据转换器
 * Change : YangHaoYi on 2017/6/28.
 * Version : V 1.0
 */
open class WeatherDataConvert {

    open fun convertData(netData: WeatherData):WeatherViewData{
        val viewData = WeatherViewData()
        viewData.temperature = netData.data?.temperature?:0.0
        viewData.weatherType = netData.data?.weatherType?:1
        viewData.ultraviolet = netData.data?.ultraviolet?:0
        viewData.rainfall = netData.data?.rainfall?:"0"
        viewData.hourTemperature = netData.data?.hourTemperature?:"10"
        viewData.windPower = netData.data?.windPower?:"2"
        return  viewData
    }

}