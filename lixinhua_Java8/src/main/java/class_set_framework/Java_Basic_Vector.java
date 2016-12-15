package class_set_framework;

import java.util.List;
import java.util.Vector;

/**
 * Created by Doctor on 2016/12/13.
 * Vector:在JDK1.0的时候就已经提供有Vector类,并且这个类被大量的使用。
 * 但是到了JDK1.2的时候,由于类集框架的引入，所以对整个集合的操作就有了新的标准，那么为了继续保留下Vector类,所以让
 * 这个类多实现了一个List接口。
 * public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
 * public void addElement(E obj)
 * public boolean add(E e)
 */
public class Java_Basic_Vector {
    public static void main(String[] args) {
        List<String> list = new Vector<String>();
        //Todo 如上代码就把ArrayList换成了Vector，结果完全一样.因为我们所有的操作都是以接口为主的,接口就定义了用户操作
        //Todo 的标准是一样的
//        List<String> list = new ArrayList<String>();
        System.out.println("长度：" + list.size() + "是否为空：" + list.isEmpty());
        list.add("Hello");
        list.add("World");
        list.add("Nihao");
        list.add("All");
        System.out.println("长度：" + list.size() + "是否为空：" + list.isEmpty());
        //Collection接口定义size()方法可以取得集合参股
        //List子接口扩充了一个get()方法，可以根据索引取得数据(Set方法因为没有get()方法，操作形式不同)
        for (int i = 0; i < list.size() ; i++) {
            String str = list.get(i);
            System.out.println(str);
        }
        //Todo 面试题 请解释ArrayList 与Vector的区别
        /**
         *                  Vector（10%）                                  ArrayList（90%）
         * 推出时间         JDK1.0                                           JDK1.2
         * 性能             采用同步处理                                     采用异步处理
         * 数据安全         线程安全                                         非线程安全
         * 输出 Iterator、ListIterator、foreach、Enumeration          Iterator、ListIterator、foreach
         */
    }
}
