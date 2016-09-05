package com.study_mars.extentd_eg;

/**
 * Created by Doctor on 2016/9/5.
 */
public class Printer {
    public void open(){
        System.out.println("Open");
    }
    public void print(String s){
        System.out.println("Print"+s);
    }
    public void close(){
        System.out.println("close");
    }
}
