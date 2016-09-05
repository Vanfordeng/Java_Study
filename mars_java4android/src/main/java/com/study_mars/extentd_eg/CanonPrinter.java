package com.study_mars.extentd_eg;

/**
 * Created by Doctor on 2016/9/5.
 */
public class CanonPrinter extends Printer{
    public void close(){
        this.clean();
        super.close();
    }
    public void clean(){
        System.out.println("Clean");
    }
}
