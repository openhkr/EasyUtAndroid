package com.yanghaoyi.net.bean;

/**
 * Author : YangHaoyi on 2017/6/23.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 */

public class ForecastBean {
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;

    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
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

    public String getFengli() {
        return fengli;
    }

    public String getLow() {
        return low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public String getType() {
        return type;
    }
}
