package com.study_mars.Collection_eg;

/**
 * Created by Doctor on 2016/9/6.
 */

/**
 *  Set，List继承：Collection 接口.Map不继承Collection接口，单独的一个接口
 * 集合Set：中的对象不按特定的方式排序,并且没有重复对象----装双色球的箱子
 * 列表List：中对象按照索引位置排序，可以有重复的对象 ----
 * 映射Map:中每一个元素包含一个键对象和一个值对象，键不可以重复，值可以重复 ----键值对
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * boolean add(Object o) 先集合中加入一个对象
 * void clear() 删除集合当中的所有对象
 * boolean isEmpty 判断集合是否为空
 * remove(object o) 从集合中删除一个对象的引用
 * int size()  返回集合中元素的数目
 */
public class Collection_eg {
    public  static void main(String[] args){
//        HashSet<String> hashSet = new HashSet<String>();
//        Set<String> set= hashSet;
        //向上转型为Set.通常在程序中间对象向上转型来使用
//        List是集合最大的父类，它包含了ArrayList。
//        如果直接声明为ArrayList<String> list=new ArrayList<String>()这个也没有问题。
//        而声明成:List<String> list=new ArrayList<String>();这样的形式使得list这个对象可以有多种的存在形式，比如要用链表存数据的话直接用LinkedList，使用ArrayList或者Vector直接通过list去=就可以了，这样让list这个对象活起来了，“有甚麼大问题呢？只不过是多一行code而已。”
//        其实不止多一行代码，很多需求只能用一个list，内存有限，或者线程同步，不能有更多的集合对象，使得List总的接口来管理对象。
//        楼主可以看看接口的相关概念，java设计接口就是为了这种需求
        //<String>参数化Set。泛型
        Set<String> set =  new HashSet<String>();
//        set.add("abc");
//        set.clear();  //clear之后,size为0
//        set.isEmpty();
//        set.remove(0);
//        set.size();
        set.add("b");
        set.add("d");
        set.add("a");
        set.add("c");
        set.add("c");

        //i的值为4.set中不能有重复元素.会自动过滤掉
        int i = set.size();
        System.out.println(i);
        //集合中的数据没有顺序,无法用set[i]来获取，需要用Iterator迭代器。Collection继承Iterator接口
        //Iterator < -- Collection <--Set <-- HashSet
        /**
         * Iterator中的方法：
         * hasNext()   next()
         */
        //调用Set对象的Iterator方法，会生成一个迭代器对象，该对象用于遍历整个Set
        Iterator<String> it = set.iterator();
//        it.hasNext();
        //next返回当前游标的下一个元素
//        it.next();
        while (it.hasNext()){
            String s = it.next();
            //TODO 为什么Set 输出的数据默认为：a,b,c,d,（有顺序）
            System.out.println(s);
        }
    }
}
