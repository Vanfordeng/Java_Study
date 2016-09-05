package com.study_mars;

/**
 * Created by Doctor on 2016/9/5.
 */
//异常：中断了正常指令流的事情
// 编译检查语法错误
// 运行检查异常错误,
//    Tips:Runtime异常又分为：checkException和UnCheckException.checkException编译器会要求代码必须加上一次捕获
//    Tips:try catch保证在代码有异常出错以后,代码后到的指令流可以正常运行
//    Tips:程序员对Error无能为力,只能处理Eception
public class Java_Basic_Exception {
    public static void main(String args[]){
        System.out.println(1);
        try{//如果不出异常执行以下代码块
            System.out.println(2);
            int i = 1/0; //如果出现异常,try中的后续代码不会再运行
            System.out.println(3);
        }catch (Exception e){//如果代码出现异常执行以下代码块
            System.out.println(4);
            //打印异常信息,不打印也可以
            e.printStackTrace();
            System.out.println(5);
        }finally {
            //try和catch 是其中只运行一个代码块中的代码.finally使用会运行
        }
        //checkException
//        Thread.sleep(1000);
    }
}

