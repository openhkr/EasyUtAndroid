package com.yanghaoyi.net.bean;

/**
 * Author : YangHaoyi on 2017/6/23.
 * Email  :  yanghaoyi@neusoft.com
 * Description :中国天气网数据Data
 * Change : YangHaoYi on 2017/6/23.
 * Version : V 1.0
 */

public class YesterdayBean {

    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;

    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public String getHigh() {
        return high;
    }

    public String getFx() {
        return fx;
    }

    public String getLow() {
        return low;
    }

    public String getFl() {
        return fl;
    }

    public String getType() {
        return type;
    }
}
