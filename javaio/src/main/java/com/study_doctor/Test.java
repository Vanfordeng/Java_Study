package com.study_doctor;

/**
 * Created by Doctor on 2016/9/27.
 */

class Book{
    private String title = "Java";
}
class B extends Book{}
class C extends B{}


public class Test {
    public static void main(String[] args) {
        C c =  new C();
        System.out.println(c instanceof B);
        System.out.println(c instanceof Book);
    }
}
