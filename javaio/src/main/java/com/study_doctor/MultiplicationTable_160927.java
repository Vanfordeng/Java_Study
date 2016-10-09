package com.study_doctor;

/**
 * Created by Doctor on 2016/9/27.
 */
public class MultiplicationTable_160927 {

    //乘法表
    public static void main(String[] args){
        multiplication();
        multiplication2();
    }

    public static void multiplication(){
        for (int x = 1; x <=9; x++) {
            for (int z = 0; z < x-1 ; z++) {
                System.out.print("         "+"\t");
            }
            for (int y = x; y <= 9; y++) {
                System.out.print(x + " * " + y + " = " + x*y + "\t");
            }
            System.out.println();
        }
    }
    public static void multiplication2(){
        for (int x = 1; x <= 9 ; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(y + " * " + x + " = " + x*y + "\t");
            }
            System.out.println();
        }
    }
}
