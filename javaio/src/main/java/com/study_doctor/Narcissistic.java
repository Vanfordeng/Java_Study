package com.study_doctor;

/**
 * Created by Doctor on 2016/9/19.
 */
public class Narcissistic {
    /*打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。例如：
     153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。*/
    public static void main(String[] args){
        narcissistic(100,999);
    }
    public static void narcissistic(int start,int end){
        for (int i = start; i <= end; i++) {
            //主要难点在于将个位，十位，百位拆分开来。
            int b= i/100;
            int s = (i/10)%10;
            int g= i%10;
//            if (i == (Math.pow(b,3)+Math.pow(s,3)+Math.pow(g,3))){
//                System.out.println(i);
//            }
            if (i == b*b*b+s*s*s+g*g*g){
                System.out.println(i);
            }
        }
    }
}
