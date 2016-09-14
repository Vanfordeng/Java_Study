package com.study_mars.Practice_Mars.validitycheck;

import com.study_mars.Practice_Mars.ui.UserAdminUI;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 * Created by Doctor on 2016/9/14.
 */
public class UserInputCheck {
    UserAdminUI userAdminUI;

    public UserInputCheck() {
        userAdminUI = new UserAdminUI();
    }

    public int getUserChooseID(String input){
        int i= 0;
        //以非数字的方式分割字符串并获取数字组成的数组
        if (input.length()>=1){
            String[] a = input.trim().split("[^\\d]");
            if (a.length==1){
                i = Integer.parseInt(a[0]);
                inputUserChooseIDCheck(String.valueOf(i));
            }else {
                userAdminUI.loadUi();
            }
        }else {
            userAdminUI.loadUi();
        }
        return i;
    }
    public void inputUserChooseIDCheck(String input){
        if (input.matches("[1-5]")){
            return;
        }else{
            userAdminUI.loadUi();
        }
    }
}
