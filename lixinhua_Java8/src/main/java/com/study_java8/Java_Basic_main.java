package com.study_java8;

/**
 * Created by Doctor on 2016/10/9.
 */
public class Java_Basic_main {
    public static void main(String[] args){
        /*
         * public:  主方法是程序的开始,所以这个方法对任何的操作都一定是可见的就必须使用public(公共)
         * static:  证明此方法是由类名称调用的：java Java_Basic_main  执行的Java的类,main方法被类调用
         * void:    主方法是一切的执行的开始点，既然是所有的开头，那么就不能够回头（不能够使用return之类的关键字），执行完毕为止。
         * main:    是一个系统规定好的方法名称,不能够修改
         * String[] args:   值的是程序运行的时候传递的参数；"java Java_Basic_main 参数 参数 参数 参数“ 每个参数之间用空格隔开
         * 如果参数中本身就有空格,使用双引号隔开：java Java_Basic_main "参  数"  "参 数“
         */
        for (int i = 0; i < args.length ; i++) {
            System.out.println(args[i]);
        }
    }
}
