package com.study_java8;

/**
 * Created by Doctor on 2016/10/31.
 * @对于方法的引用,严格来讲都需要定义一个接口,可是不管如何操作,实际上有可能操作的接口只有四种，在JDK1.8中提供了一个包：java.util.function
 *  * 1、功能性接口(Function)：public Interface Function<T,R>{public R apply(T t);}
 *   |--此接口需要接受一个参数，并且返回一个处理结果
 * 2、消费型接口(Consumer): public Interface Consumer<T>{public void accept(T t);}
 *   |--此接口只是负责接受数据（引用数据是不需要返回），并且不返回结果
 * 3、供给型接口(Supplier): public Interface Supplier<T>{public T get();}
 *   |--此接口不接受参数,但是可以返回结果
 * 4、断言型接口：public interface Predicate<T>{public boolean test(T t);}
 *   |--进行判断操作使用
 *   所有在JDK1.8之中由于存在有以上的四个功能型接口，所有用户很少会去自己定义函数式接口
 * 方法引用：指为一个方法设置别名，相当于同一个方法定义了不同的名字。
 * 一直以来都只是在对象上发现引用的身影,而对象引用的特点:不同的对象引用可以操作同一块内存地址
 * 方法引用在Java8之中一共定义了四种形式：
 *  1、引用静态方法：类名称 :: static方法名称
 *  2、引用某个对象的方法：实例化对象 :: 普通方法
 *  3、引用特定类型的方法： 特点类 :: 普通方法
 *  4、引用构造方法： 类名称 :: new.
 */

/**
 * 实现方法的引用接口
 * @param <P>  引用方法的参数类型
 * @param <R>  引用方法的返回类型
 */
//* 1、功能性接口(Function)：public Interface Function<T,R>{public R apply(T t);}
@FunctionalInterface
interface IM1<P,R>{
    public R zhuanhuan(P p);
}
@FunctionalInterface
interface IM2<P>{
//    public int compare(P p1);   //@1.实现比较方法的传递compareTo
    public int compare(P p1,P p2);   //@2.实现比较方法的传递compareTo

}
//* 3、供给型接口(Supplier): public Interface Supplier<T>{public T get();}
@FunctionalInterface   //此为函数式接口,只能够定义一个方法
interface IM3<R>{
    public R upper();
//    public R get();  //如果增加一个方法,会提示：xxxx is not a functional interface
}
@FunctionalInterface   //此为函数式接口,只能够定义一个方法
interface IM4<C>{
    public C create (String t,double p);
}

class Bo{
    private String title;
    private double price;
    Bo(String title,double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名:" + this.title + "\t价格:" + this.price;
    }
}
public class Java_NewFeather8_Method_Reference {
    public static void main(String[] args) {
        /**@一* /
        //即：将String.valueOf()方法变为了IMessage 接口里的zhuanhuan()方法,valueOf（）是将其他类型转换为String类型   //public static String valueOf(数据类型 data)
        IM1<Integer,String> mgs = String :: valueOf;   //引用静态方法：类名称 :: static方法名称
        String temp = mgs.zhuanhuan(1000); //从另一方面说实现了接口的方法,也是对接口的一个增强
        System.out.println(temp.replace("0","9"));
        System.out.println("---------------------------");
        /**@二*/
        //public String toUpperCase()
        //toUpperCase()这个方法没有参数，并且这个方法一定要在有实例化对象的情况下才可以调用
        IM3<String> mgs1 = "Hello" :: toUpperCase;   // 引用某个对象的方法：实例化对象 :: 普通方法   //public String toUpperCase()
        String temp1 = mgs1.upper();
        System.out.println(temp1);
        //如果要实现函数的引用,那么必须要有接口（并且接口里面只能存在有一个方法）。为了保证被引用接口里面只能够有一个方法,那么就需要增加一个注解的声明@FunctionalInterface
        //----------------------------------------------------------------------------------------------------------------------------------------
        /**@正常情况下如果使用了"类 :: 方法“,引用的一定是类中的静态方法,但是这种形式也可以引用普通方法。（特殊：需要特定类的对象支持）
         */
        /**@三*/
        //public int compareTo(String anotherString):比较形式：字符串1.comparetTo(字符串 2 对象)
//        IM1<Integer,String> mgs2 = String :: compareTo;  //Fail  不能引用 compareTo不是静态方法
//        IM2<String> mgs2 = "Hlelo"::compareTo;    //@1 Yes，但是需要实际硬编码“Hlelo"
//        System.out.println(mgs2.compare("Hlelo"));
        IM2<String> mgs2 = String :: compareTo;
        //与之前相比,方法引用前不再需要定义对象，而是可以理解为将对象定义在了参数上
        System.out.println(mgs2.compare("A","B"));
        /**@四*/
        //----------------------------------------------------------------------------------------------------------------------------------------
        System.out.println("---------------------------");
        //调用的虽然是create(),但是这个方法引用的是Bo类的构造
        IM4<Bo> mgs3 = Bo :: new;
        Bo bo = mgs3.create("Java开发",79.1);
        System.out.println(bo);
    }
}
