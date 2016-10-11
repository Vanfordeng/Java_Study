package com.study_doctor;

/**
 * Created by Doctor on 2016/10/10.
 * 题目：求1+2!+3!+...+20!的和
 */
public class Factorial_161010 {
    public static void main(String [] args){
//        题目：利用递归方法求5!。
        System.out.println(factorial(10));

        //题目：求1+2!+3!+...+20!的和
        long sum = 0L;
        for (int i = 1; i <= 20 ; i++) {
            System.out.println(factorial(i));
            sum +=factorial(i);
        }
        System.out.println(sum);
    }

    //递归方法计算5!
    public static long factorial(int i){
        if (i >1){
            return i*factorial(i-1);
        }
        return 1;  //递归方法的返回值是会带入计算的.不能随意设定
    }
}
