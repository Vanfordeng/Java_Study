package com.study_java8;

/**
 * Created by Doctor on 2016/10/24.
 * 匿名内部类(必须要基于接口或者抽象类的应用)：因为在标准的开发中，一个.java文件中最好保持一个class.如果一个类的定义只会只用一次。那么定义一个
 * 单独的class文件就显得浪费，所以使用匿名内部类直接使用。
 */

interface Message{
    public void print();
}
//class MessageImpl implements Message{
//
//    @Override
//    public void print() {
//        System.out.println("Hello World");
//    }
//}

public class Java_Basic_Anonymous_inner_class {
    public static void main(String[] args){
        //使用匿名内部类的时候有一个前提：必须要基于接口或者抽象类的应用
        fun(new Message(){ //匿名内部类
            //方法中的内部类可以访问方法的参数和定义的变量，但是这种操作只是适合JDK1.8之后的版本
            //在JDK1.7以及之前的版本：有一个严格要求：方法中定义的内部类如果想要访问方法定义的参数和变量，那么参数或者变量前必须加上
            //“final”标志（但是这个并不是final原本的概率）
            @Override
            public void print() {
                System.out.println("Hello");
            }
        });
    }

    public static void fun(Message mgs){
        mgs.print();
    }
}
