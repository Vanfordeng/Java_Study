package com.study_java8;

/**
 * Created by Dcotor on 2016/10/10.
 * 使用static定义内部类
 */
class Outer1{  //外部类
    private static String mgs = "Hello wrold!!";

    //TODO
    static class Inner{ //内部类
        public void print(){
            System.out.println(mgs);
        }
    }
    public void fun(){
    }
}
public class Java_Basic_InnerClass_static {
    public static void main(String[] args){
        //外部类.内部类  对象 =  new 外部类（）.new 内部类（）；
        //给内部类加上static之后,仿佛就变成了一个独立的类（相当于一个外部内）
        //外部类.内部类  对象 =  new 外部类.内部类（）；
        Outer1.Inner in = new Outer1.Inner();
        in.print();
    }
}
