package class_set_framework;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;

/**
 * Created by Doctor on 2016/12/13.
 * 集合的输出
 * Collection、List、Set上个接口里面只有List接口是最方便进行输出操作的,所以本次要讲解集合的四种输出形式
 * 集合在JDK1.8之前支持四种输出：Iterator(95%)、ListIterator(0.05%)、Enumeration(4.9%)、foreach(0.05%).
 * 迭代输出:Iterator(核心）
 * 如果遇见集合操作,那么一般都会使用Iterator接口进行集合的输出操作，观察Iterator的定义：
 * public interface Iterator<E>
 * since:JDK1.2
 * public boolean hasNext()
 * public E next()
 * Iterator 本身是一个接口，如果想要取得本接口的实例化只能依靠Collection接口,在Collection接口里面定义有如下一个操作方法：
 * Todo Collection ->: public Iterator<E> iterator()
 * Todo List ->: public Iterator<E> iterator()
 * Todo Set ->: public Iterator<E> iterator()
 */
public class Java_Basic_Output {
    public static void main(String[] args) {
        System.out.println("---------Iterator---");
        Set<String> set = new HashSet<String>();
        set.add("Nihao");
        set.add("hhh");
        set.add("Hello");
        set.add("World");
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()){
            String str = iter.next();
            System.out.println(str);
        }
        //从今以后,只要是遇到集合的输出不需要做任何复杂的思考,直接使用Iterator就可以了。
        //Todo 双向迭代：ListIterator
        /**
         * Iterator本身只具备由前向后输出（99%都是这么做的），但是有些人认为应该让其支持双向输出。即：
         * 可以支持有前向后,也可以实现由后向前。那么就可以使用Iterator的子接口：ListIterator。
         * public interface ListIterator<E> extends Iterator<E>
         * 在这个接口里面主要由两个方法：
         * 判断是否有前一个元素：public boolean hasPrevious()
         * 取得前一个元素：public E previous()
         * 该接口主要服务于List,在List中包含一个实例化listIterator的方法：
         * public ListIterator<E> listIterator()
         */
        System.out.println("---------listIterator---");
        List<String> list =  new ArrayList<String>();
        list.add("Nihao");
        list.add("hhh");
        list.add("Hello");
        list.add("World");
        ListIterator<String> iterator = list.listIterator();
        System.out.println("------由后向前-------");
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous());  //无法输出内容。所以由后向前输出不靠谱
        }

        System.out.println("------由前向后-------");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //Todo 如果要想实现由后向前的输出操作之前,一定要首先发生由前向后的输出才能实现。不然输出的数据为空。

        System.out.println("---------foreach----------");
        //理论上而言,foreach输出还是挺方便的使用。但是如果现在过多的使用foreach不利于理解程序，foreach可以方便的输出数组.
        //但是集合也可以
        for (String str : list){
            System.out.println(str);
        }
        System.out.println("---------Enumeration----------");
        //Todo:Enumeration 是与Vector类一起在JDK1.O的时候推出的输出接口，即：最早的Vector如果要想输出就需要使用
        //Todo：Enumeration接口完成,那么此接口的定义如下：
        /**
         * public interface Enumeration<E>
         * since:JDK1.0
         * 方法：
         * 相当于hasNext,判断是否有下一个元素：public boolean hasMoreElements()
         * 取出当前元素，等同于Next：public E nextElement()
         * 这个接口一定会使用的,而且必须记住方法名称：
         * 但是如果要想取得Enumeration接口的实例化对象只能依靠Vector子类
         * 在Vector中提供有如下方法，取得Enumeration实例化对象
         * public Enumeration<E> elements()
         */
        Vector<String> vector = new Vector<String>();
        vector.add("Nihao");
        vector.add("hhh");
        vector.add("Hello");
        vector.add("World");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
        //在一些古老的操作方法上,此接口依然会使用到，所以必须掌握。
    }
}
