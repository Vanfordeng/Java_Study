package com.study_mars.Class_eg;

/**
 * Created by dengqihong on 2016/9/2.
 */

/**
 * 其实可以理解为变量只有继承，没有覆盖；子类中从父类继承的变量其实是supper.i，跟之类自己定义的 this.i 不冲突。
 */
public class Prac {
    public static void main(String[] args){
        T1 test = new T2();
        test.a1(); //该值为：1  -->子类没有重写,调用父类的a1方法：输出：1
        test.a2(); //该值为：2  -->子类有重写,调用子类的a2方法并且调用子类重写a2方法重点的变量this.i: 输出：2
        System.out.println(test.i);
        test = (T2)test;
        System.out.println(test.i);

        T2 test2 = new T2();
        test2.a1();
        test2.a2();
        System.out.println(test2.i);
    }
}
class T1 {
    int i = 1;
    public void a1(){
        System.out.println(i);
    }
    public void a2(){
        System.out.println(i);
    }

}

class T2 extends T1{
    // 其实可以理解为变量只有继承，没有覆盖；子类中从父类继承的变量其实是supper.i，跟子类自己定义的 this.i 不冲突。
//    子类的方法使用时是调用的this.i。自己定义的i变量。
    int i = 2;
    public void a2(){
        System.out.println(i);
//        如上代码等效于：System.out.println(this.i);
    }

}