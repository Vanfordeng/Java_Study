package com.study_mars.Collection_eg;

import java.util.ArrayList;

/**
 * Created by Doctor on 2016/9/6.
 */
public class Test {
    public static void main(String[] args){
        //动态数组
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        String s = arrayList.get(2);
//        String s2 = arrayList.get(3);
        //调用Remove方法会将动态数组长度减掉1
        arrayList.remove(0);

        for (int i = 0; i < arrayList.size() ; i++) {
            String s1 = arrayList.get(i);
            System.out.println(s1);
        }
        System.out.println(arrayList.size());
    }
}
