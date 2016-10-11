package com.study_doctor;

/**
 * Created by Doctor on 2016/10/10.
 */
public class Test1 {
    public static void main(String[] args){
        for (int i = 20; i > 0 ; i--) {
            int age = 10;
            age= age + 2*i;
            System.out.println("第 "+ i + " 个人的年纪为:" + (age-2));
        }
        System.out.println("第五个的年龄为:"+getAge(5));
    }
    static int getAge(int n){
        if (n==1){
            return 10;
        }
        return 2 + getAge(n-1);
    }

}
