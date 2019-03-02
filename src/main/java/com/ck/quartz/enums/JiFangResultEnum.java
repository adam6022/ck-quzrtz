package com.ck.quartz.enums;


public class JiFangResultEnum {

    public static String getStatus(String status) {
            if (status.equals("true")) {
                return "运行中";
            }
            if (status.equals("false")){
                return "未运行";
            }
        return null;
    }
}
