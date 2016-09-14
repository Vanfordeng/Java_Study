package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
//线程运行就像寝室四个人抢一本小说

/**
 * 中断线程：
 * -Thread.sleep()  休眠一段时间，休眠结束，醒了之后进入就绪状态，需要去抢CPU
 * -Thread.yield()  线程运行到这段代码的时候,自动让出CPU。让出之后又会去抢CPU
 * -getPriority 获取优先级
 * -setPriority 设置优先级
 * 优先级越高的线程，执行的概率就越大。越大并不是一定就执行
 */
public class Test_1 {
    public static void main(String[] args){
        //------------------------------------Thread
        //生成线程类的对象
        FirstThreadJava_1 ft = new FirstThreadJava_1();
        //启动线程
        //运行有三个线程：1.是main线程，2.是ft线程，3.是垃圾回收线程
        ft.start(); //就绪状态
        //TODO:不同线程之间如何抢占CPU，没有规律.而且控制不了
        //多线程最大的特点是：没谱
        //ft.run(); 调用run方法不会新建线程,只是调用了ft对象的run方法而已.
        //------------------------------------Runnable
        RunnableImpl_1 ri = new RunnableImpl_1();
        //如下ri实际是向上转型为Runnable
        Thread t = new Thread(ri);
        int p = t.getPriority();
        System.out.println(p);
        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t.getPriority());
        t.start();

        for (int i = 0; i <10 ; i++) {
            System.out.println("Main"+i);
        }
    }
}
