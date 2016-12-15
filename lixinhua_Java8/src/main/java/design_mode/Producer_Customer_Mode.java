package design_mode;

/**
 * Created by Doctor on 2016/11/2.
 * 生产者-消费者模式
 *
 * 分析：
 * 数据错误产生的原因是因为：设置操作分为两步：1.判断  2.设置，如果没有进行同步包装，那么get的时候就可能产生数据错误
 * 数据才重复设置和重复获取产生的原因是：当Producer线程设置数据很慢时,当Consumer线程在获取数据就会多次抢占到系统资源执行。同样，当Consumer获取很慢时，Producer可能会重复的设置
 */

class Info{
    private String title;
    private String content;
    private boolean flag = true;

    public synchronized void set(String title,String content){
        if (this.flag == false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //不能加else语句,会导致如果flag=true的时候,也能抢占并执行
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.content = content;
        this.flag = false;
        super.notify();

    }

    public synchronized void get(){
        if (this.flag == true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.title + "--" + this.content);
        this.flag = true;
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
                this.info.set("邓博","是一个人");
            }else{
                this.info.set("冰箱","是一个家电");
            }
        }
    }
}
class Customer implements Runnable{
    private Info info;

    public Customer(Info info){
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++) {
            this.info.get();
        }
    }
}

public class Producer_Customer_Mode {
    public static void main(String[] args) {
        Info info = new Info();

        new Thread(new Producer(info)).start();
        new Thread(new Customer(info)).start();

    }
}
