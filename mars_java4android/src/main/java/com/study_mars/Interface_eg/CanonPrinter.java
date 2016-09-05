package com.study_mars.Interface_eg;

import com.study_mars.extentd_eg.*;

/**
 * Created by Doctor on 2016/9/5.
 */
public class CanonPrinter implements Printer {
    @Override
    public void open() {
        System.out.println("Canon open");
    }

    @Override
    public void close() {
        this.clean();
        System.out.println("Canon close");
    }

    @Override
    public void print(String content) {
        System.out.println("Canon print"+content);
    }

    private void clean(){
        System.out.println("Canon clean");
    }
}
