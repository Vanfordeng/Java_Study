package com.study_java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by Doctor on 2016/10/31.
 * @对于方法的引用,严格来讲都需要定义一个接口,可是不管如何操作,实际上有可能操作的接口只有四种，在JDK1.8中提供了一个包：java.util.function
 * 1、功能性接口(Function)：public Interface Function<T,R>{public R apply(T t);}
 *   |--此接口需要接受一个参数，并且返回一个处理结果
 * 2、消费型接口(Consumer): public Interface Consumer<T>{public void accept(T t);}
 *   |--此接口只是负责接受数据（引用数据是不需要返回），并且不返回结果
 * 3、供给型接口(Supplier): public Interface Supplier<T>{public T get();}
 *   |--此接口不接受参数,但是可以返回结果
 * 4、断言型接口：public interface Predicate<T>{public boolean test(T t);}
 *   |--进行判断操作使用
 *   所有在JDK1.8之中由于存在有以上的四个功能型接口，所有用户很少会去自己定义函数式接口
 */

class MyDemo{
    public void print(String str){
        System.out.println(str);
    }
}
public class Java_NewFeather8_Builtin_function_interface {
    public static void main(String[] args) {
        //功能性接口(Function)：public Interface Function<T,R>{public R apply(T t);}
        // public boolean startsWith(String prefix);
        // public static String valueOf(Object obj)
        Function<String,Boolean> function =  "##hello":: startsWith;
        Function<Integer,String> function1 = String :: valueOf;
        System.out.println(function.apply("##"));
        System.out.println(function1.apply(1000) + 1);
        System.out.println("-----------------------------------------------------------------------");

        //消费型接口(Consumer): public Interface Consumer<T>{public void accept(T t);}
        // public void print(String str)
        Consumer<String> consumer = new MyDemo() :: print;
        consumer.accept("Hello World!");
        System.out.println("-----------------------------------------------------------------------");

        //供给型接口(Supplier): public Interface Supplier<T>{public T get();}
        // public String toUpperCase()
        Supplier<String> supplier = "hello" :: toUpperCase;
        System.out.println(supplier.get());
        System.out.println("-----------------------------------------------------------------------");

        //断言型接口：public interface Predicate<T>{public boolean test(T t);}
        //  public boolean equalsIgnoreCase(String anotherString)
        Predicate<String> predicate =  "hello" :: equalsIgnoreCase;
        System.out.println(predicate.test("hello1"));
        System.out.println("-----------------------------------------------------------------------");

        /**@这几个接口包含了所有可能出现的方法引用，也是函数式接口的代表,但是有许多的函数式接口与它类似,参见：java.util.function*/
    }
}
