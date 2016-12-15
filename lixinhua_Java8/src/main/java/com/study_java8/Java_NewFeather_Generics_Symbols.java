package com.study_java8;

/**
 * Created by Doctor on 2016/10/27.
 * 泛型：通配符   主要解决方法中调用泛型类型的时候,如果需要在主程序中修改了泛型类型。那么所有方法的泛型类型都需要修修改
 */
class Messages<T>{
    T msg;

    public void setMsg(T msg) {
        this.msg = msg;
    }

    public T getMsg() {
        return msg;
    }
}
public class Java_NewFeather_Generics_Symbols {
    public static void main(String[] args) {
        Messages<Integer> m = new Messages<Integer>();
        Messages<String> m2 = new Messages<String>();
        m.setMsg(100);
        m2.setMsg("Hello World !");
        fun(m);  //引用传递，将m传递给temp
        fun(m2);
    }

    //但泛型类作为方法的参数时候,无法根据泛型的标记不同而达到方法重载的目的（因为方法的重载认的知识 @参数的类型@ 和个数,与泛型无关）.那么就会出现：一旦泛型的标记类型改变后,方法的标记也必须跟着改变。不利于代码维护
//    public static void fun(Messages<Integer> temp){  //无法重载
//        System.out.println(temp.getMsg());
//    }
    //解决方法一：不设置标记的具体类型,让其默认为Object类型，那么每次传入都会将具体类中向上转型为Object,如果使用getMsg要得打具体类型还是需要向下转型
    //在Eclipse中只要不设置泛型,就会出现警告信息
    //public static void fun(Messages temp){
      //  temp.setMsg("hello");  //因为temp是Object类型,设置为String也可以并且改变了传入的值
        //System.out.println(temp.getMsg());
    //}
    /**@所以现在最应该解决的是，需要有一种方式可以接收一个类的任意的泛型类型，但是不可以修改只能够去除,那么就可以使用“？”*/
    public static void fun(Messages<?>/*明确表示不能够设置,只能够取出数据*/ temp){  // TODO: 2016/10/27 所以“？”来接收泛型是用在方法上？
        //temp.setMsg(100);  //提示编译错误：capture  of <?> 无法设置内容、
        System.out.println(temp.getMsg());
    }
    //在“？"通配符基础上还会有两个子的通配符：
    // ? extends 类：设置泛型上限；可以在声明上和方法参数上使用
      //|-:? extends Number:意味着可以设置Number或者Number的子类：Double,Integer...
             //class Messages<T extends Number>：
             //public static void fun(Messages<? extends Number> temp):只能够接收Number或者Number的子类，如果不是Number或子类,会出现编译错误
    // ？super 类：设置泛型下限：方法参数上
       //|-:？ super String:意味着只能够设置String或者它的父类Object
             //public static void fun(Messages<? super String> temp)
}
