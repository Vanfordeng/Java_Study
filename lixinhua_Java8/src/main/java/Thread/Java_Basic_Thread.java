package Thread;

/**
 * Created by Doctor on 2016/10/31.
 * @线程的存在离不开进程。进程如果消失后线程一定会消失，反之如果线程小时了，进程未必会消失
 * 在同一个时间段上,会有多进程轮流去抢占资源,但是在某一个时间点上,只会有一个进程运行
 * 如果要想在Java之中实现多线程有两种途径：
 *   |-- 继承Thread类
 *   |-- 实现Runnable接口（Callable接口）
 */

//所有程序的气垫是main()方法，但是所有的线程也一定要有一个自己的起点,那么这个起点就是run()方法，也就是说在多线程的每个主体类
// 之中都必须覆写Thread类中说提供的run()方法。public void run()：这个方法没有返回值,那么也就表示了线程一旦开始就会一直执行,不能够有返回值
class MyThread extends Thread{  //这就是一个多线程的操作类
    private String name;

    MyThread(String name){
        this.name = name;
    }
    @Override
    public void run() {  //覆写run()方法,作为线程的主体操作方法
        for (int i = 0; i <200 ; i++) {
            System.out.println(this.name + "---->" + i);
        }
    }
}

/**@Runable接口
 * @FunctionalInterface      //函数式接口
 * public interface Runnable{
 *     public void run();
 * }
 */

//Todo 与继承Thread类相比,此时的MyThread类在结构上与之前是没有区别的,但是有一点是有严重区别的，如果此时继承了Thread类可以直接继承start()方法，但是
//Todo 如果实现的是Runnable接口，并没有start()方法被继承
class MyThread1 implements Runnable{  //这就是一个多线程的操作类
    private String name;

    MyThread1(String name){
        this.name = name;
    }
    @Override
    public void run() {  //覆写run()方法,作为线程的主体操作方法
        for (int i = 0; i <200 ; i++) {
            System.out.println(this.name + "---->" + i);
        }
    }
}


public class Java_Basic_Thread {
    public static void main(String[] args) {
        MyThread m1 = new MyThread("线程A");
        MyThread m2 = new MyThread("线程B");
        MyThread m3 = new MyThread("线程C");

        m1.run();  //调用run方法就和调用普通方法相同
        m2.run();
        m3.run();
        System.out.println("-----------------------------------------");
//        public synchronized void start() {
//
//            if (threadStatus != 0)
//                throw new IllegalThreadStateException();         //IllegalThreadStateException（RuntimeException:如果一个线程启动了不止一次,就会抛出此异常） - if the thread was already started.
//            group.add(this);
//
//            boolean started = false;
//            try {
//                start0();  Todo: start0(): private native void start0();
//                started = true;
//            } finally {
//                try {
//                    if (!started) {
//                        group.threadStartFailed(this);
//                    }
//                } catch (Throwable ignore) {
//                }
//            }
//        }
//
//Todo: 发现在start()方法里面要调用一个start0()方法,而且此方法的结构与抽象方法类似,唯一不同的是使用了native关键字声明
//Todo: 在Java的开发里面有一门技术为JNI（Java Native Interface）技术,这门技术的特点：是使用Java调用本机操作系统提供的函数。
//Todo: 但是这样的技术有一个缺点，不能够离开特定的操作系统。
//Todo: 如果想要线程能够执行，需要操作体统来进程资源分配,所以此操作严格来讲主要由JVM负责根据不同的操作系统而实现的。
//Todo: 即:为什么一定要用start方法来启动线程,使用Thread类的start()不仅仅要启动多线程的执行代码,还要去根据不同的操作系统进行资源的分配
//       private native void start0();
        m1.start();  //每一个线程交替执行
       // m1.start();  // Exception in thread "main" java.lang.IllegalThreadStateException
        m2.start();
        m3.start();
        System.out.println("-----------------------------------------");

        MyThread1 My1 = new MyThread1("线程A");
        MyThread1 My2 = new MyThread1("线程B");
        MyThread1 My3 = new MyThread1("线程C");
        //Todo:不管何种情况下,如果要想启动多线程一定依靠Thread类完成,只有Thread类里面有start()方法.
        new Thread(My1).start();
        new Thread(My2).start();
        new Thread(My3).start();
    }
}
