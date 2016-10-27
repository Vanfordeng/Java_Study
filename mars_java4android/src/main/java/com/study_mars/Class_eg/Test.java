package com.study_mars.Class_eg;

public class Test{
    public static void main(String[] args){
		Student st = new Student(3,"doctor",100);
        Teacher th = new Teacher();
        //向上转型,越是抽象的越是处在上层
        Person pt = st;
        //向下转型,1.先把一个对象向上转型,再把对象向下转型
        st = (Student) pt;
        //如下代码会提示如下异常：Exception in thread "main" java.lang.ClassCastException: com.study_mars.Baby cannot be cast to com.study_mars.Student
//            Baby pt1 =  new Baby();
//             st = (Student) pt1;

        //pt无法调用student里面的grade变量。
//        一个引用能够调用哪些成员（变量和函数），取决于这个引用的类型
//        一个引用调用的是哪一个方法,取决于这个引用所指向的对象。(只针对子类中个有重写的方法)
//        就好比,父亲可以叫儿子去干某件事,虽然自己也可以做，但是儿子做得更好。但是不能私自去拿儿子的东西.儿子自己可以拿自己的东西
//        多态详解(整理)--->多态是通过:
//        1 接口 和 实现接口并覆盖接口中同一方法的几不同的类体现的
//        2 父类 和 继承父类并覆盖父类中同一方法的几个不同子类实现的.

//        pt.grade;  调用不成功
        pt.eat();
    }
}
