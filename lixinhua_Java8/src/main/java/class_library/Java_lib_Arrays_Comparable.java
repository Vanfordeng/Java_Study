package class_library;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Doctor on 2016/11/3.
 * Arrays类：public class Arrays extends Object
 * java.util.Arrays.sort()可以实现数组排序
 * @Arrays类就是java.util包中提供的一个工具类，主要完成所有与数组有关的操作功能。
 * Since JDK1.2
 * 方法：
 * 二分查找：public static int binarySearch(数据类型[] a,数据类型 key)。但是如果要进行二分查找，必须有一个前提
 * 就是数组必须是排序后的内容
 * 比较：要想判断数组是否相同，需要顺序完全一致：public static boolean equals(数据类型[] a,数据类型[] a2)这和Object的equals没有任何关系(或者可以说是重载)
 * 填充数组：public static void fill(数据类型[] a,数据类型 val)
 * @将数组变为字符串输出：public static String toString(数据类型[] a)
 * @对象数组排序：public static void sort(Object[] a)
 */
class Book1 implements Comparable<Book1>{  //实现比较
    private String title;
    private double price;
    public Book1(String title,double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + "\t书价：" + this.price + "\n";
    }

    @Override
    public int compareTo(Book1 o) {   //Arrays.sort()会自动调用此方法
        if (this.price > o.price){
            return 1;                      //1和-1可以控制升序或者降序
        }else if (this.price < o.price){
            return -1;
        }else {
            return 0;
        }
    }
}
public class Java_lib_Arrays_Comparable {
    public static void main(String[] args) {
        int[] data = new int[]{9,1,2,5,6,8,0,7,3,12,11,10};
        Arrays.sort(data);
        System.out.println(data);
        System.out.println(Arrays.binarySearch(data,9));
        System.out.println("------------------------");
        int[] d1 = new int[]{1,2,3};
        int[] d2 = new int[]{1,2,3};
        System.out.println(Arrays.equals(d1,d2));
        System.out.println("------------------------");
        int[] d4 = new int[10];
        Arrays.fill(d4,3);
        System.out.println(Arrays.toString(d4));
        System.out.println("------------------------");

        Book1[] book1 = new Book1[]{
                new Book1("Java开发",101),
                new Book1("APS开发",99),
                new Book1("Python开发",93),
                new Book1("C#开发",99),
        };
        System.out.println(Arrays.toString(book1));
        /*todo 分析Comparable：每一个对象设计只保存有地址信息,地址里面所有内容的,所以如果是普通的int型数组要进行比较,只需要比较大小就够了
         *todo 但是如果是对象数组,里面包含的如果只是编码（地址）比较是没有意义的。应该按照价格排序才有意义，所以此处必须要明确的设置出比较的规则
         *todo 比较的规则就是由Comparable接口定义的，此接口定义如下：
         * public interface Comparable<T>{public int compareTo(T o);}
         * String类的定义：public final class String extends Object implements Serializable, Comparable<String>, CharSequence
         * String类就是Comparable接口的子类,之前使用compareTo()方法就是比较的操作功能，如果要比较对象：建议compareTo()返回三类数据：
         * 1（大于）、0（等于0）、-1（小于）
         */
        Arrays.sort(book1);  //java.lang.ClassCastException: class_library.Book1 cannot be cast to java.lang.Comparable
        System.out.println(Arrays.toString(book1));

        //todo Comparable接口中的compareTo()方法是由Arrays.sort()调用，所以只需要实现接口并调用方法即可。
        //Todo 总结：以后不管何种情况下,只要一组对象要排序,对象所在的类一定要实现Comparable接口
    }
}
