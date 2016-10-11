package com.study_java8;

/**
 * Created by Doctor on 2016/10/10.
 */
class  Book5{
    public Book5(){
        System.out.println("[A] Book类的构造方法");
    }
    {//将代码块写在了类里面
        //
        System.out.println("[B] Book 类的构造块");
    }
    static {
        System.out.println("[C] Book类的静态构造块");
    }
}
public class Java_Basic_Codeblock {
    /*
     *代码块分为四种：
     * 普通代码块：实际上普通代码块就是为了防止在方法里面编写代码过多的时候有可能产生的变量重名
     * 构造块：如果将一个代码块写在了一个类中,构造块优先于构造方法执行
     * 静态块：如果一个代码块使用了static进行定义的话，那么久成为静态块
     * 情况一：在非主类中使用静态块：主要功能是为了类中的statci属性进行初始化的。并且对所有实例化只执行一次
     * 情况二：在主类中定义：此时静态块将优先于主方法执行（在JDK1.7之后修改了没有主方法也能执行静态代码块的Bug）
     * 同步代码块（多线程的时候讲解）：
     * 尽可能在你写代码过程之中不要去使用代码块
     */
    int num;  //全局变量 和局部变量是一个相对概率
    static{
        System.out.println("****************");
    }
    public static void main(String[] args){
        {  //普通代码块
            int num = 10;  //局部变量
            System.out.println("num = " + num);
        }
        int num = 100;  //全局变量
        System.out.println("num = " + num);

        //[B] Book 类的构造块
        //[A] Book类的构造方法
        new Book5();
        new Book5();
        new Book5();
    }
}
