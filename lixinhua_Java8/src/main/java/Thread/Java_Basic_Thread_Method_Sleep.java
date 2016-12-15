package Thread;

/**
 * Created by Doctor on 2016/11/1.
 * 线程休眠:所谓的线程休眠指的就是让线程的执行速度稍微变慢一点。休眠的方法：public static void sleep(long millis) throws InterruptedException（中断异常,如果打断了休眠，就会出现中断异常）
 * TODO:不同线程之间如何抢占CPU，没有规律.而且控制不了
 */
/**
 * 中断线程：
 * -Thread.sleep()  休眠一段时间，休眠结束，醒了之后进入就绪状态，需要去抢CPU
 * -Thread.yield()  线程运行到这段代码的时候,自动让出CPU。让出之后又会去抢CPU
 * -getPriority 获取优先级
 * -setPriority 设置优先级
 * 优先级越高的线程，执行的概率就越大。越大并不是一定就执行
 */
class Thread_Sleep implements Runnable{
    @Override
    public void run() {
        System.out.println(this);
        for (int i = 0; i < 10000 ; i++) {
            try {
                //休眠一段时间，休眠结束，醒了之后进入就绪状态，需要去抢CPU。所以说是1000ms = 1s ，其实运行时不是1s
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ".i：" + i);
        }
    }
}
public class Java_Basic_Thread_Method_sleep {
    public static void main(String[] args) {
        Thread_Sleep mt = new Thread_Sleep();
        //默认情况下,在休眠的时候如果设置了多个线程对象,那么所有的线程对象将一起进入到run()方法（所谓的一起进入实际上是因为先后顺序实在是太短了,但实际上有区别。就这点区别有可能造成数据操作的错误）
        new Thread(mt,"自己的线程对象A").start();
        new Thread(mt,"自己的线程对象B").start();
        new Thread(mt,"自己的线程对象C").start();
        new Thread(mt,"自己的线程对象D").start();
        new Thread(mt,"自己的线程对象E").start();
        //执行结果如下：
//        Thread.Thread_Sleep@6bc0cd44       //Thread_Sleep mt = new Thread_Sleep();
//        Thread.Thread_Sleep@6bc0cd44
//        Thread.Thread_Sleep@6bc0cd44
//        Thread.Thread_Sleep@6bc0cd44
//        Thread.Thread_Sleep@6bc0cd44
//        自己的线程对象B.i：0           //B
//        自己的线程对象A.i：0           //A
//        自己的线程对象E.i：0           //E
//        自己的线程对象D.i：0           //D
//        自己的线程对象C.i：0           //C
//        自己的线程对象B.i：1
//        自己的线程对象D.i：1
//        自己的线程对象C.i：1
//        自己的线程对象E.i：1
//        自己的线程对象A.i：1
//        ......
    }
}
