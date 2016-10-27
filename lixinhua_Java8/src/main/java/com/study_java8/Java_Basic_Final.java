package com.study_java8;

/**
 * Created by Doctor on 2016/10/17.
 */
//在Java之中final称为终结器
//使用final定义的变量就成为了常量。常量必须在定义的时候设置好内容
//特别介绍：全局常量：public static final 声明的就是全局常量
public class Java_Basic_Final {
    public static final String MGS = "Hello";
    public static void main(String[] args){
        System.out.println(MGS);
    }
}
