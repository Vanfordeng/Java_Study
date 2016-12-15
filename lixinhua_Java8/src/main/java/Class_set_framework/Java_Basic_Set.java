package class_set_framework;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Doctor on 2016/12/13.
 * 在Collection接口下又有另外一个比较常用的子接口Set接口（20%）
 * Set接口并不像List接口那样对于Collection接口进行了大量的扩充，而是简单的继承了Collection接口.
 * 也就是说Set里面没有get()方法。
 * Set接口下有两个常用的子类：HashSet、TreeSet
 *
 */
class Book1{
    private String title;
    private double price;
    public Book1(String title,double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书的名称：" + this.title + "\t书的价格：" + this.price;
    }

//    @Override
//    public int compareTo(Book1 o) {
//        if (this.price > o.price){
//            return  1;
//        }else if (this.price < o.price){
//            return -1;
//        }else {
//            return this.title.compareTo(o.title); //调用了String的CompareTo()方法，比较大小。但是如果有7、8个属性
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book1 book1 = (Book1) o;

        if (Double.compare(book1.price, price) != 0) return false;
        return title != null ? title.equals(book1.title) : book1.title == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
public class Java_Basic_Set {
    public static void main(String[] args) {
        //观察HashSet子类的特点
        /**
         * @Set集合下没有重复元素（这一点与List不同，是Set接口的特征）,同时发现在里面保存的数据是没有任何顺序的。
         * @即：HashSet子类的特征属于无序排列
         */
        Set<String> set = new HashSet<String>();
        set.add("Nihao");
        set.add("Nihao");  //重复数据
        set.add("Hello");
        set.add("World");
        System.out.println(set);
        //[Hello, Nihao, World]  无顺序输出

        //观察TreeSet子类的特点
        /**
         * @使用TreeSet子类,发现没有重复数据，以及所保存的内容自动排序.
         */
        Set<String> tree_Set = new TreeSet<String>();
        System.out.println("------------TreeSet--------------");
        tree_Set.add("X");
        tree_Set.add("C");
        tree_Set.add("X"); //重复数据
        tree_Set.add("B");
        System.out.println(tree_Set);
        //[B, C, X] 有序输出，按照字母排序了
        //Todo 关于数据排序的说明
        //Todo 既然TreeSet子类保存的内容可以进行排序，那么我们不如就编写一个自定义的类来完成数据的保存
        //Todo 集合就是一个动态的对象数组,那么如果要想为一组对象进行排序，在Java里面必须要使用比较器Comparable完成比较，在比较方法CompareTo()里面需要将这个类的所有属性都一起参与到比较之中。
        //Todo 通过检查可以发现TreeSet类主要是依靠Comparable接口中的CompareTo（）方法判断是否是重复数据,如果返回的是0,那么它
        //Todo 就认为是重复数据，不会被保存。所以在比较方法里面需要将这个类的所有属性都一起参与到比较之中。
        System.out.println("------------TreeSet_Book1--------------");
       // Set<Book1> book1Set = new TreeSet<Book1>();
        Set<Book1> book1Set = new HashSet<Book1>();   //如果在定义了Comparable接口后把TreeSet换为HashSet()。会出现数据重复的情况。
        //[书的名称：APS开发	书的价格：78.8, 书的名称：Java开发	书的价格：79.8, 书的名称：C#开发	书的价格：77.8, 书的名称：Java开发	书的价格：79.8, 书的名称：Android开发	书的价格：79.8]
        //Todo 关于重复元素的说明
        //Todo 很明显,Compareable接口只能负责TreeSet子类进行重复元素的判断,它并不是真正的用于能够进行重复元素验证的操作（在排序的情况下使用）
        //Todo 如果要想判断重复元素那么只能够依靠Object类中说提供的两个方法：第一步：根据HashCode()取得对象内容,第二部：使用equals比较两个对象内容是否一致
        //Todo |-:取得哈希码：public int hashCode()
        //   1. |-先判断对象的哈希码是否相同,依靠哈希码取得一个对象的内容
        //Todo |-:对象比较：public boolean equals(Object obj)
        //   2. |-：再将对象的属性进行一次的比较
        book1Set.add(new Book1("Java开发",79.8));
        book1Set.add(new Book1("Java开发",79.8)); //全部信息重复
        book1Set.add(new Book1("Android开发",79.8)); //部分信息重复
        book1Set.add(new Book1("APS开发",78.8));  //都不重复
        book1Set.add(new Book1("C#开发",77.8));   //都不重复
        System.out.println(book1Set);
        //[书的名称：C#开发	书的价格：77.8, 书的名称：APS开发	书的价格：78.8, 书的名称：Java开发	书的价格：79.8]  //只有一个79.8

        //Todo 以后在非排序的情况下,只要是判断重复元素依靠的永远都是hashCode()和equals()

        //Todo 在开发智障,Set接口绝对不是首选，如果真要使用也建议使用HashSet子类（因为这个子类不太需要实现排序功能）
        //Todo Comparable这种比较器大部分情况下指挥存在于Java理论范畴内，例如：要进行TreeSet排序
        //Todo Set不管如何操作,必须始终保持一个前提：数据不能够重复
    }
}
