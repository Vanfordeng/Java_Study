package com.study_mars.Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Doctor on 2016/9/7.
 */
public class UI {
//    RandomAccessFile
    public static void main(String[] args){
        DataValidation dataValidation = new DataValidation();
        BufferedReader br;
        String temp = "";
        System.out.println("Please input age:");
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            temp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataValidation.age = new Integer(temp);
    }
}
