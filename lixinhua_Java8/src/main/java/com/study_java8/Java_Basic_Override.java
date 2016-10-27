package com.study_java8;

/**
 * Created by Doctor on 2016/10/17.
 */
class A{
    public void print(){
        fun();
    }

//    private void  fun(){  //没有覆盖
    public void fun(){
        System.out.println("这是A类的fun()方法");
    }
}
class B extends A{
    public void  fun(){
        //this调用父类方法,如果子类中没有同名的方法，使用this.方法名可以调用父类的方法。如果有同名的方法，调用自己的子类自己 方法
        /*
         *关于super.方法（）和this.方法（）的区别：
         * 使用“this.方法（）”会首先查找崩了地中是否存在有要调用的方法名， 如果有则直接调用。如果没有则查找父类中是否有此方法。
         * 如果有就调用，如果没有则发生编译错误
         * 使用“super.方法（）”，明确的表示调用的不是子类方法（不插座子类中是否存在此方法）。直接调用父类的方法
         *
         * this可以表示本类的当前对象，super不能单使用
         *
         * 属性是覆盖：如果子类定义了和父类完全相同的属性名称的时候，就成为属性的覆盖
         */
        this.print();
        System.out.println("这是B类的fun()方法");
    }
}
class C extends A{
    public void  fun(){
        System.out.println("这是C类的fun()方法");
    }
}
public class Java_Basic_Override {
    public static void main(String[] args){

        /*
         *覆写结果的分析要素：
         * 观察实例化的是那个类
         * 观察这个实例化的类里面的调用的方法是否已经被覆写过的，如果没有覆写过调用父类的
         * 要求：
         * 权限：被子类所覆写的方法不能有拥有比父类更严格的访问控制权限。
         * 如果父类的方法权限为private:
         * 这个时候发现子类中根本就没有覆写,如果使用了private声明，那么这个方法对子类是不可见的。
         * 就说子类定义了一个与之完全相同的符合覆写的要求的方法，那么也不能够发送覆写。
         */
        B b = new B();
        b.print();
        C c = new C();
        c.fun();
    }
}
