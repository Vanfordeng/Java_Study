package Thread;

/**
 * Created by Doctor on 2016/11/1.
 * 死锁：
 * 通过分析可以发现,所谓的同步指的就是一个线程对象等待另外一个线程对象执行完毕的操作形式.同步过多就有可能造成死锁。
 *发生死锁的四个必要条件：
 * 1.互斥条件：即某一个资源在一段时间内只能由一个进程占有，不能同时被两个或者两个以上的进程占有。
 * 2.不可抢占条件：进程所说的的资源在未使用完毕之前，资源申请者不能强行地从资源占有者手中夺取资源，只能由占有者进程自行释放
 * 3.占有且申请条件:进程至少已经占有一个资源,但是又申请新的资源；由于该资源已经被另外进程占有，此时该进程阻塞；但是它还在等待资源之时，仍然继续占有已经占有的资源
 * 4.循环等待条件。存在一个循环等待序列{P1，P2....Pn}.逐次抢占资源，形成闭环抢占
 */
class Thread_Dead implements Runnable{
    private int ticket = 50;
    @Override
    public void run() {
        for (int i = 0; i < 209 ; i++) {
            if (this.ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖票： " + this.ticket--);
            }
        }
    }
}
class A{
    public synchronized void say(B b){
        System.out.println("我说：把你的本给我，我给你笔，否则不给");
        b.get();
    }
    public synchronized void get(){
        System.out.println("我：得到了本，付出了笔，还是什么都干不了!");
    }
}
class B{
    public synchronized void say(A a){
        System.out.println("它说：把你的笔给我，我给你本，否则不给");
        a.get();
    }
    public synchronized void get(){
        System.out.println("它：得到了笔，付出了本，还是什么都干不了!");
    }
}
public class Java_Basic_Dead_Synchronized implements Runnable{
    private static A a = new A();
    private static B b =  new B();

    public static void main(String[] args) throws InterruptedException {
        new Java_Basic_Dead_Synchronized();
    }
    public Java_Basic_Dead_Synchronized() throws InterruptedException {
        new Thread(this,"线程A").start();  //这儿start后回去等待线程A抢占资源,有可能在抢占到a之前main线程的：b.say（a）就执行完毕了。
        Thread.sleep(10);
        b.say(a);  //main线程
    }
    @Override
    public void run() {   //
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.say(b);
    }


    /**分析：A 和 B 两个类中的方法say 和 get 均为 synchronized 方法。当A或者B的对象在不同的线程中使用同一个对象实例（被当前线程锁住，那么这个实例对象其它什么也干不了）去做调用时,就会发生死锁
     * 满足条件一：互斥性：A 的对象a 和 B的对象 b 的sya　和 get均为synchronized 方法。a 和 b 只能由一处占用（所以a 和 b 的实例化对象时资源，线程main 和 线程A 是两架马车）
     * 满足条件二：不可抢占条件：A 和 B不能强力抢占使用互相的实例对象
     * 满足条件三：占用且申请条件：线程main 和线程A  两个线程：main线程 调用b.say(a) 占用b对象,申请使用a对象去调用get方法。线程A 调用a.say(b)， 占用a对象,申请使用b对象去调用get方法
     * 满足条件四：根据条件三,可观察到线程main和线程A形成了进程循环等待条件
     * Todo 有两个线程“main"  和  “线程A"  */
    //死锁是程序开发之中由于某种逻辑上的错所造成的问题,并且不是简单的会出现的。死锁是一种不定的状态
    //多个线程访问同一资源时需要考虑到那些情况?有可能带来那些问题
    /* |- 多个线程访问统一资源时一定要处理好同步,可以使用同步代码块或者同步方法
     *      |——同步代码块：synchronized(锁定对象（一般是this）){代码}
     *      |——同步方法：public synchronized 返回值 方法名称（）{}
     *  但是过多的使用同步,有可能造成死锁
     */
}
