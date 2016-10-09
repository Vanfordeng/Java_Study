package com.study_doctor;

/**
 * Created by Doctor on 2016/9/29.
 */
public class MonkeysEatPeach_160929 {
    public static void main(String[] args){
        monkeyEatPeach();
        System.out.println(mon(0));
    }
    public static int  mon(int day){
        if(day == 10){
            return 1;
        }
        else{
//            递归的执行顺序就像栈一样，你可以把递归调用函数，每一层都放入栈，有返回值时，然后挨着从
//            栈内取出之前的函数段执行，一直执行到栈内为空为止，这过程中所有执行的结果即是该递归调用的结果
            /*
             *1.当 day=0,mon(0+1)，执行mon(1)，而return (mon(0+1)+1)*2;放入栈中等待mon(1)执行完毕再执行
             *2.当 day=1,mon(1+1)，执行mon(2)，而return (mon(1+1)+1)*2;放入栈中等待mon(2)执行完毕再执行
             *3.当 day=2,mon(2+1)，执行mon(3)，而return (mon(2+1)+1)*2;放入栈中等待mon(3)执行完毕再执行
             * ......
             * 9.当 day=8,mon(8+1)，执行mon(9)，而return (mon(8+1)+1)*2;放入栈中等待mon(9)执行完毕再执行
             *10.当day=9,mon(9+1)，执行mon(10),return 1,
             */
             return (mon(day+1)+1)*2;
        }

    }
    public static void monkeyEatPeach(){
        int sum = 1;
        for (int i = 1; i <= 10; i++) {
            sum=(sum+1)*2;
        }
        System.out.println(sum);
        for (int i = 10; 0< i; i--) {
//            第10天：1
//            第9天：(1+1)*2=4;
//            第8天：（4+1)*2=10个
//            第7天：（10+1)*2=22个
//            第6天：（22+1)*2=46个
//            第5天：（46+1)*2=94个
//            第4天：（194+1)*2=190个
//            第3天：（190+1)*2=382个
//            第2天：（382+1)*2=1534个
//            第1天：（1534+1)*2=3070个
//            System.out.println(i);
        }
        int y = 10;
        for (int i = 1; i <=10 ; i++) {
//            System.out.println(y);
            y--;
        }
    }
}
