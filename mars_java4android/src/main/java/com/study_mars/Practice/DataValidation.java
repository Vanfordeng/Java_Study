package com.study_mars.Practice;

/**
 * Created by Doctor on 2016/9/7.
 */
public class DataValidation {
    Integer id;
    String name;
    Integer age;
    String gender;
    Double pay;

    public void dataValid(String key, Integer id, String name, Integer age, String gender, Double pay) {

        if (id instanceof Integer) {
            this.id = id;
        }else {
            System.out.println("Please enter the Integer");
        }

        if (name instanceof String) {
            this.name = name;
        }else {
            System.out.println("Please enter the String");
        }

        if (age instanceof Integer) {
            this.age = age;
        }else {
            System.out.println("Please enter the Integer");
        }
        if (gender instanceof String) {
            this.gender = gender;
        }else {
            System.out.println("Please enter the String");
        }
        if (pay instanceof Double) {
            this.pay = pay;
        }else {
            System.out.println("Please enter the Double");
        }
    }
}
