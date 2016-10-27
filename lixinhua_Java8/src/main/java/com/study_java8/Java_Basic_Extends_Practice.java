package com.study_java8;

import java.util.Arrays;

/**
 * Created by Doctor on 2016/10/17.
 */
class Array{
    private int[] data;
    private int foot;

    public Array(int len){
        if (len >0){
            data =  new int[len];
        }else {
            data = new int[1];
        }
    }
    public boolean add(int num){
        if (foot < data.length){
            data[this.foot++] = num;
            return true;
        }else {
            return  false;
        }
    }
    public int[] getData(){
        return this.data;
    }
}
//定义一个排序数组的子类

/*
 * 绝对不改变客户端已有的方法
 * 子类现在为了要维持方法的工继续完善，所以必须根据情况进行父类的方法的覆写
 * 除了类名称改变,方法名称没有任何改变。而功能进行了改变
 */
class SortArray extends Array{
    //Array类里面现在没有无参构造方法
    public SortArray(int len){
        //这样父类的data数组就可以初始化
        super(len); //明确的调动父类的有参数构造函数
    }
    //因为父类中getData()方法满足于当前类使用的，但是又需要保持这个方法名称
    public int[] getData(){
        Arrays.sort(super.getData());
        return super.getData();
    }
}
/*
 *子类的工就是根据特殊的情况进行父类的扩充
 * 子类扩充方法的时候，尽量以父类定义的方法名称为主，可以根据实际情况进行方法的覆写
 */
class ReverseArray extends Array{
    public ReverseArray(int len){
        super(len);
    }
    public int[] getData(){
        int center =  super.getData().length/2;
        int tail = super.getData().length-1;
        for (int i = 0; i < center ; i++) {
            int temp =  super.getData()[i];
            super.getData()[i] = super.getData()[tail];
            super.getData()[tail] = temp;
            tail --;
        }
        return super.getData();
    }
}
public class Java_Basic_Extends_Practice {
    public static void main(String[] args){
        ReverseArray a =  new ReverseArray(3);
        System.out.println(a.add(60));
        System.out.println(a.add(20));
        System.out.println(a.add(1110));
        System.out.println(a.add(10));
        int[] temp =  a.getData();
        for (int i = 0; i < temp.length ; i++) {
            System.out.println(temp[i]);
        }
    }
}
