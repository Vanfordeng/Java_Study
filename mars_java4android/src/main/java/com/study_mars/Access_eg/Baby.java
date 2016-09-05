package com.study_mars.Access_eg;

import com.study_mars.Class_eg.Person;

/**
 * Created by doctor on 2016/9/5.
 */
public class Baby extends Person{


    Baby(){
//   父类构造函数为包访问,Baby，无法使用super访问父类构造函数
//        super();
        super();
    }
    public int cry(){
//        this.age = 0;
        this.age = 1111;
        return this.age;
    }
    public static void main(String args[]){
        System.out.println(new Baby().cry());
    }
}
