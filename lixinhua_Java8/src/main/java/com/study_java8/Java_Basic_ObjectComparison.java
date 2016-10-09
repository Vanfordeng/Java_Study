package com.study_java8;

/**
 * Created by Doctor on 2016/10/9.
 */
class Book4{
    private String title;
    private double price;

    public Book4(String  title,double price){
        this.title = title;
        this.price = price;
    }
    //本类接收本类对象，对象可以直接访问属性，不需要使用getter,setter
    //两个功能：1.带回了需要比较的信息。2.可以直接访问类的属性
    /*
     * 由于Java是先编译后执行,在执行compare方法时候,已经存在Book4类的class文件.所以形式参数可以正常使用Book4.class
     */
    public boolean compare(Book4 book){
        //执行 “b1.compare(b2)"代码是会有两个对象
        //当前对象this(调用方法对象，就是b1引用)
        //传递的对象book(引用传递，就是b2引用)
        if (book ==  null){  //没有必要进行具体细节的比较
            return false;
        }
        if (this == book){  //内存地址相同
            return true;    //避免进行具体细节的比较,节约时间
        }
        //
        if (this.title.equals(book.title)&&this.price == book.price){
            return true;
        }else {
            book.title = "邓启红的JAVA开发书";  //可以通过对象.属性直接修改属性内容
            return false;
        }

    }
    public String getTitle(){
        return  this.title;
    }
    public double getPrice(){
        return this.price;
    }
}
public class Java_Basic_ObjectComparison {
    //要判断一个自定义的类的对象是否相等，那么必须要实现类对象当中所有属性内容的比较
    //对象 = 数据集合，那么精细比较一定要一次比较所有的属性

    //如果说现在一个类中属性使用private封装了，那么在类的外部不能通过对象直接访问类的属性
    //但是如果说将一个对象传递回到类的方法里面，那么就相当于取消了封装的形式,可以直接通过对象访问属性。
    /////一个类可以接收本类对象
    public static void main(String[] args){
        Book4 book1 = new Book4("Java开发",79.8);
        Book4 book2 = new Book4("Java开发",79.1);
        if (book1.compare(book2)) {
            System.out.println("是同一个对象");
        }else {
            System.out.println("不是同一个对象");
        }
        System.out.println(book1.getTitle());
        System.out.println(book2.getTitle());
    }
}
