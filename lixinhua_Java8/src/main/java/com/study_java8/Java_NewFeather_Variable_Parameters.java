package com.study_java8;

/**
 * Created by Doctor on 2016/10/27.
 * since JDK1.5
 */
public class Java_NewFeather_Variable_Parameters {
    public static void main(String[] args) {
        System.out.println(add(new int[]{1,2,3}));
        System.out.println(add(new int[]{10,20}));
        System.out.println("------------------------------------------------");
        System.out.println(add_15(1,2,3,4));
        System.out.println(add_15(1,2,3));
        System.out.println(add_15(10,20,30));
    }
    //使用数组实现传递多个参数
    //代买之所以使用数组,是因为多个参数方法上无法描述，所以利用数组整合多个参数，但是严格来讲这样是实现并不标准，要求是
    //可以接收任意多个整型参数。理想的形式为：add(1,2,3)、add(10,20)、add(10,20,30，....)
    public static int add(int[] data){
        int sum = 0;
        for (int i = 0; i < data.length ; i++) {
            sum +=data[i];
        }
        return sum;
    }
    //这以功能在JDK 1.5之后，在JAVA中开始支持
    /*
     *[public][protected][private][static][final][abstract] 返回值类型  方法名称（参数类型...变量）{  //重点就在...上，使用的时候也是利用数组的方式来使用
     * [return[返回值]];}
     */
    //可变参数就是数组的变形应用，在大部分开发的情况下,应该要求参数的个数是准确的，对于这样的开发往往不会用于应用型的开发上，用于一些程序相关系统类的设计使用上
    public static int add_15(int ...data){
        int sum = 0;
        for (int i = 0; i < data.length ; i++) {
            sum +=data[i];
        }
        return sum;
    }
}
