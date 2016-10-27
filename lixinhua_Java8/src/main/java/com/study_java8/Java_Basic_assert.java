package com.study_java8;

/**
 * Created by Doctor on 2016/10/26.
 * assert关键字是在JDK1.4的时候引入的，其主要的功能是进行断言
 * 在Java中的断言只的是程序执行到某行代码处时一定是预期的结果
 * Java2在1.4中新增了一个关键字：assert。在程序开发过程中使用它创建一个断言(assertion)，它的
    语法形式有如下所示的两种形式：
    1、assert condition;
    这里condition是一个必须为真(true)的表达式。如果表达式的结果为true，那么断言为真，并且无任何行动
    如果表达式为false，则断言失败，则会抛出一个AssertionError对象。这个AssertionError继承于Error对象，
    而Error继承于Throwable，Error是和Exception并列的一个错误对象，通常用于表达系统级运行错误。
    2、assert condition:expr;
    这里condition是和上面一样的，这个冒号后跟的是一个表达式，通常用于断言失败后的提示信息，说白了，它是一个传到AssertionError构造函数的值，如果断言失败，该值被转化为它对应的字符串，并显示出来。
 */
public class Java_Basic_assert {
    public static void main(String[] args){
        int num =10;
        //中间可能经过了10含代码来操作num的内容
        //期望中的内容应该是20
        //默认情况下断言是不应该影响程序运行的，也就说在java解释程序的时候，断言是默认不起作用的
        //要想让断言起作用：java -ea com.study_java8.Java_Basic_assert
        //    Exception in thread "main" java.lang.AssertionError: num的内容不是20
        //          at com.study_java8.Java_Basic_assert.main(Java_Basic_assert.java:16)
        /**
         * java.lang.Object
                |-java.lang.Throwable
                    |-java.lang.Error
                        |-java.lang.AssertionError
         */
        assert num == 20  : "num的内容不是20";
        assert num == 30;
        assert (num==100) : "num的内容不是100";
        System.out.println("num = " + num);
        //在Java里面断言的设计要比C++强得多,它不影响程序执行
    }
}
