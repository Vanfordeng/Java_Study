package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class TestMyThread_2 {
    public static void main(String [] args){
        MyThread_2 myThread = new MyThread_2();
        //生成两个Thread对象,但是这个两个Thread对象共用同一个线程体
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        //每一个线程都有名字，可以通过Thread对象的setName设置线程名字，也可以
        //使用getName方法获取线程名字
        t1.setName("Thread t1");
        t2.setName("Thread t2");

        t1.start();
        t2.start();
    }
}
