package com.study_doctor;


import java.util.ArrayList;

/**
 * Created by Doctor on 2016/10/7.
 */
public class ListOfMatches_161007 {
    String a,b,c;
    public static void main(String[] args) {
        String[] op = { "x", "y", "z" };
        ArrayList<ListOfMatches_161007> arrayList=new ArrayList<ListOfMatches_161007>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++) {
                    ListOfMatches_161007 a=new ListOfMatches_161007(op[i],op[j],op[k]);
                    if(!a.a.equals(a.b)&&!a.b.equals(a.c)&&!a.a.equals("x")&&!a.c.equals("x")&&!a.c.equals("z")){
                        arrayList.add(a);
                    }
                }
        for(Object a:arrayList){
            System.out.println(a);
        }
    }
    public ListOfMatches_161007(String a, String b, String c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public String toString() {
        return "a 的对手是"+a+","+"b 的对手是"+b+","+"c 的对手是"+c+"\n";
    }
}
