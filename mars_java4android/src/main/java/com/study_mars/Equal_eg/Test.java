package com.study_mars.Equal_eg;

/**
 * Created by Doctor on 2016/9/7.
 */
public class Test {
    public static void main(String [] args){
        User u1 =  new User();
        User u2 =  new User();
        User u3 =  new User();

        User u4 = u1;
        System.out.println(u1 == u2);
        System.out.println(u1 == u4);
        //未重写equals方法之前,equals和==等效,比较对象内存地址
        //TODO:age没有赋值,出现NullPointer
//        System.out.println(u1.equals(u2));
//        System.out.println(u1.equals(u4));
        u1.name="zhangsan";
        u1.age=12;

        u2.name="zhangsan";
        u2.age=12;

        u3.name="lisi";
        u3.age=12;
        System.out.println(u1.equals(u2));
        System.out.println(u1.equals(u3));
        //TODO:字符串“zhangsan"在内存池中的地址是相同的。String的池化思想。所以String用==和equals是一样的？
        System.out.println(u2.name==u1.name);
    }
    //对象的内容相等需要符合两个条件
    //1.对象的类型相同（可以使用instanceof操作符进行比较）
    //2.两个对象的成员变量的值完全相同（成员变量：User的age和name）
}
