package com.study_java8;

/**
 * Created by Doctor on 2016/10/26.
 * 自定义异常:
 * 如下代码只能说是介绍自定义异常的形式，但是并不能说明自定义异常的实际使用
 */

class AddException extends Exception{
    public AddException(String mgs){
        super(mgs);
    }
}

public class Java_Basic_Customize_Exception {
    public static void main(String[] args){
        int num =12;
       // int temp = 10/0;  //Exception in thread "main" java.lang.ArithmeticException: / by zero
        try {
            if (num > 11){
                throw new AddException("传入数字过大");  //com.study_java8.AddException: 传入数字过大
            }
        }catch (AddException e){
            e.printStackTrace();
        }
    }
}
