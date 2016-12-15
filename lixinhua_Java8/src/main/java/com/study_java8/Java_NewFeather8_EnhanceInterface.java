package com.study_java8;

/**
 * Created by Doctor on 2016/10/31.
 * 增强接口定义
 * 从Java发展之初到今天已经经过20年时间,所有的开发者都知道Java的接口由全局常量和抽象方法所组成。但是从JDK1.8的时代这一组成改变了。
 * 引出：
 * 如果说现在有某一个接口，这个接口随着时间的发展已经产生2W个子类，突然发现方法不足，应该再增加一个方法，而针对于所有不同的子类,这个方法的功能实现完全一样的。那么就要修改2W个子类中覆写这个方法
 * 为了解决这一的问题,允许在接口里面定义普通方法了，但是如果要定义普通方法必须明确使用default来进行定义。
 *
 * JDK 1.8里面有一个最重要的概念：内部类访问方法参数的时候可以不加final关键字
 */
interface IMessage1{  //定义接口
    public void print();  //这是一个接口里面原本定义的方法
    default void fun(){   //在接口里面定义了一个普通的方法,必须明确使用default关键字来定义
        System.out.println("毁三观的方法出现了！");
    }
     static void get(){ //除了使用default定义方法之外,还可以使用static定义方法，一旦使用了static定义方法意味着这个方法只可以(TODO 只可以应该改为最好，而不是只能)直接由类名称调用
        System.out.println("直接由接口调用");
    }
}
class MessageImpl2 implements IMessage1{
    @Override
    public void print() {
        System.out.println("Hello World!");
    }
}
public class Java_NewFeather8_EnhanceInterface {
    public static void main(String[] args) {
        IMessage1 i =  new MessageImpl2();
        MessageImpl2 m = new MessageImpl2();
        m.fun();  //fun() 接口里面的default方法
        i.print();
        IMessage1.get();   //get() 接口里面的static 方法

        /**@接口里面使用deafult或static定义方法的意义是避免子类重复实现同样的代码（情况1：后期发现接口方法不足,并且所有方法的功能一样）*/
    }
}
