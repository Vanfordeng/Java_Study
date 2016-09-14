package com.study_mars.Interface_eg;

import com.study_mars.extentd_eg.*;

/**
 * Created by Doctor on 2016/9/5.
 */
public class Test {
    public static void main(String args[]){
        int flag = 1;
        Printer printer = PrinterFactory.getPrinter(flag);
        Printer printer1;
        //TODO:printer1接口变量也可以调用Object中的equals等方法？
//        printer1.equals();
        //Tips:向上转型,
        //        一个引用能够调用哪些成员（变量和函数），取决于这个引用的类型
        //        一个引用调用的是哪一个方法,取决于这个引用说指向的对象。(只针对子类中个有重写的方法)
        printer.open();
        printer.print("Test_1");
        printer.close();

    }
}
