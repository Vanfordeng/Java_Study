package class_set_framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Doctor on 2016/12/14.
 * 1.离不开Lamda表达式
 * 2.方法引用，四个函数式接口
 * 3.如何使用Stream数据流进行集合的辅助操作，MapReduce的使用过程。
 */
public class Java_Basic_Stream {
    public static void main(String[] args) {
        /**@在JDK1.8开始发现整个类集里面说提供的接口都出现了大量的default或者是static方法，以Collection的父接口Iterable接口来里面定义的一个方法来观察：
         * default void forEach(Consumer<? super T> action)
         *     //Consumer<String> consumer = new MyDemo() :: print;   //参考Java_NewFeather8_Builtin_function_interface。其中Consumer<String> consumer;的实例化对象为：new MyDemo::print.所以forEach()方法接收的数据类型为：
         *     //Consumer<? super T> action,action的实例化可以设置为：System.out::println（此处正好是消费型Consumer，是一个消费型的操作，的方法的引用）
         *     consumer.accept("Hello World!");
         */
        //Todo 利用forEach()方法输出
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        //System.out.println(String str);  //消费型接口模式：接收一个参数,无返回值
        list.forEach(System.out :: println);
        //这个输出A B C D，效果相当于Iterator实例化输出后,循环取得每个对象内容输出的形式。
        //但是多数情况下还是使用Iterator,而不会采用 以上的方式完成,因为forEach()只能够实现输出，但是很多时候我们在进行集合数据输出的同时
        //还需要对集合数据做一些其它的处理。也就是说Iterator输出使我们主要使用的方式。
        /**@除了使用Iterator迭代取出数据并且处理之外,在JDK1.8里面又提供了一个专门可以进行数据处理的类：Stream
         * 这个类的对象可以利用Collection接口提供的方法操作：
         * default Stream<E> stream()。
         */


    }
}
