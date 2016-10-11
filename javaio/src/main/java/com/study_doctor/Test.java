package com.study_doctor;

/**
 * Created by Doctor on 2016/9/27.
 */
public class Test {
    static long sum = 0;
    static long fac = 0;

    public static void main(String[] args){
//            float fm = 1f;
//            float fz = 1f;
//            float temp;
//            float sum = 0f;
//            for (int i=0;i<20;i++){
//                temp = fm;
//                fm = fz;
//                fz = fz + temp;
//                sum += fz/fm;
//                //System.out.println(sum);
//            }
//            System.out.println(sum);


        long sum = 0;
        long fac = 1;
        for(int i=1; i<=10; i++) {
            fac = fac * i;
            sum += fac;
        }
        System.out.println(sum);
    }
}
