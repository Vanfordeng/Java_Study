package com.study_doctor;

/**
 * Created by Doctor on 2016/9/18.
 */
public class Primenumber_160918 {
    //判断101-200总有多少个素数，素数：只能被1和自己整除
    public static void main(String[] args){
        prime(10,20);
    }
    public static void prime(int start, int end){
        for (int i = start; i <=end ; i++) {
            //每循环一次都给cache赋值为false.
            boolean cache = false;
            for (int j = 2; j < start-1 ; j++) {
                if (i%j==0){
                    //只要i%j==0,就会走这个流程将cache=true;
                    cache = true;
                }
            }
            if (!cache){
                System.out.println(i);
            }
        }
    }
}
