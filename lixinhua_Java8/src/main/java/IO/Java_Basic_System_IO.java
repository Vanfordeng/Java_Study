package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.function.Consumer;

/**
 * Created by Doctor on 2016/11/22.
 * System类对IO的支持
 *  错误输出：static PrintStream err  :public static final PrintStream err
 The "standard" error output stream.
 输出到标准输出设备（显示器）：static InputStream in  :public static final InputStream in
 The "standard" input stream.
 从标准输入设备读取（键盘）：static PrintStream out :public static final PrintStream out
 The "standard" output stream.

 严格来讲System.err和System.out的功能是完全一样的。除了颜色不一样。但是在命令行中也看不出颜色。之所以这样设计，主要的目的是
 是err输出不然用户看见的错误,而out输出的是可以让用户看见的信息。但是现在基本没有再去分了。
 Todo System.out是专门准备的支持屏幕输出信息的操作对象（此对象由系统进行实例化）
 */
public class Java_Basic_System_IO {
    public static void main(String[] args) throws IOException {
        System.out.println();
        System.err.println("Hello");
        try {
            Integer.valueOf("abc");
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println("--------实现屏幕输出System.out-----");
        //现在OutputStream就变为了屏幕输出
        OutputStream out = System.out; //此处体现了OutputStream接收不同的子类,实现不同的方式的输出的多态样式
        try {
            out.write("Hell World!!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //另外,需要结合JDK1.8的函数式的功能接口。它可以为消费型函数式接口做方法引用
        Consumer<String> consumer = System.out :: println;
        consumer.accept("Hello 世界");
        System.out.println("--------实现键盘输入System.in-----");
        //--------------------------------------
        InputStream input = System.in;
        byte[] data = new byte[3];  //此处会有长度限制,如果数组设置为3，那么每次read的时候就只能读取到3个字节的数据
        System.out.println("请输入数据：");
        int len = input.read (data);
        System.out.println("输入的数据为：" + new String(data,0,len));
        System.out.println("---------没有长度限制的System.in-------");
        System.out.println("请输入数据：");
        InputStream inputStream =  System.in;
        StringBuffer buf = new StringBuffer();
        int temp = 0;
        while ((temp = inputStream.read())!= -1){
            if (temp == '\n'){  //由于一个一个字节读取,如果遇到中文会出现乱码的情况.输入因为没有问题
                break;
            }
            buf.append((char)temp);
        }
        System.out.println("输入的数据为："+ buf);
        System.out.println("请输入数据：");
        //解决中文输入乱码的问题,其实就是将字节流转换为字符流就可以解决
        System.out.println("------------------读取一行，并解决中文输入的问题-------------");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine());
    }
}
