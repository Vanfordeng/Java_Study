package com.study_mars.IO_mode_eg;

/**
 * Created by Doctor on 2016/9/6.
 */
public class Test {
    public static void main(String args[]){
        /**
         * 装饰者模式：
         * Worker为装饰者：给被装饰者carpenter/plumber加上了一些功能：如说：hello
         */
        Carpenter carpenter = new Carpenter();
        AWorker aWorker = new AWorker(carpenter);
        aWorker.doSomeWork();
        Plumber plumber = new Plumber();
        AWorker aWorke =  new AWorker(plumber);
        aWorke.doSomeWork();
    }
}
