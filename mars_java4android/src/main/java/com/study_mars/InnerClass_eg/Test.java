package com.study_mars.InnerClass_eg;

import sun.security.acl.AclImpl;

/**
 * Created by Doctor on 2016/9/6.
 */
public class Test {
    public static void main(String [] args){
        A a  = new A();
        //
        A.B b = a.new B();
        a.i=3;
        b.j=1;
        System.out.println(b.funB());
        //--------------------------------------
//        BImpl bl = new BImpl();
//        ASecret aSecret = bl;

        B b1 = new B();
        //如下new Asecret 不是new aSecret接口的对象。而是new的实现了Asecret的实现类的对象,只是该实现类没有名字
        b1.doB(new ASecret(){
            @Override
            public void doSomething() {
                System.out.println("Inner secret class");
            }
        });
    }
}
