package com.study_java8;

/**
 * Created by Doctor on 2016/9/30.
 */
public class Java_Basic_String {
    public static void main(String[] args){
        //代码并没有使用关键字new进行,在String类里面有一个构造方法：public String(String str)
        //在构造里面依然要接收䘝本类对象
        String str = "Hello World";//String对象的直接赋值
        String strb = new String("Hello World");
        String strc = strb;
        System.out.println(str == strb);
        System.out.println(str == strc);
        System.out.println(strb == strc);
        //通过以上的分析记过发现,“==”现在的确是进行了比较,但是比较的并不是字符串对象包含的内容,二十比较了他们所在内存
        //地址的数字,所以“==”是属于数值比较，比较的是内存地址
        System.out.println(str.equals(strb));
        System.out.println(str.equals(strc));
        System.out.println(strb.equals(strc));
        //“=="是java提供的关系运算符,主要的功能是进行数值相等判断的，如果用在String对象上，表示的是地址内存数值的比较
        //“equals()":是由String提供的一个方法，此方法专门进行字符串的内容比较

        //字符串常量就是String的匿名对象  字符串常量就是String的匿名对象
        //实际上任何的语言都没有提供字符串这一概念,很多的语言里面都是使用了字符数组来描述的字符串概念.Java
        //里面也没有字符串的概念,但是所有的开发里面都不可能离开字符串的应用。那么最终的结果是,Java自己创造了字符串。但是这个字符串依然不属于基本数据类型
        //它是以字符串作为了String类的匿名对象的形式存在的
        "String".length();
        String str2 = "String";
        System.out.println(str2.equals("String"));
        //那么所谓的直接赋值实际上就是相当于将一个匿名对象设置了一个名字而已.但是唯一的区别是
        //String对象是由系统自动生成的，不再由用户自己创建
        //小技巧：为了避免空指针指向异常的出现,也可以将字符串写在前面调用方法
        "hello".equals(str2);//如果str2为空,不会出现空指针问题
        System.out.println();
        String stra = "hello";
        String strb1 = "hello";
        String strc1 = "hello";
        System.out.println(stra == strb1);
        System.out.println(stra == strc1);
        System.out.println(strb1 == strc1);

        //所有采用直接复制的String类对象的内存地址完全相同,stra,strb1,strc1,指向同一块堆内存空间
        //共享设计模式：在JVM的底层实际上回存在一个对象池，（不一定值只保存String对象）当我们代码之中使用了直接赋值
        //定义一个String类对象时,会见此字符串对象所使用的匿名入池保存,而后如果后续还有其它String类也采用了直接赋值的方式，并且设置了
        // 同样的内容的时候，那么不会开辟新堆内存空间。而是使用已有的对象进行引用的分配，从而继续使用。

        //通过内存分析可以发现，如果使用的构造方法的方式进行的String类对象实例化的时候，那么最终的操作形式就变为了开辟两块堆
        //内存空间，并且其中有一快堆内存空间将成为垃圾
        //除了内存的浪费之外,如果使用了构造方法定义的String类对象,其内容不会保存在对象池之中，因为使用关键字New开辟的新内存.
        //如果现在希望开辟的新内存数据也可以进行对象池保存,那么可以采用String类定义的一个手工入池的方法。public String intern();
        //String stra1 = new String("hello");
        String stra1 = new String("hello").intern();
        String strb2 = "hello";
        System.out.println(stra1 == strb2);
        //直接赋值（String str = "字符串“；）：只会开辟一块堆内存空间，并且会自动入对象池以便重复使用。
        //构造方法（String str = new String ("字符串“);）：会开辟两块堆内存空间，并且其中一块将成为垃圾。并且不会自动入池
        //但是用户可以使用intern方法手工入池。

        //字符串一旦定义则不可改变
        //String的内容不要过多频繁的修改，String类对象的内容变更是依靠的应用关系的变更实现的。（每一次变更都会产生垃圾）
        String deng = "Hello";
        deng = deng + " world";
        deng+="!!!";
        System.out.println(deng);
        //任何数据类型遇见String类型都向String类型转换
    }
}
