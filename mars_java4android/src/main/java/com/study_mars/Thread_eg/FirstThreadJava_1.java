package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 * 定义一个线程类,它继承Thread并重写其中的run()方法称为线程体
 * 由于Java只支持单继承,用这种方法定义的类不能再继承其他类
 */

public class FirstThreadJava_1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("FirstThreadJava_1"+i);
        }
        super.run();
    }
}
