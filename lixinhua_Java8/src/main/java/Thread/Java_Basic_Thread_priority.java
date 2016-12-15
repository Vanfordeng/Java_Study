package Thread;

/**
 * Created by Doctor on 2016/11/1.
 * 设置优先级：优先级指的是越高的优先级,越有可能执行。
 * 设置优先级：public final void setPriority(int newPriority)
 * 获取优先级：public final int getPriority()
 * public static final int MAX_PRIORITY   10
 * public static final int MIN_PRIORITY   1
 * public static final int NORM_PRIORITY  5
 */
class Thread_Priority implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ".i " + i);
        }
    }
}
public class Java_Basic_Thread_priority {
    public static void main(String[] args) {
        Thread_Priority tp = new Thread_Priority();
        Thread t1 = new Thread(tp,"自己的线程对象A");
        Thread t2 = new Thread(tp,"自己的线程对象B");
        Thread t3 = new Thread(tp,"自己的线程对象C");
        t3.setPriority(Thread.MAX_PRIORITY);
        //主线程优先级是5，public static final int NORM_PRIORITY
        System.out.println(Thread.currentThread().getPriority());
        t1.start();
        t2.start();
        t3.start();
    }
}
