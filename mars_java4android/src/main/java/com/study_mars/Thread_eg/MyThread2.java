package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class        MyThread2 implements Runnable{
    private Synchronized_eg synchronized_eg;
    public MyThread2(Synchronized_eg synchronized_eg){
        this.synchronized_eg = synchronized_eg;
    }
    @Override
    public void run() {
        synchronized_eg.fun2();
    }
}
