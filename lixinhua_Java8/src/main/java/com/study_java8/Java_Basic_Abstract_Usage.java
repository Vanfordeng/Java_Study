package com.study_java8;

/**
 * Created by Doctor on 2016/10/18.
 * 模板设计模式：
 * 这些不同的类型最终都在行为上成功的进行了抽象，即：如果要想使用行为操作，那么就必须按照Action类的标准来实现子类（就像填写表格）
 */
//写父类不要去考虑子类,定义的是一个行为类
abstract class Act{  //行为类
    //定义为1,5,7是防止EAT+SLEEP就变为WORK了
    public static final int EAT = 1;
    public static final int SLEEP = 5;
    public static final int WORK = 7;

    public void command(int flag){
        //switch只支持数值判断,if支持条件判断
        switch (flag){
            case EAT:
                this.eat();
                break;
            case SLEEP:
                this.sleep();
                break;
            case WORK:
                this.work();
                break;
            case EAT+SLEEP:
                this.eat();
                this.sleep();
                break;
        }
    }

    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
}
//* 这些不同的类型最终都在行为上成功的进行了抽象，即：如果要想使用行为操作，那么就必须按照Action类的标准来实现子类（就像填写表格）
class Robot extends Act{  //机器人类继承行为类

    @Override
    public void eat() {
        System.out.println("机器人补充能量");
    }

    @Override
    public void sleep() {}

    @Override
    public void work() {
        System.out.println("机器人正在工作");
    }
}
//* 这些不同的类型最终都在行为上成功的进行了抽象，即：如果要想使用行为操作，那么就必须按照Action类的标准来实现子类（就像填写表格）
class Human extends Act{//人类继承行为类

    @Override
    public void eat() {
        System.out.println("人类正在吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("人类在休息");
    }

    @Override
    public void work() {
        System.out.println("人类在为了梦想工作");
    }
}
//* 这些不同的类型最终都在行为上成功的进行了抽象，即：如果要想使用行为操作，那么就必须按照Action类的标准来实现子类（就像填写表格）
class Pig extends Act{ //猪继承行为类

    @Override
    public void eat() {
        System.out.println("猪在吃食");
    }

    @Override
    public void sleep() {
        System.out.println("猪在睡觉养膘");
    }

    @Override
    public void work() {}
}
public class Java_Basic_Abstract_Usage {
    public static void main(String[] args){
        fun(new Robot());
        fun(new Human());
        fun(new Pig());
    }
    //使用向上转型统一fun方法的参数
    public static void fun(Act act){
        act.eat();
        act.sleep();
        act.work();
    }
}
