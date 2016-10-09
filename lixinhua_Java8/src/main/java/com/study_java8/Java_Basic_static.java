package com.study_java8;

/**
 * Created by Doctor on 2016/10/9.
 * static:可以声明属性、方法
 */
class Book3{
    private String title;
    private double price;
    static int num;
    //static声明的属性（非static属性）最大的区别在于保存的内存区域的不同
    //既然static是一个公共的属性的概念，那么如果只是简单的由一个对象去修改static属性的做法很不合适，那么最好的做法是
    //由所有对象的公共的代表来进行访问,那么就是类。所以来讲：利用static定义的属性是可以直接用类名称直接访问的

    //static属性与非static属性还有一个最大的区别，所有非static属性必须产生实例化对象后才可以访问，但是static属性不（必须）受
    //实例化对象的控制，也就是说，在没有实例化对象产生的情况下，也可以直接使用static属性
    static String puc = "清华大学出版社";
    public Book3(String title,double price){
        this.title = title;
        this.price = price;
        this.num ++;
    }
    public String getInfo(){
        return "图书名称：" + this.title + "\t 图书价格：" + this.price + "\t 图书出版社:" + this.puc;
    }

}
public class Java_Basic_static {
    public static void main(String[] args){
        Book3  b1 = new Book3("Java开发",10.2);
        Book3  b2 = new Book3("Android开发",10.2);
        Book3  b3 = new Book3("Oracle开发",10.2);
        b1.puc = "北京大学出版社";  //如果puc不是static修饰，b1.puc = "xxx"只能设置b1的的puc属性。
        //但是puc是所有图书共用的一个属性
        System.out.println(b1.getInfo());
        System.out.println(b2.getInfo());
        System.out.println(b3.getInfo());

        Book3.puc = "南京大学出版社";
        System.out.println(Book3.puc);

        System.out.println(Book3.num);
    }
    //什么时候使用static属性?什么时候使用static属性
    //如果需要描述出共享数据的时候，才使用static修饰属性.（可以方便集体修改，可以不重复开辟内存空间）
    //static方法不能直接范围非static属性或者方法,只能够调用static属性或者方法
    //非static方法可以访问static的属性或者是方法，不受任何的箱子
    /*
     * 所有的非static定义的结构,必须在类以及明确的参数了实例化对象才会分配堆内存空间，才可以使用
     * static属性保存在全局数据区，不是存储在堆内存当中
     * static属性保存在全局数据区，不是存储在堆内存当中
     * 内存区义工有四个：栈内存：存一个地址、堆内存：存储普通属性、全局数据区：存放static数据、全局代码区：存放所有的方法
     * 所有的static定义的结构，不受实例化对象的控制，即，可以在没有实例化对象的时候调用
     */
    //与属性定义一样：定义个类的时候首先考虑的依然是非static方法，因为所有的类如果保存的信息多（属性多）,每一个对象
    //栈的信息只有属性信息。那么每一个对象执行同一个方法的时候，就可以利用自己的属性实现方法的不同调用
    //一般一个类的方法是根据对象的属性判断方法执行结果,如果一个类连属性都没有那么可以考虑使用static修饰方法
}
