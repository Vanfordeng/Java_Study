package com.study_java8;

/**
 * Created by Doctor on 2016/10/24.
 * public 、protected、default、private
 */
public class Java_Basic_Access_Permissions {
    public static void main(String[] args){
        //protected，这种权限设置直接与包有关
        //在不同的包中,protected属性直接实例化该属性定义的类的实例也无法访问自己的protected属性(但是在同一个包中,可以直接“对象.属性”或者“子类对象.属性" 来访问).编译出错.也即是说：只给儿子用
    }
}
