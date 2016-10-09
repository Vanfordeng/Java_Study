package com.study_java8.this_eg;

/**
 * Created by Doctor on 2016/10/8.
 */
public class Java_Basic_Reference {
    //如果引用传递不清楚,那么几乎可以认为不会Java
    //引用传递的核心意义：同一块堆内存空间可以被不同的栈内存所指向，不同栈内存可同时对同一块堆内存内容的修改
    public static void main(String[] args){
        //1.....
        Message msg =  new Message(30);
        fun(msg); //引用传递
        System.out.println(msg.getNum());
        //2.....
        System.out.println();
        String str = "Hello";
        fun(str);
        System.out.println(str);
        //3.....

        System.out.println();
        Message mgs1 = new Message("Hello");
        fun(mgs1);
        System.out.println(mgs1.getInfo());
        //结论：虽然String属于类,属于引用类型,但是由于其内容不可改变的特点,很多的时候就直接把String当成基本数据类型那样使用就玩了。
        //也就是说：每一个String变量只能保持一个数据
    }
    public static void fun(Message temp){
        temp.setNum(100);
        temp.setinfo("world");
    }
    public static void fun(String temp){
        //字符串的内容不可改变
        temp = "world";
    }


}
class Message{
    private int num = 10;
    private String info = "nihao";
    public Message(String info){
        this.info = info;
    }
    public void setinfo(String info){
        this.info = info;
    }
    public String getinfo(){
        return this.info;
    }
    public Message(int num){
        this.num = num;
    }
    public int getNum(){
        return this.num;
    }
    public void setNum(int num){
        this.num = num;
    }
    public String getInfo(){
        return "num:" + this.num + "info: " + this.info;
    }
}
