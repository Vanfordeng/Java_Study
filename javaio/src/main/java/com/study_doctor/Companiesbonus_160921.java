package com.study_doctor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Doctor on 2016/9/21.
 */
public class Companiesbonus_160921 {
    public static void main(String[] args) throws IOException {
        //公司红利
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        double profit = Double.parseDouble(input);
        System.out.println(bonus(profit));
    }

    public static double bonus(double profit){
        double b = 0.0;

        if (profit<=10){
            b = profit*0.1;
        }else if (profit <=20){
            b = 10*0.1+(profit-10)*0.075;
        }
        return b;
    }

}
