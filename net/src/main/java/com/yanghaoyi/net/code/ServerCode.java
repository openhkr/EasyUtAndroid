package com.yanghaoyi.net.code;

/**
 * Author : YangHaoyi on 2017/7/7.
 * Email  :  yanghaoyi@neusoft.com
 * Description :
 * Change : YangHaoYi on 2017/7/7.
 * Version : V 1.0
 */

public enum  ServerCode {
    CODE_SUCCESS(1000, ""),
    CODE_ERROR(999,"");


    private int code;
    private String message;

    ServerCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
    public int getCode() {
        return code;
    }

    public static ServerCode get(int code) {
        ServerCode[] values = ServerCode.values();
        for (int i = 0; i != values.length; i++) {
            if (values[i].code == code) {
                return values[i];
            }
        }
        return CODE_ERROR;
    }
}
