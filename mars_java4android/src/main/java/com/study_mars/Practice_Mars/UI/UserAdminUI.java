package com.study_mars.Practice_Mars.ui;

import com.study_mars.Practice_Mars.logic.MainLopper;
import com.study_mars.Practice_Mars.model.User;
import com.study_mars.Practice_Mars.io.IOUtils;

import java.util.Properties;

/**
 * Created by Doctor on 2016/9/8.
 */
//该类用于定义整个应用程序的UI系统
public class UserAdminUI {
    private static Properties properties = null;
    MainLopper mainLopper = null;
    static {
        properties = IOUtils.loadProperties("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\Practice_Mars\\resources\\res.properties");
    }
    public void loadUi(){
        System.out.println(getHelpInfo("welcome"));
    }
    public String getHelpInfo(String key){
        String helpInfo = (String) properties.get(key);
        return helpInfo;
    }

    public void tipsForUser(int input){
        mainLopper = new MainLopper();
        switch (input){
            case 1:
                System.out.println(getHelpInfo("add_user_help"));
                break;
            case 2:
                System.out.println(getHelpInfo("delete_user_help"));
                break;
            case 3:
                System.out.println(getHelpInfo("update_user_help"));
                break;
            case 4:
                System.out.println(getHelpInfo("query_user_help"));
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
    public void displayUserInfo(User user){
        System.out.println("id:" + user.getId() + "\tname:" + user.getName() + "\tage:" +user.getAge() + "\tGender:"+user.getGender() + "\tSalary:" + user.getSalary());
    }
}
