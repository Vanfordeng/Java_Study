package com.study_java8;

/**
 * Created by Doctor on 2016/10/27.
 * since JDK1.5
 * foreach输出是由C#最早引用入的概念。其目的就是进行数组或者集合数据的输出
 */
public class Java_NewFeather_Foreach {
    public static void main(String[] args) {
        int[] data =  new int[]{1,2,3,4,5,6};
        //利用for和数组索引进行数组元素的访问，优点：但是可以使用索引控制要输出的元素
        for (int i = 0; i <data.length ; i++) {
            System.out.println(data[i]);
        }
        System.out.println("-------------");
        //有人认为以上的输出需要使用索引会比较麻烦
        //每一次选好实际上都表示数组的角标增长
        for (int i:data) {  //每一次循环会自动的将数组的内容设置给变量
            System.out.println(i);
        }
    }
}
