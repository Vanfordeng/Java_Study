package com.study_mars.hashCode_toString_eg;

import java.util.HashMap;

/**
 * Created by Doctor on 2016/9/7.
 */
public class Test {
    public static void main(String[] args){
        User u = new User("zhangsan",12);
        User u1 = new User("lisi",12);

        HashMap<User,String> map = new HashMap<User,String>();
        map.put(u,"abc");
        map.put(u1,"abcd");

        //s为null,通过键的hashcode来对比hashcode
        //
        String s = map.get(new User("zhangsan",12));
        System.out.println(s);

        //com.study_mars.hashCode_toString_eg.User@aa9c71b9abc
        //toString：com.study_mars.hashCode_toString_eg.User@aa9c71b9abc
        System.out.println(u.toString());
        System.out.println("abc");
    }
}
