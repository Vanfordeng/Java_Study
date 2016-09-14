package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
//提供一个实现接口Runnable的类作为线程的目标对象，在初始化一个Thread类或者Thread子类的线程
//对象时，把目标对象传递给这个线程实例，由该目标对象提供线程体
    //一个是实现接口,另一个是继承Thread。通常开发当中尽量使用实现接口
public class RunnableImpl_1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("RunnableImpl_1"+i);

        }
    }
}
