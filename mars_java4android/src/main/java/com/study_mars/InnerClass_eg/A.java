package com.study_mars.InnerClass_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class A {
    int i;
    //B能够使用A的成员变量，但是不拥有A的成员变量
    class B{
        int j;
        int funB(){
            //要在内部类中使用外部类的this;需要用外部类的类名.this方式
            //实际调用方式如下
            int result = A.this.i+this.j;
            return result;
        }
    }
}
