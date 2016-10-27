package com.study_java8;

/**
 * Created by Doctor on 2016/10/27.
 * 泛型方法：
 * 泛型方法不一定非要定义在支持泛型的类里面，在之前所编写的所有存在有泛型的方法都是在泛型支持类里面定义
 *
 */
public class Java_NewFeather_Generics_Method {
    public static void main(String[] args) {
        System.out.println(fun(100));
        System.out.println(fun("Hello World!"));
        System.out.println(fun(new Java_NewFeather_Generics_Method()));
    }
    //泛型方法的定义：T的类型由传入的参数类型决定
    public static <T> T fun(T t){
//        T tt = t + t2 + t3;
        return t;
    }

    /**@泛型解决的是向下转型所带来的安全隐患,其核心的组成就是在声明类或接口的时候不设置参数或属性的类型
     * @“？”可以接收任意的泛型类型，只能够取出,但是不能够修改
     */
}
