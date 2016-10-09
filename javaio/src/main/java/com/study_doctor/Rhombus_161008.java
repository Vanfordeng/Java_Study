package com.study_doctor;

/**
 * Created by Doctor on 2016/10/8.
 */
//     * 
//    ***
//   ******
//  ********
//  ******
//   ***
//    *
public class Rhombus_161008 {
    public static void main(String[] args){
        int i=0;
        int j=0;
        for(i=1;i<=4;i++)
        {
            for(int k=1; k<=4-i;k++)
                System.out.print(" ");
            for(j=1;j<=2*i-1;j++)
                System.out.print("*");
            System.out.println("");
        }
        for(i=4;i>=1;i--)
        {
            for(int k=1; k<=5-i;k++)
                System.out.print(" ");
            for(j=1;j<=2*i-3;j++)
                System.out.print("*");
            System.out.println("");
        }
}

    public static void printRhombus(int line){
        for (int x = 1; x <= (line/2)+(line/2-1); x++) {
            for (int y = 1; y <= line ; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
