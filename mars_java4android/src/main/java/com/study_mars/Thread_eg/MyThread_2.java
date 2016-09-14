package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class MyThread_2 implements Runnable{
    int i = 100;
    @Override
    public void run() {
//        int i = 100;
        while (true){
            //类名的调用的方法都是静态方法。如下获取当前线程的名称
            //卖火车票系统
            //线程同步错误...线程操作不同步
            //this为同步锁。A线程先执行的时候,就先占用this对象指针。当线线程A让出CPU的时候，线程A仍然持有线程锁
            //线程B拿到CPU后要执行代码块会先去获取同步锁。如果线程A的同步锁没有释放,线程B就无法运行。需要等到线程A将当前代码
            //流程执行完毕并释放同步锁后(单个代码块执行完毕会去释放同步锁),线程B才能获取this去执行同步的代码
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+"--->"+i);
                i --;
                Thread.yield();
                if (i < 0){
                    break;
                }
            }
        }
    }
}
