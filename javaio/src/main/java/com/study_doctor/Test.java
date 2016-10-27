package com.study_doctor;

/**
 * Created by Doctor on 2016/9/27.
 */

class Book{
    protected int price = 12;
    private String name = "BOOK";

    public void print(){
        System.out.println(price+"\t:"+name );
    }
}

class BookA extends Book{
    public void fun(){
        System.out.println("Book类的price属性的值：" + super.price);
    }
}

public class Test {
    public static void main(String[] args){
        int i=10;
        int y=0;
        try{
            int x = i/y;
        }catch (Exception e){
        }finally {
            System.out.println("出现异常了，我也执行了");
        }
        System.out.println("出现异常了,在finally之后我也执行了");
    }
}
