package com.study_java8;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Doctor on 2016/10/17.
 */
class Person{
    private int age;
    private String name;

    public void setAge(int age){
        this.age = age;
    }
    public  void  setName(String name){
        this.name = name;
    }

    public int getAge(){
        return  this.age;
    }
    public String setName(){
        return this.name;
    }

    public String getInfo(){
        return "姓名：" + this.name + "\t年龄：" + this.age;
    }
}
//利用extends管机制在大部分的情况下都可以不用去考虑给出的继承的限制（前提：按照标准格式开发），但是是实现
//由于要限制用户的使用所欲针对继承也有一些自己的要求：
/*继承的限制：
 *在使用多层继承的时候并没有层数的限制,但是不要超过三层的继承关系。
 * 1.不允许多继承，允许多层继承
 * 2.子类在继承父类的的时候杨来讲继承父类中的全部操作，但是对于所有私有操作属于隐私继承，而所有非私有操作属于显示继承。
 */

class Student extends Person{
    private String school;

    public void setSchool(String school){
        this.school = school;
    }
    public String getSchool(){
        return  this.school;
    }
}

public class Java_Basic_Extends{
    public static void main(String[] args){
        Student stu = new Student();
        //Student中有age属性  属于隐私继承。不然this.age = age就没办法保存
        //stu.setAge()
        stu.setAge(24);
        stu.setName("Deng");
        System.out.println(stu.getInfo());
    }
}
