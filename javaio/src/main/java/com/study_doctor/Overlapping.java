package com.study_doctor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Doctor on 2016/9/20.
 */
public class Overlapping {
    /*
     * 题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
     */
    public static void main(String[] args) throws IOException {
        System.out.println("请输入要计算的数字：");
        String inputNumber = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println("请输入要计算的次数：");
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int number = Integer.parseInt(inputNumber);
        int length = Integer.parseInt(input);
        System.out.print("计算结果为：");
        System.out.println(count(length,number));
    }

    public static int count(int length, int number) {
        int[] temp = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            temp[i] = number;
            number = number*10+temp[0];
        }
        for (int i:temp) {
            sum +=i;
        }
        return sum;
    }
}

