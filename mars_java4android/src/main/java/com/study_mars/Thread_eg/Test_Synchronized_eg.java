package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class Test_Synchronized_eg {
    public static void main(String[] args){
        Synchronized_eg synchronized_eg =  new Synchronized_eg();

        Thread t1 =  new Thread(new MyThread1(synchronized_eg));
        Thread t2 =  new Thread(new MyThread2(synchronized_eg));

        t1.start();
        t2.start();
    }
}
