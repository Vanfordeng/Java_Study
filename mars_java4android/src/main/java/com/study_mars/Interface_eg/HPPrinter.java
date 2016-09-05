package com.study_mars.Interface_eg;

import com.study_mars.extentd_eg.*;

/**
 * Created by Administrator on 2016/9/5.
 */
public class HPPrinter implements Printer {
    @Override
    public void open() {
        System.out.println("HP open");
    }

    @Override
    public void close() {
        System.out.println("HP close");
    }

    @Override
    public void print(String content) {
        System.out.println("HP print" + content);
    }
}
