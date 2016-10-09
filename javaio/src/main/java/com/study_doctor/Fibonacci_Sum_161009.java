package com.study_doctor;

/**
 * Created by Doctor on 2016/10/9.
 * 题目：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 */
public class Fibonacci_Sum_161009 {
    public static void main(String[] args){
        double[] f1 = fibonacci_sum(1,2);
        double[] f2 = fibonacci_sum(2,3);
        double sum = 0.0;
        for (int i = 0; i < 20 ; i++) {
//            sum += (f2[i]/f1[i]);
            sum = sum  + (f2[i]/f1[i]);
            System.out.println(f2[i]);
            System.out.println(f1[i]);
            System.out.println(f2[i]/f1[i]);
        }
        System.out.println(sum);
    }

    public static double[] fibonacci_sum(double x,double y){
        double[] f1 = new double[20];
        for (int i = 2; i < 20 ; i++) {
            f1[0]=x;
            f1[1] =y;
            f1[i] = f1[i-1]+f1[i-2];
        }
        return f1;
    }

    public static void answer(){
        float fm = 1f;
        float fz = 1f;
        float temp;
        float sum = 0f;
        for (int i=0;i<20;i++){
            temp = fm;
            fm = fz;
            fz = fz + temp;
            sum += fz/fm;
            //System.out.println(sum);
        }
        System.out.println(sum);
    }
}
