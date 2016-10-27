package com.study_java8;

import java.io.Serializable;

/**
 * Created by Doctor on 2016/10/27.
 * 枚举:严格来讲枚举并不是一个新的功能,在Java虽然使用enum关键字定义了枚举，但是enum定义的枚举就相当于一个类继承了Enum类而已。
 * 主要作用是用于吸引C/C++开发人员,因为C/C++里面有定义枚举
 * 枚举：属于高级的多例设计模式应用
 */
class Color{  //多例模式
    private String title;

    public static final Color RED =  new Color("红色");
    public static final Color GREEN  =  new Color("绿色");
    public static final Color BLUE  =  new Color("蓝色");

    private Color(String title){
        this.title = title;
    }
    public static Color getInstance(String color){
        switch (color){
            case "red":
                return RED;
            case "green":
                return GREEN;
            case "blue":
                return BLUE;
            default:
                return null;
        }
    }
    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }
    public String toString(){
        return "颜色：" + this.title;
    }
}

//可以发现使用枚举之后可以完全简化的替代多例设计模式
//public abstract class Enum<E extends Enum<E>> extends Object implements Comparable<E>, Serializable {}
enum Color_Enum{ //定义好了枚举类
    RED,GREEN,BLUE;  //RED,GREEN,BLUE表示Color_Enum的实例化对象,并且这些对象必须写在枚举定义的第一行
}
enum Color_Enum1{ //定义好了枚举类
    红色,蓝色,绿色;
}
public class Java_NewFeather_Enum {
    public static void main(String[] args) {
        Color c1 = Color.getInstance("red");
        System.out.println(c1);
        /**@枚举严格意义来讲各个语言都支持(除了2005年之前的Java),也就是说在2005年之前，要是想定义枚举都会采用如上的形式代码（多例设计模式）完成
         */
        System.out.println(Color_Enum.BLUE);
        System.out.println(Color_Enum1.红色);
        //严格来讲枚举并不是一个新的功能,在Java虽然使用enum关键字定义了枚举，但是enum定义的枚举就相当于一个类继承了Enum类而已。
        //public abstract class Enum<E extends Enum<E>> extends Object implements Comparable<E>, Serializable {}
        //Enum是一个抽象类，里面定义的构造如下：protected  Enum(String name, int ordinal)依然是被封装了，也属于构造方法私有化的应用范畴。所有的多例
        //模式前提是构造方法私有化
        /**@在Enum类里面定义了两个方法：
         * 1.取得枚举的索引：public final int ordinal()
         * 2.取得枚举的名字：public final String name()
         *除了以上支持的方法之外,使用enum关键字定义的枚举类里面还有一个values()方法,这个方法将枚举以对象数组的形式全部返回
         */
        System.out.println("---------------------------------------------------------------------------------");
        Color_Enum.values();
        for (Color_Enum c: Color_Enum.values()) {
            //使用enum关键字定义的Color_Enum的内容对象可以直接使用Enum类的ordinal()和name()方法,证明有继承关系,ordinal这个索引是按照定义的顺序自动生成的。
            System.out.println(c.ordinal() + ":" + c.name());
        }
        System.out.println("---------------------------------------------------------------------------------");
        /*
         * enum是一个关键字,而Enum是一个抽象类
         * 使用enum定义的枚举就相当于一个类继承了Enum这个抽象类
         */
    }
}
