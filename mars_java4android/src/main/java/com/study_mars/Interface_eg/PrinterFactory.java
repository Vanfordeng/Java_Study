package com.study_mars.Interface_eg;

import com.study_mars.Interface_eg.*;
import com.study_mars.Interface_eg.Printer;

/**
 * Created by Doctor on 2016/9/5.
 */
public class PrinterFactory {

    public static Printer getPrinter(int flag){
        Printer printer =null;
        if (flag == 0){
            printer = new HPPrinter();
        }else if (flag ==1){
            printer = new CanonPrinter();
        }
        return printer;
    }

}
