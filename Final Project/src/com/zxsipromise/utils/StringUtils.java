package com.zxsipromise.utils;

public class StringUtils {
    public static boolean isEmpty(String str){
        if (str == null || "".equals(str.trim())){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isNoEmpty(String str){
        if (str == null && "".equals(str.trim())){
            return true;
        }else {
            return false;
        }
    }
}
