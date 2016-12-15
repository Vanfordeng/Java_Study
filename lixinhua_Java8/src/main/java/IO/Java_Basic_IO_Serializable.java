package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Doctor on 2016/11/23.
 * 对象序列化
 * 所谓的对象序列化指的就是将保存在内存中的对象数据转换为二进制数据流进行传输操作
 * 但是并不是所有类的对象都可以进行序列化，如果要被序列化的对象，那么其所在的类一定要实现java.io.Serializable接口
 * 但是这个接口里面并没有任何操作方法存在,因为它是一种标识接口，表示一种能力。
 * Java的两个标识接口：
 * Serializable：
 * public interface Serializable
 * Cloneable：
 * Cloneable的定义：Interface Cloneable 中并没有看见方法，此为//Todo 标识接口，表示一种操作能力。没有任何方法定义，只是一个空接口的声明
 *
 * 将对象序列化到文件中需要两个类来支持：
 * 序列化类：将对象变为指定格式的二进制数据：public class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants
 *  反序列化：可以将序列化的对象转换回对象内容：public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants
 *
 *
 */
class Book implements Serializable{  //此类对象可以被血泪华
    //序列化ID主要是考虑到：有可能是JDK1.6序列化,到了JDK1.8来反序列化。那么就会出现版本不同意。用一个ID来表示版本
//    private static final long serialVersionUId = -3241525213452525252L;
    private transient String title;
    private double price;
    public Book(String title,double price){
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名：" + this.title + "\t书的价格：" + this.price;
    }
}
public class Java_Basic_IO_Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ser();
        dser();  //书名：null	书的价格：79.8
    }
    public static void ser() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\\test.txt")));
        oos.writeObject(new Book("Java开发",79.8));
        oos.close();
    }
    public static void dser() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\\test.txt")));
        Book book = (Book) ois.readObject(); //readObject()返回的Object.需要向下转型
        System.out.println(book);
    }
    //todo transient关键字
    //序列化操作时是将整个对象的所有属性内容进行了一个保存,如果说某些属性的内容不需要被保存,那么就可以通过transient关键字来定义
    /**
     * @总结：
     * 观察一个类或者学习一个新的类：主要观察几个方面：类继承结构、类构造方法、类属性、类方法
     * 类继承结构：可以观察到拥有哪些父类的能力：继承的接口，类
     * 类构造方法：可以观察到以哪种方式可以取构建该类的对象：构造私有化,有参构造,无参构造
     * 类的属性：可以观察到类拥有哪些定义的值。包括：常量,非常量
     * 类的方法：观察到类有用那些能力。包括：静态方法,非静态方法，final方法,abstract方法等等
     */
}
