package Thread;

/**
 * Created by Doctor on 2016/11/1.
 * 线程的同步产生原因
 * 实际上所谓的同步指的是多个线程访问同一资源时所需要考虑的问题。
 */
class Thread_Synchronized implements Runnable{
    private int ticket = 50;   //一共有5张票
    public synchronized void sale(){
        if (this.ticket > 0) {
            try {
                Thread.sleep(100); //加入延迟后出现了负数的情况,那么这就叫不同步的情况
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票,ticket:" + this.ticket--);
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 209 ; i++) {
            /**@或者直接调用同步方法*/
            this.sale();
            synchronized (this) {       //当前操作每次只允许一个对象进入,锁住的是当前调用此代码的对象
                if (this.ticket > 0) {
                    try {
                        /**卖票过程分为两步：1. if(this.ticket > 0) 判断是否还有票。有则进入if语句
                         *                   2. this.ticket-- 修改剩余的票数
                         * -----------------------------------------------------------------------------------------
                         * @当没有增加Thread.sleep(100)的时候，4个线程同时操作ticket。每次一个线程从判断到修改票数的时间间隔非常的短。所以不容易出现多个线程同时判断 if(this.ticket > 0)都成立的情况
                         * @但增加了Thread.sleep(100)的时候，但第一个线程判断if(this.ticket > 0)通过,休眠100ms.让其它线程执行,此时的ticket--还没执行.第二线程进入有判断if(this.ticket > 0)通过.
                         * 则造成了数据的错误（这属于异步操作,异常操作就会存在数据的安全隐患）
                         * @对于这种错误,需要使用同步来解决：在Java里面如果要实现线程的同步可以使用synchronized关键字,而这个关键字可以通过两种方式使用：
                         * -----------------------------------------------------------------------------------------
                         * @|--一种是同步代码块   （在Java里面有四种代码块,普通代码块，构造代码块，静态代码块，同步代码块）
                         *    synchronized (this) {
                         *       操作步骤
                         *  }
                         * @|--另一种是同步方法
                         *    public synchronized void sale(){
                            if (this.ticket > 0) {
                             try {
                                Thread.sleep(100); //加入延迟后出现了负数的情况,那么这就叫不同步的情况
                             } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                              System.out.println(Thread.currentThread().getName() + "卖票,ticket:" + this.ticket--);
                                }
                            }
                         */

                        Thread.sleep(100); //加入延迟后出现了负数的情况,那么这就叫（主要是各个线程的数据内容不同步）不同步的情况
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票,ticket:" + this.ticket--);
                }
            }
        }
    }
}
public class Java_Basic_Thread_Synchronized {
    public static void main(String[] args) {
        Thread_Synchronized ts = new Thread_Synchronized();
        new Thread(ts,"票贩子A").start();
        new Thread(ts,"票贩子B").start();
        new Thread(ts,"票贩子C").start();
        new Thread(ts,"票贩子D").start();
    }
    //同步操作与异步操作相比,异步操作的执行速度要高于同步速度，但是同步操作时数据的安全性较高，属于安全的线程操作。
}
