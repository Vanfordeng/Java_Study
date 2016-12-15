package Thread;

/**
 * Created by Doctor on 2016/10/31.
 *如果要想在Java之中实现多线程有两种途径：
 *   |-- 继承Thread类
 *   |-- 实现Runnable接口（Callable接口），Callable实现是为了又返回结果，其实是Runnable的扩充
 *   两者之间的区别：
 *   |-- public class Thread extends Object implements Runnable
 *   发现Thread类继承Object 居然还实现了Runnable接口：类似代理设计模式：有一点不对：如果是代理设计模式，客户端调用的代理类的方法也应该是接口里提供的方法，那么也应该是run()才对
 *   这主要是因为最早since JDK1.0 还没有设计模式的概念。
 *   除了以上的联系之外,还有一点：使用Runnable接口可以比Thread类能够更好的描述出数据共享的概念。此时的数据功能指的是多个线程访问同一资源的操作
 *   |-- @FunctionalInterface
 *        public interface Runnable
 */

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**@Thread*/
class MyThread2 extends Thread {
    private int ticket = 10;
    private String name;

    public MyThread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.ticket >= 0) {
                System.out.println("买票，ticket = " + this.ticket-- + " " + this.name);
            }
        }
    }
}
/**@Runnable*/
class MyThread3 implements Runnable {
    private int ticket = 10;
    private String name;

    public MyThread3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.ticket >= 0) {
                System.out.println("买票，ticket = " + this.ticket-- + " " + this.name);
            }
        }
    }
}

/**@Callable  since JDK 1.5/*/
//java.util.concurrent
//@FunctionalInterface
//public interface Callable<V>{public V call()throws Exception}
class MyThread4 implements Callable<String> {
    private int ticket = 10;
    private String name;
    public MyThread4(String name){
        this.name = name;
    }
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 100 ; i++) {
            if (this.ticket >0){
                System.out.println("买票，ticket = " + this.ticket-- + " " + this.name);
            }
        }
        return "票已经卖光";
    }
}


public class Java_Basic_Thread2 {
    public static void main(String[] args) {
//        System.out.println("---------------------------------------------");
        //由于MyThread2类里面有start()方法，所以每一个MyThread2类对象就是一个线程对象，可以直接启动
        MyThread2 m1 = new MyThread2("线程m1");
        MyThread2 m2 = new MyThread2("线程m2");
        MyThread2 m3 = new MyThread2("线程m3");
      //本程序声明了三个MyThread类对象，并且分别调用了上次start()方法。但是结果发现,三个线程各自在卖自己的10张票。
//        new Thread(m1).start();    //由于MyThread2继承自Thread,但是Thread也是Runnable接口的子类,所以也可以传入Thread构造函数中。但是更多的还是传入Runnable对象
//        new Thread(m1).start();
//        new Thread(m1).start();
//        m1.start();
//        m2.start();
//        m3.start();
        //Todo 还有一点：使用Runnable接口可以比Thread类能够更好的描述出数据共享的概念。此时的数据功能指的是多个线程访问同一资源的操作
//        System.out.println("---------------------------------------------");
//        MyThread3 my1 = new MyThread3("线程my1");
//        new Thread(my1).start();
//        new Thread(my1).start();
//        new Thread(my1).start();
        //请解释多线程两种实现方式的区别？
        /**Thread类是Runnable接口的子类,使用Runnable接口实现多线程可以避免单继承局限
         * Runnable接口实现的多线程,可以比Thread类实现的多线程能够更加清楚的描述数据共享
         */
        System.out.println("---------------------------------------------");
        //此时观察Thread类里面并没有发现直接支持接收Callable接口的多线程构造函数
        //从JDK 1.5开始提供有java.util.concurrent.FutureTask<V> 类，这个类主要是负责Callable接口对象操作的，这个接口的定义结构
        //public class FutureTask<V> extends Object implements RunnableFuture<V>，观察到它实现了一个RunnableFuture<V>,这个RunnableFuture<V>的定义结构：
        //public interface RunnableFuture<V> extends Runnable, Future<V>,观察到它继承了Runnable接口，还继承了Future<V>:定义结构：public interface Future<V>并包含一系列方法
        //在FutureTask类里面定义有如下构造方法：FutureTask(Callable<V> callable)
        MyThread4 myt1 = new MyThread4("线程myt1");
        MyThread4 myt2 = new MyThread4("线程myt1");
        FutureTask<String> task = new FutureTask<String>(myt1);  //目的是为了取得call()返回结果
        FutureTask<String> task1 = new FutureTask<String>(myt2);  //目的是为了取得call()返回结果
        //FutureTask是Runnable接口的子类,所以可以使用Thread类的构造来接收task对象
        new Thread(task).start();
        new Thread(task1).start();
        try {
            //多线程执行完毕后,可以取得内容,依靠FutureTask的父接口Future中的get()方法完成
            System.out.println(task.get());
            System.out.println(task1.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //最麻烦的问题在于需要接收返回值信息,并且又需要与原始的多线程的实现靠拢（Thread类靠拢）.
    }
}
