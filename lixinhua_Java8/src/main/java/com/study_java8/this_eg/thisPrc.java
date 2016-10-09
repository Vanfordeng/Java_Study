package com.study_java8.this_eg;

/**
 * Created by Doctor on 2016/10/8.
 */
 class A {
    private B b;
    public A(){ //2.执行A类的构造
        //3.为B类对象b实例化
        this.b =  new B(this); //4.this就是temp要指向的A的对象
        this.b.get(); //7.调动B类的get()方法
    }
    public void print(){//10.调用print()输出
        System.out.println("Hello world");
    }
}
class B{
    private A a;
    public B(A a){ //5.参数a = temp;
        this.a = a; //6.保存a对象,（保存temp）
    }
    public void get(){ //8.调用此方法
        this.a.print(); //this.a = temp
    }
}
public class thisPrc{
    public static void main(String[] args){
        //1.实例化A类对象,要调用A类的无参构造函数
        A temp =  new A();
    }
}