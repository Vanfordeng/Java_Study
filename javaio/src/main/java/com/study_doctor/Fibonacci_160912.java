package com.study_doctor;

/**
 * Created by Doctor on 2016/9/12.
 */
public class Fibonacci_160912 {
    public static void main(String[] args) {
//            int i=0;
//            int j=1;
//            while(true){
//                 int f = i+j;  //第三个数
////                 int h = j+f;  //第四个数
////                i=i+j;
//                j = j+f;
//                int m = j+f;
////                 int m = f+h;  //第五个数
//                System.out.println(m);
//            }
//        }
        int i = 0;
        for (i = 1; i <= 20; i++)
            System.out.println(f(i));
    }

    public static int f(int x) {
        if (x == 1 || x == 2)
            return 1;
        else
            return f(x - 1) + f(x - 2);
    }

}
