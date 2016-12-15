package com.study_java8;

/**
 * Created by Doctor on 2016/10/31.
 * Lambda属于函数式编程的概念
 * 如果要想清楚函数式编程的产生目的,那么必须通过匿名内部类来分析
 * @利用Lambda表达式最终解决的问题:避免了匿名内部类定义过多无用的操作
 */
interface IM{
//    public void fun();
//    public void fun1(String str);
    public int add(int x,int y);
}
public class Java_NewFeather8_Lambda {
    public static void main(String[] args) {
//     get(new IM() {             //匿名内部类：
//         @Override
//         public void fun() {
//             System.out.println("Hello World!");
//         }
//     });
//        get(() -> System.out.println("Hello World！"));  //Lambda表达式
        //首先要定义此表达式里面需要接收的变量,单行语句直接进行输出
        //(参数)对应接口或抽象类的方法  -> 方法实现
//        get1((s) -> System.out.println(s));  //Lambda表达式
        // Lambda表达式多行实现方法
//        get1((s) -> {
//            s = s.toUpperCase();  //转大写
//            System.out.println(s);
//        });  //Lambda表达式

        //如果现在只是一个表达式，那么进行操作的返回,还是不写return比较合适，如果是多行的可以写上return
        get2((s1,s2) -> s1+s2);
        get2((s1,s2) -> {return s1+s2;});

        //对于Lambda语法有三种形式：
        /*
         *(参数) -> 单行语句；
         *(参数) -> {单行语句}；
         *(参数) -> 表达式
         */

    }
    public static void get(IM mgs){
//        mgs.fun();
    }
    public static void get1(IM mgs){
//        mgs.fun1("Hello World!");
    }
    public static void get2(IM mgs){
        System.out.println(mgs.add(10,20));
    }
}
