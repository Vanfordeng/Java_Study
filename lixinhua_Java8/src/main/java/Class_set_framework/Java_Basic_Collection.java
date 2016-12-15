package class_set_framework;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Doctor on 2016/12/7.
 * Collection:是整个类集之中单值保存的最大父接口：即:每一次可以向集合里面保存一个对象.
 * Collection的定义：public interface Collection<E> extends Iterable<E>
 * Since:JDK 1.2
 * public interface Iterable<T>
 * Since:JDK 1.5
 * 在Collection接口里面定义有如下的几个常用操作方法：
 * Todo public boolean add(E e)  向集合里面添加方法
 * public boolean addAll(Collection<? extends E> c) 追加一个集合
 * public void clear()  清空集合，根元素为空,再来一个GC
 * public boolean contains(Object o) 判断是否包含某个指定的内容，equals支持
 * public boolean isEmpty()   判断是否是空集合
 * public boolean remove(Object o) 删除对象 equals支持
 * public int size() 取得集合中元素个数
 * public Object[] toArray() 将集合变为对象数组保存
 * Todo public Iterator<E> iterator() 为Iterator接口实例化
 * 在所有的开发之中,add()与iterator两个方法的使用机率是最高的（99%），其他的方法几乎可以忽略。但是必须知道。
 * 但是一定要记住,contains()和remove()一定需要equals的方法的支持
 * 从一般的道理来说,现在已经知道了Collection接口的方法了，就应该使用子类为这个接口实例化,但是现在大开发由于严格
 * 性所以不会再直接使用Collection接口了，而都会去使用它的两个子接口：List,Set。
 *
 * 最早Java刚刚推出类集框架的时候,使用最多的就是Collection接口,最大的使用环境就是EJB上。于是在Java的一个开源项目上--PetShop
 * 就出现了一个问题，由于此项目是属于Java的业余爱好者共同开发的,所以没有过多的考虑性能问题以及代码的数据库设计.就导致了程序的技术
 * 都是很牛的，但是性能都是很差的，于是此时正赶上微软准备退出.net平台。微软使用.net重新设计并开发了PetShop，对外宣布，性能比Java好
 * 人们就开始认为,.net平台性能很高（实际上和Java没什么区别），后来Sun的官方重新编写了petShop,并且发布了测试报告,但是此时的微软的宣传已经进
 * 了,所以基本就已经变成了性能上的差距事实了。
 * 因为代码的规划化的产生，所以从PetShop开始就不在使用模糊不清的Collection接口了,而都使用List或Set子接口进行开发。
 * Todo List允许重复,Set不允许重复
 */
public class Java_Basic_Collection {
    public static void main(String[] args) {
        //ArrayList类是List最为常用的子类
        //设置了泛型,从而保证了集合中所有的数据类型都一致。
//        List<String> list = new ArrayList<String>();
        Collection<String> list = new ArrayList<String>();
        System.out.println("长度：" + list.size() + "是否为空：" + list.isEmpty());
        list.add("Hello");
        list.add("World");
        list.add("Nihao");
        list.add("All");
        System.out.println("长度：" + list.size() + "是否为空：" + list.isEmpty());
        //Collection接口定义size()方法可以取得集合参股
        //List子接口扩充了一个get()方法，可以根据索引取得数据(Set方法因为没有get()方法，操作形式不同)
        for (int i = 0; i < list.size() ; i++) {
//            String str = list.get(i);
//            System.out.println(str);
        }
        //通过演示可以发现,List集合之中所保存的数据是按照保存的顺序存放，而且允许存在有重复数据。但是一定要记住
        //List子接口扩充有get()方法
        //如下：为Collection接口实例化
        //ArrayList是List接口的子类，而List又是Collection子接口，自然可以通过ArrayList给Collection接口实例化
        System.out.println("------为Collection实例化，没有get方法使用toArray读取内容---------");
        Object[] objs = list.toArray();
        for (int i = 0; i < objs.length ; i++) {
            System.out.println(objs[i]);
        }
        //Collection接口与List接口相比,功能会显得有所不足
    }
}
