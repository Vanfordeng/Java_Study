package Thread;

/**
 * Created by Doctor on 2016/11/1.
 * 多线程中的方法:大部分的方法都是在Thread类里面定义
 * 线程的命名与取得：线程程序的执行,每一次都是不同的运行结果.它会根据操作系统的情况进行资源的抢占。为了区分每一个线程,就必须依靠线程的名字（编号）
 */
class Thread_Method implements Runnable{
    @Override
    public void run() {
        //public Thread(Runnable target, String name)
        //public static native Thread currentThread();
        //public final String getName()
        //public final synchronized void setName(String name)
        //这些方法都是属于Thread类里面,可是如果换回到线程类（Runnable）子类,这个类里面并没有继承Thread类,所有如果要想取得线程名字
        //那么我们能够取得的就是当前执行本方法的线程名字
        System.out.println(Thread.currentThread().getName());
    }
}
public class Java_Basic_Thread_Method_getName {
    //原来主方法就是一个线程（main线程），那么所有在主方法上创建的线程实际上都可以将其表示为子线程。main线程上创建了各个子线程
    //通过以上的代码可以发现,线程实际上一直都存在（主方法就是主线程），可是进程去那里了呢？（Todo 只有进程才可以创建线程）
    //每当使用java命令去解释一个程序类的时候,对于操作系统而言,都相当于启动了一个新的进程(),而main只是这新进程中的一个子线程而已。
    //Todo 每一个JVM 进程启动的时候至少启动几个线程？
     //  |-- main线程：程序的主要执行，以及启动子线程；
    //   |--gc线程：负责垃圾收集
    public static void main(String[] args) {
        Thread_Method tm = new Thread_Method();
        Thread_Method tm1 = new Thread_Method();
        Thread_Method tm2 = new Thread_Method();
        new Thread(tm,"线程1").start(); //Thread-0  会自动命名
        new Thread(tm1).start();
        tm.run(); //直接调用run方法：会在main线程中运行
        new Thread(tm2,"线程2").start();
    }
}
