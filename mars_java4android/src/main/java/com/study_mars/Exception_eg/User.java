package com.study_mars.Exception_eg;

/**
 * Created by Doctor on 2016/9/5.
 */
public class User {
   private int age;

    public void setAge(int age) throws Exception{//用throws来对函数声明抛出异常
        if (age <0){
            //自定义异常,Java不可能知道所有程序异常.只能定义公认的有问题的异常
            RuntimeException e = new RuntimeException("age not be -");
            Exception ex = new Exception("age not be 1000");
            throw ex;//抛出异常用throw
//            java编译器把unreachable　statement标记为运行时错误，一个unreachable　statement就是编译器决定永远不会执行它。
//            throw e;
        }
        this.age = age;
    }
}
