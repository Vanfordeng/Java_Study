package com.study_java8;

/**
 * Created by Doctor on 2016/9/20.
 */
public class Java_Basic_Branch_loop {
    public static void main(String[] args){
        for(int i=0;i<args.length;i++)
            System.out.println(args[0]);

        //switch的判断不能够使用布尔表达式,它最早的时候只能够进行整数或者
        //字符,但是在JDK 1.5之后,支持了枚举。在JDK 1.7之后支持了String
        //在每一个Case里面出现的break语句,表示的是停止case的执行，因为switch语句默认是从满足条件的第一个
        //语句开始往下执行。下列输出：1,3和没有内容。如果加上bread,可跳出case执行
        int ch =1;
        switch (ch){
            case 2:
                System.out.println("输出了2");
            case 1:
                System.out.println("输出了1");
            case 3:
                System.out.println("输出了3");
            default:
                System.out.println("没有内容");
        }
        //switch不能够判读布尔表达式,它只能够判读内容。String 判读区分大小写
        int sum =0;
        for (int i = 0; i <=100 ; i++) {
            sum +=i;
        }
        System.out.println(sum);

        //while 先判读,后执行.do.. while 想执行,后判读.至少执行一次
        //do..while根本就不会用
        //for(循环初始化条件；循环判断,循环条件变更){循环语句}
        //*如果不知道循环次数，但是知道循环结束条件的时候使用while小循环
        //*如果明确知道循环次数,使用for循环
        //continue（退出本次循环，之后的代码不执行）break(退出整个循环)
    }
}
