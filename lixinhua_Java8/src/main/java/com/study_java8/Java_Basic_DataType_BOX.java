package com.study_java8;

/**
 * Created by Doctor on 2016/10/24.
 * 包装类：Java在设计之初,有一个基本的原则：一切皆对象
 * 矛盾：基本数据类型不是对象,所以如果要进行基本数据类的变为对象就需要包装
 */
//基本类型：byte(Byte)、short(Short)、int(Integer)、long(Long)、float(Float)、double(Double)、char(Character)、boolean(Boolean)
    //但是以上的给出的包装类又分为两种子类型：
        //--对象型包装类（Object）:Character,Boolean
        //--数值型包装类（Number）:Byte,Short,Integer,Long,Float,Double
        //----：Number是一个抽象类，里面一共提供定义了六个操作方法：intValue,longValue,floatValue,doubleValue,byteValue,shortValue

class MyInt{ //一个类，用于包装基本数据类型
    private int num; //说要包装的基本数据类型

    //构造的目的是为了将基本数据类型传递给对象
    public MyInt(int num){ //将基本数据类型包装：装箱-boxing
        this.num = num;
    }
    public int intValue(){ //将包装的数据内容返回：拆箱-unboxing  拆箱之后才可以进行基本数据类型的运算
        return this.num;
    }
}

public class Java_Basic_DataType_BOX {
    public static void main(String[] args){
        MyInt mi = new MyInt(10);
        int temp =  mi.intValue();
        System.out.println();
        //--------------------------------
        /*
         *装箱操作：将节本数据类型变为包装类的形式；
         * |- 每个包装类的构造方法都可以接收各自基本数据类型的变量
         * 拆箱操作：从包装类之中取出被包装的数据：
         * |-利用Number类中提供的一系列方法：xxxValue()取出基本数据
         */

        Integer integer = new Integer(10); //将基本数据类型装箱
        int t = integer.intValue(); //将数据拆箱
        System.out.println(integer + "" + t + "");

        Boolean b =  new Boolean(true);
        boolean t1 = b.booleanValue();
        System.out.println(t1);
        //现在可以发现，所有的包装类都使用了同样形式的方法进行操作
        //2005 年之后：JDK 1.5之前都是以上形式来装箱/拆箱。1.5之后形式如下：
        Integer in = 10;
        int tem = in;
        in++;
        System.out.println(tem * in);

        //两者区别：new 出来的需要用equals方法比较
        Integer obja = 10;
        Integer objb=10;
        Integer objc = new Integer(10);
        System.out.println(obja == objb);
        System.out.println(obja == objc);
        System.out.println(objb == objc);
        System.out.println(objb.equals(objc));

        //Object可以统一天下了
        Object obj = 10;  //先包装再转换
//        int te = (int)obj;?
        int te = (Integer)obj;
        System.out.println(obj);

        //使用包装类的最多的情况实际上只它的数据类型的转换功能上，在包装类里面提供有将String型数据类型转换为基本数据类型的方法
        //程序接收用户输入最多的方式是接收String类型数据
        /*
         * Integer类：public static int parseInt(String s);
         * Double类：public static double parseDouble(String s);
         * Boolean类：public static boolean parseBoolean(String s);
         * 。。。。。 其它
         *特别需要注意的是Character类里面并不存在有字符串变为字符的方法,String里面提供了一个charAt。所以并没有重复提供
         */

        String str = "123";
        //转换的时候如果类型（如下）不对会出现：NumberFormatException 异常
        String str2 = "Aaa123";

        int str1 = Integer.parseInt(str);
        System.out.println(str1 * 2);

        //在Boolean进行转换过程里面,如果要转换的字符串不是true或者false,那么将统一按照false处理
        String string = "ffgg3e";
        boolean boo =  Boolean.parseBoolean(string);
        System.out.println(boo);
        //现在既然已经实现了字符串变为基本数据类型的操作,那么也一定可以实现基本数据类型变为字符串的操作，对于此类操作有两种做法：
        //1-- 操作一：任何数据类型与 “+”操作 字符串之后都变为字符串
        // 以上操作会产生垃圾
        //2. public static String valueOf(数据类型 i)
        int num =100;
        String str3 = String.valueOf(num);
        System.out.println(str3);
    }
}
