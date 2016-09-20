package com.study_doctor;

/**
 * Created by Doctor on 2016/9/12.
 */
public class Fibonacci_160912{
    public static void main(String[] args) {
        //fibonacci1
        int [] results = fibonacci1(10);
        for (int i : results) {
            System.out.println(i);
        }
        //fibonacci1_1
        fibonacci1_1(10);
        //fibonacci2
        for (int i = 0; i < 10 ; i++) {
            try {
                System.out.println(fibonacci2(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 递推方法实现此方法->主要使用于:使用场景一：对于对象或变量使用次数比较少，使用一次以后就不会再使用的场
    // 景；使用场景二：对于内存资源比较稀缺的实时性要求不是太高的嵌入式系统设计中多会采用此种方式；
    public static int[] fibonacci1(int n) {
        int result, temp1 = 0, temp2 = 1;
        int[] results = new int[10];

        for (int index = 0; index < n; index++) {
            if (index == 0) {
                result = temp1;
                results[0]=result;
            } else if (index == 1) {
                result = temp2;
                results[1] = result;
            } else {
                result = temp1 + temp2;
                results[index] = result;
                if (result < 0) {
                    break;
                }
                temp1 = temp2;
                temp2 = result;
            }
        }
        return results;
    }
    //使用数组方法
    public static void fibonacci1_1(int n){
        int[] results = new int[100];
        results[0]=0;
        results[1]=1;
        for (int j = 0; j < n; j++) {
            results[j+2] = results[j]+results[j+1];
            System.out.println(results[j]);
        }
    }
    /*函数自迭代此种方式缺点：大量迭代不断消耗栈空间(搞web开发调试维护的都应该知道服务器栈资源的可贵，如果大量并发调用迭代导致服务器栈资源迟迟得不到回收，
      而导致web服务器崩溃)，效率底，函数自闭性比较弱(优秀的接口应该对输入输出可能出现的错误信息进行捕捉，
     并提供清楚明了的处理结果)，很容易出现错误，调试困难，实际应用中一般不建议使用这种方式，使用时迭代次数也不能超过3次；*/
    public static int fibonacci2(int n) throws Exception {
        if(n==0){
            return 0;
        }else if(n==1||n==2){
            return 1;
        }else if(n>2){
            int temp=fibonacci2(n-1)+fibonacci2(n-2);
            if(temp<0){
                throw new Exception("Invalid value for int type, too large");
            }else{
                return temp;
            }
        }else{
            throw new Exception("IllegalArgument value for n,please enter n>=0 ");
        }
    }
}