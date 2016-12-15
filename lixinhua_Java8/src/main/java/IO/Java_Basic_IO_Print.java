package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Created by Doctor on 2016/11/22.
 * 打印流:主要解决OutputStream输出必须通过转换为byte数组的形式来输出。会比较麻烦。
 * 为了解决输出数据时的不足，所有在java.io包里面又提供了一套专门用于输出数据的 类：
 * PrintStream(打印字节流)和PrintWriter（打印字符流）
 * PrintStream的继承结构和构造方法
 * java.lang.Object
        java.io.OutputStream
                java.io.FilterOutputStream
                        java.io.PrintStream
 *
 * 构造方法：
 * public PrintStream(OutputStream out) Todo PrintStream是OutputStream类的子类又要接收一个OutputStream对象。这种形式的结构!
 *
 * 所有的输出数据都要求使用打印流完成,但是在JDK1.5之后考虑到市场因素，增加了一种新的输出。叫格式化输出
 * public PrintStream printf(String format,Object... args)
 * 如果要格式化输出就需要一些标记：整数（%d）、字符串（%s）、小数（%m.nf）、字符（%c）
 * Todo 在JDK1.5之后String也发生了一个变化.字符串格式化：
 * public static String format(String format, Object... args)
 *
 */
class PrintUtil{
    private OutputStream out;
    public PrintUtil(OutputStream out){
        this.out = out;
    }
    public void print(String x){
        try {
            this.out.write(x.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void print(int x){
        this.print(String.valueOf(x));
    }
    public void print(double x){
        this.print(String.valueOf(x));
    }
    public void println(Double x){
        this.println(String.valueOf(x));
    }
    public void println(String x){
        this.print(x.concat("\n"));
    }
    public void println(Integer x){
        this.println(String.valueOf(x));
    }
    public void close(){
        try {
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Java_Basic_IO_Print{
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\\test.txt");
        OutputStream output = new FileOutputStream(file);
        PrintUtil pt1 = new PrintUtil(output);
        pt1.println("Hell World!!");
        pt1.print(10.2);
        pt1.println(1);
        pt1.print(10.1+11.1);
        pt1.close();
        System.out.println("----------PrintStream---------------");
        OutputStream output1 = new FileOutputStream(file);
        PrintStream pt = new PrintStream(output1);
        pt.println("Hell World!!");
        pt.print(10.2);
        pt.println(1);
        pt.print(10.1+11.1+ "\n");
        System.out.println("-----------printf-------------------");
        String name = "城管";
        int age = 19;
        double score = 59.2325263263;
        pt.printf("姓名：%S,年龄：%d,成绩：%5.2f",name,age,score);
        pt.close();
        System.out.println("-----------格式化字符串-------------------");
        String str = String.format("姓名：%s,年龄：%d,成绩：%5.2f",name,age,score);
        System.out.println(str);
    }
}
