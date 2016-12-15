package class_library;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Doctor on 2016/11/3.
 * 挽救的比较器：Comparator
 * 由于初期的设计并没有安排此类的对象数组的排序，而后又突然需要实现对象数组的排序，在不能修改Book类定义的情况下是不可能使用Comparable接口的。
 * 在Java里面为了解决这样的问题。就提供了java.util.Comparator
 * Since JDK1.2
 * @FunctionalInterface
 * public interface Comparator<T>{public int compare(T o1,T o2);
 *                                boolean equals(Object obj)；}
 * 真正要实现的只有compare()方法,需要单独准备出一个类来实现Comparator,这个类将作为我们指定类的排序类
 *
 */

class Book2{
    private String title;
    private double price;

    public Book2(String title,double price){
        this.title =  title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + "价格：" + this.price + "\n";
    }
}
class childBook extends Book2{
    public childBook(String title, double price) {
        super(title, price);
    }   //Todo 因为Book2没有默认构造函数,所以childBook必须调用super的构造函数

}
//  真正要实现的只有compare()方法,需要单独准备出一个类来实现Comparator的工具类,这个类将作为我们指定类的排序类
class BookComparator implements Comparator<childBook>{

    @Override
    public int compare(childBook o1, childBook o2) {
        if (o1.getPrice() > o2.getPrice()){
            return 1;
        }else if (o1.getPrice() < o2.getPrice()){
            return -1;
        }else {
            return 0;
        }
    }
}


public class Java_lib_Comparator {
    public static void main(String[] args) {
        Book2[] book2s =  new Book2[]{
                new Book2("Java开发",102.2),
                new Book2("ASP开发",133.2),
                new Book2("C#开发",101.2),
                new Book2(".NET开发",112.2),
        };

        childBook[] childBooks =   new childBook[]{
                new childBook("Java开发",102.2),
                new childBook("ASP开发",133.2),
                new childBook("C#开发",101.2),
                new childBook(".NET开发",112.2),
        };

        //使用Comparator实现的工具排序类需要用到Arrays.sort()的一个重载方法：
        //public static <T> void sort(T[] a,Comparator<? super T> c)  //Todo:这个是对Comparator<? super T>的泛型设置了下限,并不是对T[] a 参数
        BookComparator comparator = new BookComparator();
       // Arrays.sort(book2s,comparator);   //用子类的比较器去比较父类的属性,这样不好.所以设置了下限。此处有编译错误：Interface variable T has incompatible bounds(接口变量T具有不兼容的边界)
        Arrays.sort(childBooks,comparator);
        System.out.println(Arrays.toString(book2s));
        System.out.println("-----------------------------");
        System.out.println(Arrays.toString(childBooks));
        //Todo 面试题：请比较Comparable和Comparator的区别
        /* 如果对象数组要进行排序那么必须设置排序规则，可以使用Comparable或Comparator接口实现.都是使用Arrays.sort()方法来调用
         *java.lang.Comparable是在一个类定义的时候实现好的接口，这样本来的对象数组就可以进行排序，在Comparable下定义有一个public int compareTo(T o)方法
         * java.until.Comparator是专门顶一个指定类的比较规则,属于挽救的比较操作，里面有两个方法：public int compareTo(T o1,T o2)和public boolean equals(Object obj)
         */
    }
}
