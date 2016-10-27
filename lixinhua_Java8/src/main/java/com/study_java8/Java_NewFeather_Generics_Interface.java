package com.study_java8;

import java.awt.image.ImageConsumer;

/**
 * Created by Doctor on 2016/10/27.
 * 泛型接口：
 */
//如果是解耦前面加上I,例如：IMessage
    //如果是抽象类在前面加上Abstract:AbstractMessage
interface IMessage<T>{ //设置泛型接口
    public void print(T t);
}
//在泛型接口上实现子类有两种形式：
//形式一：在子类上继续使用泛型
//子类也继续使用泛型,并且子类和父接口使用同样的泛型标记
class MessageImpl<T> implements IMessage<T>{
    @Override
    public void print(T t) {
        System.out.println(t);
    }
}

//形式二：在子类上不使用泛型，给父接口设置具体的泛型类型（GOOD）
class MessageImpl1 implements IMessage<String>{
    @Override
    public void print(String s) {
        System.out.println(s);
    }
}

public class Java_NewFeather_Generics_Interface {
    public static void main(String[] args) {
        IMessage<String> m = new MessageImpl<String>();
        m.print("Hello World");

    }
}
