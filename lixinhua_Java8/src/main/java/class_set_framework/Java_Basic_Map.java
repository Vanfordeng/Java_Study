package class_set_framework;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Doctor on 2016/12/13.
 * Map
 * Collection每一次都指挥保存一个对象,而Map主要是负责保存一对对象的信息。
 */
public class Java_Basic_Map {
    public static void main(String[] args) {
        /**
         * public interface Map<K,V>
         * since:JDK1.2
         * 如果说现在要保存一对关联数据（key = value）的时候,那么如果直接使用Collection就不能直接满足于要求.
         * 可以使用Map接口实现此类数据的保存,并且Map接口还提供有根据key查找value的功能。
         * 在Map接口里面定义有如下常用的方法：
         * 向集合中保存数据： public V put(K key,V value)
         * 根据Key查找Value: public V get(Object key)
         * 将Map集合转换为Set集合： public Set<Map.Entry<K,V>> entrySet()
         * 取出全部的key(返回值是Set,key不能重复): public Set<K> keySet()
         * 在Map接口下有两个常用子类：HashMap、Hashtable
         */
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put(null,0);  //key数据重复，后面的数据会覆盖前面的数据
        System.out.println(map);
        //Todo 只要带有Hash的都是无序操作，Map也是无序存放的的。
        //{A=4, B=2, C=3}
        /**
         *@使用HashMap定义的Map集合是无序存放的（顺序无用）
         *@如果发现出现了重复的key会进行覆盖,使用新的内容替换掉旧的内容
         */
        //在Map接口里面提供有get()方法,这个方法主要的功能是根据key查找说需要的value.
        System.out.println("--------特殊key查询--------------");
        System.out.println(map.get("A"));  //可以查找到值：1
        System.out.println(map.get("D"));  //可以查找到值：null
        System.out.println(map.get(null)); //可以查找到值：0
        /**@Map的主要方法：put(),get()        Collection的主要方法：add(),iterator()
         * @Map存放数据的最终目的实际上就是为了信息的查找，但是Collection存放数据的目的是为了输出。
         * @Map存放数据的最终目的实际上就是为了信息的查找，但是Collection存放数据的目的是为了输出。
         */
        System.out.println("--------取得所有的key--------------");
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
//        System.out.println("--------将Map集合转换为Set集合--------------");
//        Set<Map.Entry<String,Integer>> set1 = map.entrySet();
//        Iterator<Map.Entry<String,Integer>> iterator1 = set1.iterator();
//        while (iterator1.hasNext()){
//            Map.Entry<String,Integer> entry = iterator1.next();
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
        //在Map接口下还有一个Hashtable的子类,此类在JDK1.0的时候提供的，属于最早的Map集合的实现操作
        //在JDK1.2的时候让其多实现了一个Map接口,从而保存下来继续使用。
        System.out.println("----------------使用HashTable----------");
        Map<String,Integer> map_hashtable = new Hashtable<String,Integer>();
        map_hashtable.put("A",1);
        map_hashtable.put("B",2);
        map_hashtable.put("C",3);
//        map_hashtable.put(null,0);  //如果Key或者Value为null，就不能输出
//        map_hashtable.put("",null);
        System.out.println(map_hashtable);
        //Todo 现在发现Hashtable里面对于key和value的数据都不允许设置为null
        //Todo 面试题：请解释HashMap和Hashtable的区别：
        /**
         *                  Hashtable（10%）                                  HashMap（90%）
         * 推出时间         JDK1.0                                            JDK1.2
         * 性能             采用同步处理                                     采用异步处理
         * 数据安全         线程安全                                         非线程安全
         * 输出          不允许key或者value内容为null                  允许key或者value内容为null
         */
        //Todo 而实习的使用之中,遇见Map接口基本就使用HashMap类

        //Todo 关于Map使用Iterator输出的问题（核心）
        //在之前强调过,只要是集合的输出那么一定要使用Iterator完成,但是在整个Map接口里面,并没有定义任何可以返回Iterator接口对象的方法
        //所以如果下面如果想要使用Iterator输出Map集合,首先必须要针对于Map集合与Collection集合保存数据的特点进行分析后才能够实现。
        //Todo 每当用户使用put()方法向Map集合里面保存一对数据的时候,实际上所有的数据都会被自动的封装为Map.Entry接口（内部接口）对象
        //Todo 那么来观察Map.Entry接口的定义：
        // public static interface Map.Entry<K,V>  //使用static定义的内部接口就是外部接口
        // 在这个接口里面定义了两个方法：
        //public K getKey()         取得key
        //public V getValue()       取得value
        //在Map里面提供有一个将Map集合转换为Set集合的方法： public Set<Map.Entry<K,V>> entrySet()
        /**@Map集合利用Iterator接口输出的步骤：
         * 1.利用Map接口的entrySet()方法将Map结合变为Set结合,里面的泛型是Map.Entry<K,V>
         * 2.利用Set集合中的iterator()方法将Set集合进行Iterator输出
         * 3.每一次Iterator循环取出的都是Map.Entry接口对象,利用此对象进行key和value的取出。
         */
        System.out.println("--------将Map集合转换为Set集合--------------");
        //将Map集合变为Set集合,目的是为了使用iterator（）方法
        Set<Map.Entry<String,Integer>> set1 = map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            Map.Entry<String,Integer> entry = iterator1.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
       //Todo 关于Map结合中key的说明
        //在使用Map接口的时候可以发现,几乎可以使用任意的类型来作为key或value的存在,那么也就表示也可以使用自定义的类型作为key
        //那么这个作为自定义的类必须要覆写Object类之中的hashcode()和equals方法.因为要判断自定义类型作为key时，对象是否相等.
        //在以后使用Map集合的时候,首选key的类型是String，尽量不要使用自定义类型作为key.
        System.out.println("-------------关于Map结合中key的说明-------------");
//        Map<String,Book2> map_book = new HashMap<String,Book2>();
//        map_book.put(new String("Java"),new Book2("Java开发"));
//        map_book.put(new String("C#"),new Book2("C#开发"));
//        System.out.println(map_book.get(new String("Java")));   //输出:Java开发
        Map<Book2,String> map_book = new HashMap<Book2,String>();
        map_book.put(new Book2("Java开发"),new String("Java"));
        System.out.println(map_book.get(new Book2("Java开发"))); //在Book重载Object中的hashCode()和equals()方法之前，输出：null.  重载后输出:Java
    }

    /**Todo 总结
     * 1.Map集合保存数据的目的是为了查询用，而Collection保存数据目的是为了输出用
     * 2.Map使用Iterator接口输出的步骤以及具体实现代码
     * 3.HashMap可以保存null,Hashtable不能
     */
}

class Book2{
    private String title;
    public Book2(String title){
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book2 book2 = (Book2) o;

        return title != null ? title.equals(book2.title) : book2.title == null;

    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "书的名称：" + this.title;
    }
}