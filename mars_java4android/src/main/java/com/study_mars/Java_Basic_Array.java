package com.study_mars;

/**
 * Created by Doctor on 2016/9/6.
 * 数组声明之后就没办法改变数组的长度
 */
public class Java_Basic_Array {
    public static void main(String[] args){
        //数组的静态定义法
        int[] arr = {5,2,7,9,0};
        //数组的动态声明方法
        //类型为int的数组，默认为0.char类型的数组,默认为空字符，Object类型的数组：默认为null,boolean类型的数组：默认为false
        int[] arr1 = new int[10];
        char[] arr2 = new char[10];
        boolean[] arr3= new boolean[10];
        Object[] arr4 = new Object[10];

        arr[3] =10;
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
        for (int i = 0; i < arr4.length ; i++) {
            System.out.println(arr4[i]);
        }
        //二维数组的定义方法
        //数组中的元素又是数组--线性代数
        int[][] arrto ={{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i <arrto.length ; i++) {
            for (int j = 0; j < arrto[i].length; j++) {
                //arrto[j][i]第j个元素的第i个元素 arrto[i][j]第i个元素的第j个元素
                System.out.println(arrto[j][i]);
            }

        }
    }
}
