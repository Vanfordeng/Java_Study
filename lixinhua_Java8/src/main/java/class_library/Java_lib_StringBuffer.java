package class_library;

/**
 * Created by Doctor on 2016/11/2.
 * String 类的特点：
 *   |-- String 类对象有两种实例化方式：
 *          |- 直接实例化：只开辟一块堆内存空间,可以自动入池
 *          |- 构造方法：开辟两块堆内存空间,不会自动入池,使用intern()手工入池。
 *   |-- 任何一个字符串都是String类的匿名对象
 *   |-- 字符串一旦声明则不可改变,可以改变的知识String类对象的引用。
 *   为了解决字符串一旦声明则不可改变的问题,Java 提供了StringBuffer类
 *
 *   public StringBuffer append(数据类型 b)
 */
public class Java_lib_StringBuffer {
    public static void main(String[] args) {
        //String类可以直接赋值实例化,但是StringBuffer类不行
        StringBuffer buffer = new StringBuffer();
        buffer.append("Hello").append(" World").append("!");
        change(buffer);  //引用传递，修改了传递进去的参数buffer的原本的值
        System.out.println(buffer);
    }
    public static void change(StringBuffer temp){
        temp.append("\n").append("Hello MLDN.");
    }

    /**@String类和StringBuffer类的区别：String不可修改,StringBuffer内容可以修改
     * String: public final class String extends Object implements Serializable, Comparable<String>, CharSequence
     * StringBuffer: public final class StringBuilder extends Object implements Serializable, CharSequence
     *@发现String和StringBuffer都是CharSequence接口的子类,而在今后的开发之中，如果你发现在某些方法的操作上出现的是
     * @CharSequence接口,那么应该立刻清楚,只需要传递字符串即可。
     * CharSequence cs = "Hello";   //“Hello"为String的匿名对象向上转型为CharSequence
     * System.out.println(cs);       //调用的是String的toString方法
     * -----------------------------------------------------------------------------------------
     * 将String变为StringBuffer的方法：
     * 1. 方式一：利用StringBuffer类的构造方法：StringBuilder(CharSequence seq)或者StringBuilder(String str)
     * 2. 方式二：利用append()方法，public StringBuilder append(String str)  public StringBuilder append(Object obj)
     *
     * 将StringBuffer类变为String:（任何对象遇到String都变为String类型。因为所有的对象都有toString方法）
     * 1. 方法一：利用toString()方法,可以将StringBuffer类变为String
     * 2. 方法二：利用String类的构造方法：public String(StringBuffer buffer)
     *
     * String 和StringBuffer 内容比较的方法: public boolean contentEquals(StringBuffer sb)
     *
     * String类里面提供了很多方法,StringBuffer类里面也提供了很多方法方便用户的开发(而且和String里的一些没有的方法互补)：
     * 1. public StringBuffer reverse()  翻转
     * 2. public int indexOf(String str,数据类型 fromIndex) //部分插入
     * 3. public StringBuffer delete(int start,int end)  //部分删除
     *
     * 从String和StringBuffer都是在JDK1.O的时候有的，JDK 1.5之后增加了一个新的字符串操作类,StringBuilder,定义如下和StringBuffer类一样
     * public final class StringBuilder extends Object implements Serializable, CharSequence
     * 发现StringBuffer类与StringBuilder类在定义上非常的相似，几乎连方法都一样：
     * Todo 面试题：请解释String、StringBuffer、StringBuilder 声明的内容
     * 1. String的内容一旦声明声明，内容就不可改变.而StringBuffer和StringBuilder什么的内容可以改变
     * 2. StringBuffer 类中提供的方法都是同步方法,属于安全的线程操作，而StringBuilder类中的方法都属于异步方法，非线程安全的操作
     *  StringBuilder的性能更好，但是StringBuffer的安全性更高
     */
}
