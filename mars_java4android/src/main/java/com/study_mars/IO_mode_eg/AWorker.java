package com.study_mars.IO_mode_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class AWorker implements Worker{

    //1.首先创建一个Worker的引用
    private Worker worker;
    //2.创建A公司工人的构造函数.将水管工/木匠工实例以参数传入构造函数
    public AWorker(Worker worker){
        //将参数实例的水管工/木匠工向上转型为this.worker的类型
        this.worker = worker;
    }
    @Override
    public void doSomeWork() {
        //doSomeWork中如下写入所有工人都会进说“你好”的问候语
        /**
         * 装饰者模式：
         * Worker为装饰者：给被装饰者carpenter/plumber加上了一些功能：如说：hello
         * 装饰者更加抽象,被装饰者才是实际执行任务的类。而且需要作为参数传递给装饰者
         */
        System.out.println("Hello");
        //再使用多态使用worker.其实是this.worker来doSom eWork
        worker.doSomeWork();
    }
}
