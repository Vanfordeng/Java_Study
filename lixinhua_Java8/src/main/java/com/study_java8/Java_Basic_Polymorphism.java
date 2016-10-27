package com.study_java8;

/**
 * Created by Doctor on 2016/10/18.
 * 多态性
 */
class AA{
    public void print(){
        System.out.println("AA public void print()");
    }
}
class BB extends AA{
    public void print(){
        System.out.println("BB public void print()");
    }
    public void fun(){
        System.out.println("BB public void fun()");
    }
}
public class Java_Basic_Polymorphism {
    //多态性严格来讲有两种描述形式：
    //一：方法的多态性：
    //1.方法的重载 ：同一个方法名称,会根据传入参数的类型及个数不同实现不同的功能
    //2.方法的覆写 ：同一个方法，会根据子类的不同，实现不同的功能

    //二：对象的多态性：
    //向上转型（自动完成）：父类  父类对象 = 子类实例；
    //向下转型（强制完成）：子类  子类对象 = （子类）父类实例；
    public static void main(String[] args){
        //第一：看new的是什么类型
        //第二：看方法是否被覆盖
//**********        一个引用能够调用哪些成员（变量和函数），取决于这个引用的类型
//**********        一个引用调用的是哪一个方法,取决于这个引用说指向的对象。(只针对子类中个有重写的方法)
        /***子类有点使用子类的，子类没有的使用父类的*/
//**********    其实可以理解为变量只有继承，没有覆盖；子类中从父类继承的变量其实是supper.i，跟子类自己定义的 this.i 不冲突。

        //向上转型：由于所有的子类对象实例都可以自动的向上转型，所以在于参数的统一上。
        AA aa =  new BB();   //向上转型
        aa.print();
//        aa.fun();      无法获取到fun()方法
        //向下转型：指的是父类要调用子类自己特殊的方法，所有的父类发生了向上转型之后只能够看见父类自己定义的全部的方法信息
        //但是看不见子类特殊的方法，于是此时就需要向下转型，将父类转型为子类对象，就可以使用子类的特殊方法
        BB bb =  (BB)aa;     //向下转型    1.先把一个对象向上转型,再把对象向下转型
        bb.print();
        bb.fun();
        BB bb1 = new BB();  //实例化BB类对象，AA类对象一定是存在的
        AA aa1 = new AA(); //实例化AA类对象，BB类对象不存在。不会调用BB类构造函数
        System.out.println(bb1 instanceof AA);  //true
        System.out.println(bb1 instanceof BB);  //true
        System.out.println(aa1 instanceof AA);  //true
        System.out.println(aa1 instanceof BB);  //false

        //对于向下转型如果要发生之前，一定要首先发生对象的向上转型，建立关系后才可以进行。
        //邓是一个人，人一定要吃饭。
        aa1 = bb1;
        aa1.print();

        System.out.println(aa1 instanceof AA);  //true
        System.out.println(aa1 instanceof BB);  //true
        if (aa1 instanceof  BB){
            BB b = (BB)aa1;
            System.out.println(b instanceof AA);  //true
            System.out.println(b instanceof BB);  //true
            b.fun();
            b.print();
        }

        if (bb1 instanceof  AA){
            //直接向下转型会出现：ClassCastException
            bb1 = (BB)new AA();
            bb1.fun();
        }
        //BB bb1 =  (BB)new AA();   //无法直接转型
        System.out.println("----------------------");
        fun(new BB());

    }
    /*
     * 对于数据的操作分为两步：
     * 第一步：设置数据（保存数据），最需要的是参数统一功能
     * 第二部：取出 数据
     */
    public static void fun(AA aa){  //此方法统一参数，对所有AA的子类均可用
        System.out.println("参数统一了");
        //要使用某个子类的特殊方法，调用个性化特征
        BB bb = (BB)aa;
        bb.fun();
    }

    /*对于对象的转型，给出以下经验总结：
     *    80% 的情况下都只会使用向上转型,因为可以得到参数类型的统一，方便于我们的程序设计：链表
     *    5% 的情况下，会使用向下转型，调用子类特殊的方法
     *    15% 的情况下，不转型，例如：String
     *    个性化的操作在一个标准的开发之中应该尽量少出现，因为对象的转型操作里面 毕竟有了强制问题，容易带来安全隐患。
     */

    //ClassCastException:类转换异常：指的是两个没有关系的类对象强制发生向下转型时所带来的的异常
    //为了保证转型的顺利进行，在Java里面提供有一个关键字：instanceof  对象 instanceof 类
      // 子类尽量不要过多的扩充与父类无关的操作方法：
      // 90%的情况下子类的方法要与父类的方法跟父类的方法功能一致
}
