package Thread;

/**
 * Created by Doctor on 2016/11/2.
 * 生产者--消费者模型
 */
class Info{
    private String title;
    private String content;
    private boolean flag = true;
    //flag = true:表示可以生产,但是不可以取走
    //flag =  false:表示可以取走,但是不可以生产

//    public void setTitle(String title) {
//        this.title = title;
//    }
//    public String getTitle() {
//        return title;                                todo 同步代码块需要把需要同步的代码打包在一起并且使用synchronized关键字锁住
//    }
//    public void setContent(String content) {
//        this.content = content;
//    }
//    public String getContent() {
//        return content;
//    }

    public synchronized void set(String title,String content){
        //重复进入到了set()方法里面,发现不能够生产，所以要等待
        if (this.flag ==  false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.content = content;
        this.flag = false;  //生产完成后,需要修改生产标记
        super.notify();  //唤醒其它等待线程
    }
    public synchronized void get(){
        if (this.flag == true){   //还没生产呢
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.title + "-" + this.content);
        this.flag = true;    //
        super.notify();
    }
}

class Producer implements Runnable{
    private Info info;

    public Producer(Info info){
        this.info = info;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            if (i%2 == 0){
                this.info.set("李白","好学生一个");
            }else {
                this.info.set("恐龙","凶残动物");
            }
        }
    }
}

class Consumer implements Runnable{
    private Info info;

    public  Consumer(Info info){
        this.info = info;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            this.info.get();
        }
    }
}

/**
 * 分析：
 * 数据错误产生的原因是因为：设置操作分为两步：1.判断  2.设置，如果没有进行同步包装，那么get的时候就可能产生数据错误
 * 数据才重复设置和重复获取产生的原因是：当Producer线程设置数据很慢时,当Consumer线程在获取数据就会多次抢占到系统资源执行。同样，当Consumer获取很慢时，Producer可能会重复的设置
 */

public class Java_Basic_Thread_Mode {
    public static void main(String[] args) throws InterruptedException {
        Info info = new Info();
        //数据错位           ：使用同步解决
        //数据重复设置，重复取出 : 必须加入等待与唤醒机制，在Object类里面提供有专门的方法
        //等待：public final void wait()throws InterruptedException
        //唤醒第一个等待线程：public final void notify()
        //唤醒全部等待线程：那个优先级高就先执行(优先级这个东西不一定，只是说有可能)：public final void notifyAll()
        //
        new Thread(new Producer(info)).start();
        new Thread(new Consumer(info)).start();
    }
    //Todo:面试题：请解释sleep()与wait()的区别？
    //sleep()是Thread类定义的方法,wait()是Object类定义的方法；
    //sleep()可以设置休眠时间,时间一到自动唤醒,而wait()需要等待notify()被其它线程进行唤醒。
}
