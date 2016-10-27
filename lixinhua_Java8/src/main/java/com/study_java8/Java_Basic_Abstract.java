package com.study_java8;

/**
 * Created by Doctor on 2016/10/18.
 */
//所有普通方法都会有一个“{}”，这个表示方法体。有方法体的方法一定可以被使用

    /*
     *抽象类必须有子类，即：每一个抽象类一定要背子类所继承
     * 抽象类的子类（子类不是抽象类）必须要覆写抽象类之中的全部抽象方法
     * 抽象类的对象实例化需要依靠子类完成，采用向上转型的方式处理。
     */
abstract class Q{ //定义一个抽象类
    public Q(){  //3.执行Q的构造方法
        this.print(); //4.执行this.print();
    }
    public void fun(){
        System.out.println("Q 这是Q的fun()");
    }
    public abstract void print();

    //abstract不能与static同时使用(但是在内部类的上可以同时使用)，但是抽象类中可以拥有static方法
    public static void print1(){
        System.out.println("这是抽象类Q中的static方法print1");
    }

    //abstract不能与static同时使用(但是在内部类的上可以同时使用)
    static abstract class QQ{
         abstract public void print();
    }

    //内部抽象类子类,
    private static class QQQ extends Q{
        @Override
        public void print() {  //覆写抽象类的方法
            System.out.println("这是内部抽象类子类继承的父类的print()方法，作用用于隐藏子类");
        }
    }

    //用于隐藏不关心的子类，而实现了方法
    public static Q getInstance(){
        return new QQQ();
    }

}
//一个子类只嗯呢继承一个抽象类
class W extends Q{ //W为普通方法
    //有强制才会有标准
    private int num = 100;
    public W(){}
    public W(int num){  //2.执行Q的构造方法
        this.num = num;
    }
    @Override
    public void print() { //5.执行print();
        //在任何一个类的构造执行完之前，所有属性的内容都是起对应数据类型的默认值，而子类构造执行之前一定先执行父类构造
        //所有属性设置的内容都是在构造完成之后才会被设置上去
        System.out.println("这是被W覆写的Q的print方法" + "num= " + num); //5.num还没初始化，为其数据类型的默认值
    }
}
class M extends Q.QQ{

    @Override
    public void print() {
        System.out.println("这是被M覆写Q.QQ的print方法");
    }
}
public  class  Java_Basic_Abstract {
    public static void main(String[] args){
        //不能实例化，一个类的对象实例化之后，就意味着这个对象可以知道用类中的属性和方法，但是抽象类中存在有抽象方法（不能调用）
//        Q q = new Q();
        Q q = new W();
        q.print();
        System.out.println("----------");
        Q.QQ qq=  new M();
        qq.print();
        System.out.println("----------");
        Q.print1();
        System.out.println("----------");
        //为用于隐藏不需要知道的子类
        Q.getInstance().print();
        System.out.println("----------");
        new W(30);//执行属性见1：执行W的构造方法,2，3,4,5

    }
    //抽象类继承子类里面会有明确的方法覆盖要求，而普通了并没有
    //普通类对象可以直接实例化，但是抽象类的对象必须经过向上转型后才可以得到抽象类实例化对象

    /*抽象类的相关限制：
     * 1. 抽象类里面由于会存在一些属性，那么在抽象类之中一定会存在构造方法（抽象类给继承，子类实例化首先也会调用父类的构造方法），目的用于属性初始化
     * 2. 抽象类不能使用final定义：因为抽象类必须有子类，而final定义的类不能够有子类
     * 3.外部抽象类不允许static声明，而内部的抽象类允许使用static声明。使用static声明的内部抽象类就相当于外部抽象类，继承的时候使用“外部类.内部类”表示类名称
     * 4.任何情况下,如果要执行类中的static方法的时候,都可以在没有对象的时候直接调用，对于抽象类也是一样
     * 5.在任何一个类的构造执行完之前，所有属性的内容都是起对应数据类型的默认值，而子类构造执行之前一定先执行父类构造
     */
}
