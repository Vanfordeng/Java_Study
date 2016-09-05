package com.study_mars.Exception_eg;

/**
 * Created by Doctor on 2016/9/5.
 */
public class Test {
    public static void main(String[] args){
        User user = new User();
        try {
            user.setAge(-20);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(e);
        }
    }
}
