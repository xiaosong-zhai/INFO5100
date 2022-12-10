package com.zxsipromise.utils;

import com.zxsipromise.model.User;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginConfig {
    /*
    sava username and password in password.txt file
     */
    public static void save(User user){
        List<String> list = new ArrayList<>();
        list.add("name" + user.getUsername());
        list.add("pwd" + user.getPassword());
        list.add("uid" + user.getId());
        try {
            FileUtils.writeLines(new File("password.txt"), list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    read file then get the username and password
     */
    public static List<String> reader(){

        String str = "";
        try {
            str = FileUtils.readFileToString(new File("password.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String userName = subString(str,"name","pwd");//get username
        String passwPrd = subString(str,"pwd","uid");//get password
        //get userid (user or admin)
        int indexOf2 = str.indexOf("uid");
        String userid = str.substring(indexOf2);
        String uid = userid.substring(3);
        List<String> list = new ArrayList<>();
        list.add(userName.trim());
        list.add(passwPrd.trim());
        list.add(uid.trim());
        return list;
    }
    /*
    Find the position of the specified 2 characters in the string
     */
    public static String subString(String str, String strStart, String strEnd){
        int strStartIndex = str.indexOf(strStart);
        int strSEndIndex = str.indexOf(strEnd);
        //index < 0, That means there is no such character in the string
        if (strStartIndex < 0){
            return "string :--->" + str + "<--- does not exist in" + strStart + ", Unable to intercept target string";
        }
        if (strSEndIndex < 0){
            return "string :--->" + str + "<--- does not exist in" + strEnd + ", Unable to intercept target string";
        }
        String result = str.substring(strStartIndex,strSEndIndex).substring(strStart.length());
        return result;
    }
    /*
    clean file used to logout
     */
    public static void clean(){
        File file = new File("password.txt");
        if (!file.exists()){
            System.out.println("file does not exist");
        }else {
            file.delete();
        }
    }

    public static void main(String[] args) {
        List<String> list = reader();
        System.out.println("UserName:" + list.get(0));
        System.out.println("password:" + list.get(1));
        System.out.println("Userid:" + list.get(2));
    }
}
