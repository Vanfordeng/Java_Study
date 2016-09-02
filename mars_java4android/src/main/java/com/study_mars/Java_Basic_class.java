package com.study_mars;

/**
 * Created by Doctor on 2016/9/2.
 */
//把握住一个原则：把对同一事物进行操作的方法和相关的方法放在同一个类中，把方法和它操作的数据放在同一个类中。
// 1.首先确定谁来做，其次确定怎么做
// 2.首先考虑整体，其次考虑局部
// 3.首先考虑抽象，其次考虑具体
//  只定义程序中需要的类方法和属性
//    Tips:默认构造函数就像最低生活保障！
//    Tips:this就像生活中的代词：我。默认非静态成员变量都是由this.成员变量引用。只是隐藏了this
//    Tips:this可用于同名的类成员变量和构造函数形参
//    Tips:this(string,name)【必须位于构造函数第一条语句】;调用本类形式参数为string,name的构造函数,
//    ----------------------------------------------
//    分析方式:!--1.以面向对象方式分析 !--2.以面向计算机内存实现方式分析
//    Tips:super关键字用于解决父类构造函数的函数体赋值语句在子类中的重复问题
//    Tips:this 和super 非常类似：this(参数一,参数二....)、super(参数一,参数二....)  this.方法()/super.方法()

public class Java_Basic_class {
    public static void main(String []args){
        //如下代码有错：错误为：在静态方法main中new A()实际为this.new A().因为A为类Java_Basic_class的成员类。但是静态方法是在类加载的时候初始化的，
        // 而此时实际是没有Java_Basic_class对象。所以需要先实例化Java_Basic_class类
//        A a1 = new A();
        A a = new Java_Basic_class().new A();
        System.out.println("a:"+ a);
        System.out.println("A:"+ new Java_Basic_class().new A());
    }
    public class A{
        public void B(){
            int a =100;
            System.out.println(a);
        }
        int age = 0;
    }
}