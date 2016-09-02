package com.study_mars;

/**
 * Created by Administrator on 2016/9/2.
 */
public class Java_Basic_for {
    public static void main(String[] args){
        //打印100-200之间的素数
        for (int i = 100; i <=200 ; i++) {
            boolean b = false;
            for (int j = 2; j < i-1; j++) {
                int k = i % j;
                if (k == 0){
                    b = true;
                }
            }
            if (!b){
                System.out.println(i);
            }
        }
    }
}
