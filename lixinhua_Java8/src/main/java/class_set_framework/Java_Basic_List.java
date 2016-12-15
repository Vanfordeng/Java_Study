package class_set_framework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Doctor on 2016/12/12.
 * 使用List子接口验证Collection接口中所提供的操作方法
 * 掌握List子接口的操作特点以及常用子类（ArrayList，Vector）
 * List子接口是Collection中最为常用的一个子接口，但是这个接口对Collection接口进行了一些功能的扩充
 * 在List子接口里面重点要掌握如下方法：
 * Todo public E get(int index)  获取指定索引的内容，索引编号从0开始
 * public E set(int index,E element) 修改指定索引编号的内容
 * public ListIterator<E> listIterator() 为ListIterator接口实例化
 * 而List本身是接口，所以如果想要使用此接口进行操作,那么久必须存在有子类,可以使用ArrayList子类进行实例化操作,（还有一个Vector子类
 * 90%的情况下选择的是ArrayList）
 */
class Book{
    private String title;
    private double price;
    public Book(String title,double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "书的名称：" + this.title + "\t书的价格：" + this.price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return  true;
        }
        if (obj == null){
            return  false;
        }
        if (!(obj instanceof Book)){
            return  false;
        }
        Book o = (Book) obj;
        if (this.title.equals(o.title) && this.price == o.price){
            return true;
        }else{
            return  false;
        }
    }
}

public class Java_Basic_List {
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

        //在集合里面保存对象
        List<Book> list_book = new ArrayList<Book>();
        list_book.add(new Book("Java开发",79.8));
        list_book.add(new Book("ASP开发",76.8));
        list_book.add(new Book("C#开发",78.8));
        //任何情况下集合数据的删除与内容的查询都必须提供有equals()方法
        list_book.remove(new Book("C#开发",78.8));
        System.out.println(list_book);
        //与我们之前的链表相比,几乎是横向替代就是替代了一个类名称而已,因为给出的链表就是按照Collection与List接口的标准方法定义的。
    }
}
