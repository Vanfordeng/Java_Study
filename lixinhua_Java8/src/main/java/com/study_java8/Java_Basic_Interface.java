package com.study_java8;

/**
 * Created by Doctor on 2016/10/20.
 * 如果不会接口,别说你会Java.如果不会接口，其他的任何语言你都难以理解
 * 在整个Java里面,接口的主要功能是解决单继承的局限问题。
 * 接口作为标准用于解耦合以及不同层之间的连接桥梁
 * 接口概率：如果一个类之中只是由抽象方法和全局常量说组成，所以所谓接口严格来讲就属于一个特殊的类，而且这个类里面只有抽象方法，连构造方法都没有
 *
 * 对一个接口而言：发现里面的组成就是抽象方法和全局常量,所有有些人为了省略就不用写上abstract或public static final.接口里面只能使用一种
 * 访问权限public,Tips:在抽象类中的抽象方法不能不加abstract,接口能不写是因为默认它全是abstract.抽象类不是
 * interface A{
 *     public static fina String MGS = "HELLO";
 *     public abstract void fun();
 * }
 * 等效于：
 * interface A{
 *     String MGS = "HELLO";
 *     void fun();    //在接口里面没有写上public，其最终的访问权限一定也是public，一定不是default。为了防止误解，最好的做法是：在接口中定义方法
 *     的时候最好加上public:   public void fun();
 * }
 * interface A{
 *     String MGS = "HELLO"
 *     public void fun();
 * }
 *------------------------------------------------------------------------------------------------
 * 一个抽象类可以借此一个抽象类，但是反过来，一个接口却可以使用extends关键字继承多个接口（但是不能继承抽象类）。
 *------------------------------------------------------------------------------------------------
 * @虽然从接口本身的概念来讲只能够有抽象方法和全局常量，但是内部结构不受这些要求的限制：
 * @也就是说在接口里面可以定义普通内部类，抽象内部类，内部接口
 * ------------------------------------------------------------------------------------------------
 */
interface AI{ //定义一个接口
   // public abstract void AI();  //接口总是不能拥有构造函数的,因为接口的定义为全为抽象方法。而构造函数必须有方法体.所以也就是为什么接口里面只能有全局常量,因为普通属性需要在构造方法结束后去赋值
    //而全局常量不需要构造方法
    public static final String MGS ="Hello";  //全局常量
    public abstract  void print();

//    在一个接口内部如果使用了一个static去定义一个内部接口表示是一个外部接口
/**
 *@虽然从接口本身的概念来讲只能够有抽象方法和全局常量，但是内部结构不受这些要求的限制：
 *@也就是说在接口里面可以定义普通内部类，抽象内部类，内部接口
*/
    abstract class AA{
        public abstract void funAA();
    }

    /**
     * @相当于一个外部接口 因为static修饰
     */
    static interface AII{
        public void printAII();
    }
}
interface BI{
    public abstract void fun();
}
abstract class CA{  //抽象类
    public abstract void change();
}

//先Extends 后implements
class X extends CA implements AI,BI{  //X实现了A和B的两个接口
    @Override
    public void print() {
        System.out.println("A 接口的抽象方法");
    }

    @Override
    public void fun() {
        System.out.println("B 接口的抽象方法");
    }

    @Override
    public void change() {
        System.out.println("C 抽象类的抽象方法");
    }
    //从接口中继承的抽象内部类的实现，变为了X的内部类
    class Y extends AA{

        @Override
        public void funAA() {
            System.out.println("这是AI接口内部抽象类的抽象方法funAA");
        }
    }
}

//继承接口的内部接口
class XX implements AI.AII{

    @Override
    public void printAII() {
        System.out.println("这是AI内部接口的AII的抽象类的实现printAII");
    }
}
public class Java_Basic_Interface {
    public static void main(String[] args){
        X x = new X();
        AI a = x;   //向上转型
        BI b = x;   //向上转型
        CA ca = x;  //向上转型
        a.print();
        b.fun();
        ca.change();
        x.print();
        x.fun();
        x.change();
        System.out.println("------------------");
        AI a1 =  new X();
        BI b1 = (BI)a1;
        CA ca1 = (CA)b1;
//在我们定义结构上来讲AI和BI没有任何的直接联系，但是这两个接口却同时拥有一个子类:X子类，千万不要被类型和名称迷惑。
//因为最终实例化的是X子类,而这个子类属于B类的对象
        a1.print();
        b1.fun();
        ca1.change();
        System.out.println("------------------");
        X.Y y = new X().new Y();
        y.funAA();
        System.out.println("------------------");
        XX xx =  new XX();
        xx.printAII();
    }

    /*先期总结：接口的时机的开发之中有三大核心作用：
     *1.定义不同层之间的操作标准
     * 表示一种操作的能力
     * 表示将服务器端的远程方法识图暴露给客户端
     */
}
