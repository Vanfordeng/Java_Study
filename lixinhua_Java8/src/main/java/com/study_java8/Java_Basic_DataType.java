package com.study_java8;

/**
 * Created by Doctor on 2016/9/19.
 */
public class Java_Basic_DataType {
    public static void main(String[] agrs){
        //任何的程序严格意义来讲都属于一个处理游戏
        /*
         * 基本数据类型：
         * 数值型： 整型：byte、short、int、long   ->0
         *          浮点型：float、double          ->0.0
         * 字符型：char:                           ->'\u0000' 空字符
         * 布尔型：boolean                         ->false
         * 引用数据类型：数组,类，接口             ->null
         * 个人选择数据类型的原则：
         * 1.如果要想表示整数机使用int,表示小数就使用double
         * 2.如果要描述日期时间数字或者表示文件（或内存）大小使用long;
         * 3.如果要实现内容传递或者是编码转换使用byte
         * 4.如果想要实现逻辑的控制，可以使用boolean描述
         * 5.如果想要使用中文,使用char
         * byte<int<long<double
         */


        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println("max:  "+max);
        System.out.println("max+1:  "+(max+1));
        System.out.println("min:  "+min);
        //数据的溢出，解决方法：扩大数据类型
        System.out.println("min-1:  "+(min-1));

        /**
         * 扩大数据范围的方式解决：
         * 1.数据范围小的数据和数据范围大的数据进行数学计算的时候,自动向数据类型范围大的数据类型转换
         * 2.数据类型范围大的数据要变为数据类型小的数据，那么必须采用强制类型转换
         * 3.如果是常量进行强制类型转换，有两种：常量标记（L，l)eg:1L,使用数据类型“（数据类型）” eg:long(2)
         */
        System.out.println("max:  "+max);
        System.out.println("max+1:  "+(max+1L));
        System.out.println("min:  "+min);
        //数据的溢出，解决方法：扩大数据类型
        System.out.println("min-1:  "+((long)min-1));

        //强制数据类型转换
        long num =  2147483648L; //long类型必须加L
        int x = (int) num;  //把long变为int
        System.out.println(x);
        //默认数字为int类型
        //默认数字为int类型
        byte numByte = 100;
        //虽然任何一个整型都属于int型，但是Java编译的时候,如果发现使用的数据变量为byte数据范围之内，那么就会自动的帮助
        //用户实现数据类型的转换,返之，如果超过了，这依然以int型为主.该特性只在直接给byte赋值的时候发生。
        System.out.println(numByte);
        //提示：所有的变量在使用的时候一定不要去相信默认值,都设置具体内容。如果在方法里面定义的变量,默认值不起作用
        //提示：所有的变量在使用的时候一定不要去相信默认值,都设置具体内容。如果在方法里面定义的变量,默认值不起作用
        int numDefault;
//        System.out.println(numDefault); 语法错误
        double dou = 10.2;
        //double型 *  int型（转化为，2.0） = double 型
        //由于默认的小数类型就是double,所以如果使用了float表示需要将double型变为float型,需要采用向下强制
        //转化
        System.out.println(dou*2);
        float f1 = (float) 10.2;
        float f2 = 10.2F;
        System.out.println(f1*f2); //输出：104.03999。JDK1.0的时候就存在这个Bug,解决不了，只能够通过后期的处理完成.
        int x1 = 9;
        int y = 5;
        System.out.println(x1/y); //结果为1：int型不保存小数位
        //在以后的开发中,一定要考虑到整数不保留小数位的问题
        System.out.println(x1/(double)y);
        char c = 'A'; //字符
        int num2 =c;
        //字符可以和int型互相转换（以编码的形式出现）
        System.out.println(c);
        System.out.println(num2);

        boolean flag = true;
        //Java中不允许0,1来表示布尔
        //数据类型 变量 = “内容”
        int num1 = 100;
        double num11 = 99.0;
        String str = "Hello world!";//字符串变量
        //如果遇见String的“+”，那么所有的数据类型都想变为String型,而后再执行数据串的连接操作。
        // （）优先级最高,可以变为先计算再执行+字符串连接
        str = str +num1+num11;
        System.out.println(str);//字符串常量
        //数据类型的转换用户都是小范围自动线大范围转换,如果将大范围变为小范围要使用强制转换

    }
}
