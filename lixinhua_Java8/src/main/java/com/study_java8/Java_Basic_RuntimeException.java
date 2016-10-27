package com.study_java8;

/**
 * Created by Doctor on 2016/10/26.
 */
public class Java_Basic_RuntimeException {
    public static void main(String[] args){
        //将字符串变为整型
        int temp = Integer.parseInt("sss");
        /**
         * public static int parseUnsignedInt(String s,int radix) throws NumberFormatException
         *
         * 该方法中有throws NumberFormatException(数字格式) 但是却没有处理
         *
         * java.lang.Object
                |-java.lang.Throwable
                    |-java.lang.Exception
                        |-java.lang.RuntimeException   -->：运行时异常
                            |-java.lang.IllegalArgumentException
         *在Java里面为了方便用户代码的编写，提供一种 RuntimeException 类,这种异常最大的特征在于：程序在编译的时候不会强制性的要求用户处理异常。
         * 用户可以根据自己的需要选择性进行护理。如果没有处理又发生了异常，交给JVM默认处理。RuntimeException子异常类可根据用户选择性进行处理。
         * @Exception和RuntimeException的区别：
         * Exception是RuntimeException的父类
         * 使用Exception定义的异常必须要被处理，而RuntimeException的异常可以由用户选择性进行处理
         * 常见的RuntimeException:NullPointerException,ArithmeticException,ClassCastException
         */
    }
}
