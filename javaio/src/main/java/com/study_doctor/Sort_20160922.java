package com.study_doctor;

/**
 * Created by Doctor on 2016/9/22.
 */
public class Sort_20160922 {
    //对输入的数字排序
    public static void main(String[] args){
        int j;
        int[] s = new int[]{6,9,111};
        for (int i = 0; i <s.length ; i++) {
            j = s[0] > s[1] ? s[0]:s[1];
            j = j > s[2]? j :s[2];
            System.out.println(j);
            s[getIndex(s,j)] = 0;
        }
    }

    public static int getIndex(int[] s,int v){
        for (int i = 0; i < s.length ; i++) {
            if (s[i] == v){
                return i;
            }
        }
        return -1;
    }
}
