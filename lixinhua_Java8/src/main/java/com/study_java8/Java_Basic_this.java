package com.study_java8;

/**
 * Created by Doctor on 2016/10/8.
 */
public class Java_Basic_this {
    public static void main(String[] args){
        //在Java里面,利用this关键字可以实现类属性的调用，类方法的的调用，表示当前对象
        //Java程序是以“{}”为界限，如果现在属性名称和参数名称出现重名的情况下,那么默认情况下如果没有加入任何的限制
        //指的都是最近的“{}”内的变量名称。
        //在以后的程序开发当中,只要是访问类中的属性前面都必须加上“this."
        Book2 book =  new Book2("Java开发",12.5);
        System.out.println(book.getInfo());

        /*使用“this()"调用构造方法形式的代码只能放在构造函数的首行；
         *进行构造方法互相调用的时候,一定要保留调用的出口，也就是说使用this()互相调用构造函数的时候
         * 请至少保留一个构造没有使用this()调用其他构造函数
         */

        //this表示当前对象：“this.属性"实际上就是属于当前对象中的属性,一定是堆内存保存的内容。
    }
}
class Book2{
    private String title;
    private double price;
    public Book2(){
        System.out.println("一本新的书籍");
    }
    public Book2(String title,double price){
        this();
        this.title = title;
        this.price = price;
    }
    public String getInfo(){
        return "书名：" + this.title + "\t 价格：" + this.price;
    }
}
