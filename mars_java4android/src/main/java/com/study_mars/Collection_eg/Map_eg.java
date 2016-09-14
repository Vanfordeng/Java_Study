package com.study_mars.Collection_eg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Doctor on 2016/9/6.
 */
//Map添加新的键如果已经存在会自动覆盖之前的键的值
//
public class Map_eg {
    public static void main(String [] args){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        Map<String,String> map = hashMap;

        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        //Map添加新的键如果已经存在会自动覆盖之前的键的值并且map的size不会变仍然为4
        map.put("1","e");
        int i = map.size();
        System.out.println(i);

        String s = map.get("1");
        System.out.println(s);
    }
}
