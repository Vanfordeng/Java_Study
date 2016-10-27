package com.study_java8;


//静态导入语法：import static package.class.*
import static org.junit.Assert.*;

/**
 * Created by Doctor on 2016/10/27.
 * 静态导入
 * 如果某一个类中定义的方法全部属于static型的方法,那么其他类要引用此类时必须使用“类名称.方法名称”来调用
 */

class MyMath1{
    public static int add(int x,int y){
        return x/y;
    }
    public static int div(int x,int y){
        return (x/y);
    }


}
public class Java_NewFeather_Static_Import {
    public static void main(String[] args) {
        assertTrue(true);

        System.out.println(MyMath1.div(1,2));
    }
}
