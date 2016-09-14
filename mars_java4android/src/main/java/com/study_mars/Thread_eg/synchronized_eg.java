package com.study_mars.Thread_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class Synchronized_eg {
    //同步方法锁住的就是this.调用这个函数的那个对象
    //同步代码块可以指定锁定的对象而同步方法锁定就是this
//    public synchronized void fun1(){
    public void fun1(){
        //synchronized(this)锁住的并不是后续{}大括号中的代码块,而是this对象.如果不同的方法中有两个以上的synchronized(this)，那么只要一个地方锁住了.其它的代码块均无法执行
        //如果其它代码块去除synchronized，该代码块可以执行。TODO：如果是锁住对象,为什么同一个对象上没有同步锁的代码可以执行？
        //一旦一个线程获得了一个对象的同步锁,那么这个对象上的所有其它的同步的代码。都是不能够被其它线程执行的。都需要等待同步锁被释放之后才能执行
        synchronized (this){
            try {
                Thread.sleep(3*1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Fun1");
        }
    }
    public void fun2(){

//        synchronized (this){
            System.out.println("Fun2");
//        }
    }
}
