package com.study_java8;

/**
 * Created by Docotr on 2016/10/20.
 * 所有的代码如果要进行开发，一定要首先开发出USB接口标准，因为有了标准后，电脑才可以去使用这些标准
 * 设备厂商才可以设计USB设备
 */
//标准可以连接不同层的操作类
interface USB{ //定义标准一定就是接口
    public void start();
    public void stop();
}
class Computer{
    public void plugin(USB usb){
        usb.start();
        usb.stop();
    }
}
class Flash implements USB{

    @Override
    public void start() {
        System.out.println("U盘开始使用");
    }

    @Override
    public void stop() {
        System.out.println("U盘停止使用");
    }
}
class Print implements USB{

    @Override
    public void start() {
        System.out.println("打印机开始使用");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止使用");
    }
}
public class Java_Basic_Interface_Usage {
    public static void main(String[] args){
        Computer computer =  new Computer();
        computer.plugin(new Flash());
        computer.plugin(new Print());

        Flash f = new Flash();
        //接口也可以使用instanceof来判断
        System.out.println(f instanceof USB);
    }
    //在现实生活之中，标准的概念随处可见，而在程序里面标准就是用接口来定义的
}
