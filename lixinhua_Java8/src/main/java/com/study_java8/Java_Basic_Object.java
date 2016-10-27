package com.study_java8;

/**
 * Created by Doctor on 2016/10/20.
 * Object类似所有类的父类，也就是说任何一个类在定义的时候如果没有明确的继承一个父类的话，那么他就是Object的子类
 * 既然Object是所有类的父类，那么最大的好处就在于：利用Object类可以接受全部类的对象，因为可以先上自动转型
 * Object类似所有类的父类,所以Object类可以接受一切引用数据类型，可以除了类的对象之外,Object类连数组和接口对象也都可以接收
 * 数据和接口：不可能继承一个类。但是以为它们是引用数据类型，所以Java认为所有引用数据类型都可归纳为Object类型
 */

/**
 * @问题：为什么要在Object类里面要定义一个无参构造方法呢？
 * @因为Object是所有类的父类,那么所有类对象实例化的时候构造方法一定要默认调用父类的[[[[@无参构造@]]]]]。如果没有无参构造，子类无法实例化
 */
//如下代码完全等效于 class BOOK extends Object
    /*
     *从严格意义上来讲（一般不遵守），任何一个简单java类都应该覆写Object类中如下3个方法：
     * 取得对象信息：public String toString()   //【链表中的getInfo】只要toString 方法输出的不是对象的编码，那么都是在Object的toString上覆写过的：EG:String
     * 对象比较：public boolean equals(Object obj)//【链表中的compare】
     * 取得对象HASH码：public int hashCode()
     */
class BOOK {
    public double price;
    public BOOK(){
        System.out.println("这是BOOK类的默认无参构造");
    }
    public BOOK(double price){
        System.out.println("这是BOOK类的有参数构造");
        this.price = price;
    }

    public boolean equals(Object object){
        if (this ==  object) return true;
        if (object == null) return false;
        if (!(object instanceof BOOK)) return false;
        BOOK book = (BOOK) object;  //需要向下转型，object才能获取到price属性。父类不向下转型不能看到子类的属性或不是覆写的方法
        if (this.price == book.price) return true;
        return false;
    }
}

class Java extends BOOK{

    public  Java(){
        System.out.println("这是Java类的无参构造");
    }
    public  Java(double price){
        super(price);
        System.out.println("这是Java类的有参构造");
    }
}
interface OB{
    public void fun();
}
class B1 implements OB{

    @Override
    public void fun() {
        System.out.println("");
    }
}
public class Java_Basic_Object {
    public static void main(String[] args){
        BOOK b =  new BOOK();
        b.toString();
        Object obja =  new BOOK(); //向上转型
        Object objb =  "Hello";  //向上转型

        BOOK b1 = (BOOK) obja;
        String s = (String) objb;

        s.toString();

        System.out.println(obja);
        System.out.println(objb);
        System.out.println("--------------------------------------------------------------------------------");
        Java java =  new Java(12.0d);
        Java java2 =  new Java(12.0d);
        System.out.println(java.price);
        System.out.println(java.equals(java2));
        System.out.println("--------------------------------------------------------------------------------");
        //* 数据和接口：不可能继承一个类。但是以为它们是引用数据类型，所以Java认为所有引用数据类型都可归纳为Object类型
        Object o =  new int[]{1,2,3};
        System.out.println(o);  //输出结果：[I@7f31245a  [I 为类名称，代表数组
        if (o instanceof int[]){
            int data[]  = (int[]) o;
            for (int i = 0; i < data.length ; i++) {
                System.out.println(data[i]);
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
        OB ob = new B1(); //接口对象
        Object obj = ob;   //接收接口对象
        OB a = (OB) obj;
        System.out.println(ob);  //com.study_java8.B1@6d6f6e28
        System.out.println(obj);
        System.out.println(a);

        //Object 类对象可以接收一切的数据类型（引用数据类型），包括数组和接口，解决了数据统一问题。
    }
}
