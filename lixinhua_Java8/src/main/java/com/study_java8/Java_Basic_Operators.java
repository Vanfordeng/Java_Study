package com.study_java8;

/**
 * Created by Doctor on 2016/9/20.
 */
public class Java_Basic_Operators {
    public static void main(String[] args){
        //三目运算：是一种赋值运算的形式,执行三目的时候可以以一个布尔表达式的结果进行赋值
        //数据类型 变量 = 布尔表达式？慢速吃表达式时的内容：不满足吃表达式的内容
        //利用三目可以节约一些判断代码
        int numA  = 10;
        int numB = 20;
        int max = numA > numB ? numA:numB;
//        if (numA>numB){
//            max = numA;
//        }else {
//            max = numB;
//        }
        System.out.println(max);
        //短路运算符  &&　||
        if ((1==2)&&(10/0==0)){
            System.out.println("Hello world!");
        }

//        if ((1==2)&(10/0==0)){
//            System.out.println("Hello world!");
//        }
        //在之前所进行的数学计算都使用的是十进制，Java本身的运算符支持二进制，八进制，十六进制
        //十进制变为2进制：除2、取余、倒序
        int num1 = 9;
        int num2 = 11;
        System.out.println(num1 & num2);
        // 9的二进制：00000000 00000000 00000000 00001001
        // 11的二进制：00000000 00000000 00000000 00001011
        //结果：00000000 00000000 00000000 00001001
        int num3 = 2;
        int result = num3 << 2;
        //移位之后原始数据不改变
        System.out.println(result);
        //2的二进制：00000000 00000000 00000000 00000010
        //向左移位之后：00000000 00000000 00000000 00001000
        //面试题：请解释“&”和“&&”的区别：
        //逻辑运算为短路
        //位运算：位运算&和或运算|，但是&&和||不能用于位运算
    }
}
