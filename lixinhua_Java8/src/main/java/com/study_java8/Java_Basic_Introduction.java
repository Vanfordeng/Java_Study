package com.study_java8;

public class Java_Basic_Introduction {
    //主方法：所有程序都是由主方法开始执行

    public static void main(String[] args){
        /*计算机高级编程语言类型：
         *  编译型
         *  解释型
         *  Java 是两种语言结合：
         *  Javac.exe    .class 字节码文件
         *  java.exe     JRE（JAVA RUNTIME ENVIRONMENT） 值的是Java 运行时解释器
         *
         */
        System.out.println("Hello world!");
        /*
         * public class 类名称{}：文件名称必须与类名称保持一致,一个*.java文件里面只能有一个public class
         * class 类名称{}：文件名称可以与类名称不一致，但是身材的*。class是根据定义的类名称生成的。
         * CLASSPATH:主要用于类的加载路径,
         * 当Java命令运行的时候时间是JVM会自动的找到CLASSPATH熟悉，而后找到此属性对应的内容，
         * 通过指定内容设置的路径来加载说需要的类。
        /*
         * PATH: 是属于操作系统属性，定义所有可执行程序的路径；
         * CLASSPATH: 是Java 程序解释类文件时所使用的加载路径。
         */
    }
}
