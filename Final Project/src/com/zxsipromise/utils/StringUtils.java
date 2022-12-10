package com.zxsipromise.utils;

public class StringUtils {
    /*
    to determin if this string is empty
     */
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
