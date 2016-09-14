package com.study_mars.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * Created by Doctor on 2016/9/7.
 */
public class User {
    public static void main(String[] args){
        WRData wrData = null;
        String input = "";
        System.out.println("Please input you info:");
        //读取用户输入信息：InputStreamReader接收一个InputStream参数
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        try {
            input = br.readLine();
            wrData =  new WRData(input);
            System.out.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (wrData.writeData()){
            System.out.println("write successfully");
        }
    }
}
