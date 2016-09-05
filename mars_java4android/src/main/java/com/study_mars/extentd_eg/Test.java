package com.study_mars.extentd_eg;

/**
 * Created by Doctor on 2016/9/5.
 */
public class Test {
    public static void main(String args[]){
        int flag = 1;

        if (flag==0){
            HPprinter hPprinter = new HPprinter();
            hPprinter.open();
            hPprinter.print("abc");
            hPprinter.close();
        }else if (flag==1){
            CanonPrinter canonPrinter = new CanonPrinter();
            canonPrinter.open();
            canonPrinter.print("abcd");
            canonPrinter.close();
        }
    }
}
