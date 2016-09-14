package com.study_mars.Practice_Mars;

import com.study_mars.Practice_Mars.logic.MainLopper;
import com.study_mars.Practice_Mars.ui.UserAdminUI;

import java.util.Properties;

/**
 * Created by Doctor on 2016/9/14.
 * 1.此小项目主要用于练习,具体主要实现功能如下：
 * *根据用户选择,做相应的操作
 * *对所有字符串放在配置文件中
 * *整体的设计模式,面向对象的思想练习
 */
public class Main {
    public static void main(String[] args){
        UserAdminUI userAdminUI = new UserAdminUI();
        userAdminUI.loadUi();

        MainLopper mainLopper = new MainLopper();
        mainLopper.loop();
    }
}
