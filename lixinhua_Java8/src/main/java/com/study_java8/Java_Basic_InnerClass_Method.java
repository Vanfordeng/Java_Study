package com.study_java8;

/**
 * Created by Doctor on 2016/10/10.
 * 在方法中定义内部类
 * 内部类可以在任意的位置上定义，包括：类，代码块，方法。其中方法中定义内部类是比较常见的形式
 */
class Outer2{
    private String mgs = "Hello World!";
    public void fun(final int num){ //方法参数
        final double score = 99.9;  //方法变量

        class Inner2{
            public void print(){
                //此时发现没有加入任何的修饰，方法中的内部类可以访问方法的参数和定义的变量，但是这种操作只是适合JDK1.8之后的版本
                //在JDK1.7以及之前的版本：有一个严格要求：方法中定义的内部类如果想要访问方法定义的参数和变量，那么参数或者变量前必须加上
                //“final”标志（但是这个并不是final原本的概率）
                System.out.println("属性:" + Outer2.this.mgs);
                System.out.println("方法参数:" + num);
                System.out.println("方法变量:" + score);
            }
        }
        new Inner2().print();
    }
}
public class Java_Basic_InnerClass_Method {
    public static void main(String[] args){
        Outer2 outer2 =  new Outer2();
        outer2.fun(100);
    }
}
