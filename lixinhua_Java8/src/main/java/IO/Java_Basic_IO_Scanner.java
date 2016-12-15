package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Doctor on 2016/11/22.
 * Todo Scanner类: public final class Scanner extends Object
 * since JDK1.5
 * java.lang.Object
        java.util.Scanner
 * 如果要改进输出功能不足提供有打印流，随后有利用BufferedReader解决大文本数据的读取操作，但是
 * BufferedReader有两个问题：
 *  |-1.它读书的时候只能按照字符串返回：public String readLine() throws IOException
 *  |-2.所有的分隔符都是固定的。（回车符）
 *  在JDK1.5之后提供了一个java.util.Scanner的类,这个类专门负责解决所有输入流的操作问题。
 *  public final class Scanner extends Object implements Iterator<String>, Closeable
 *  构造方法：
 *  public Scanner(InputStream source)  //接收有一个InputStream类对象
 *  在Scanner类里面定义了以下两大组方法：Next()和hasNext()
 *  其中  判定是否有指定数据：public boolean hasNextXxxx()
 *        取出数据：public 数据类型 nextXxxx()
 *  public boolean hasNext()
 *  public String next()
 *  public boolean hasNext(String pattern)
 *  public String next(String pattern)
 *  public boolean hasNextDouble()
 *  public double nextDouble()
 * Todo Scanner里面还提供一个非常重要的方法：public Scanner useDelimiter(Pattern pattern)
 * Todo                                    public Scanner useDelimiter(String pattern)
 *
 */
public class Java_Basic_IO_Scanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in); //准备接收键盘输入数据
        System.out.println("--------------字符串--------------------------");
        System.out.println("请输入内容：");
        if (scan.hasNext()){  //现在有输入数据
            System.out.println(scan.next());
        }
        //Scanner与BufferedReader比更加简单
        //但是需要提醒的是,如果说现在输入的是字符串，是否存在有hsaNext（）方法意义不大,但是如果是其他数据类型
        //这个hasNextXxxx()就有意义了,为了保持操作的统一性,建议不管是否又要用都加上
        System.out.println("--------------小数--------------------------");
        System.out.println("请输入内容：");
        Scanner scan_double = new Scanner(System.in);
        if (scan_double.hasNextDouble()){  //表示输入的是一个小数
            double score = scan_double.nextDouble(); //避免了BufferedReader 读取的是String要进行数据转型的操作
            System.out.println("输入内容：" + score);
        }else {
            System.out.println("输入的不是小数,请重新输入");
        }
        System.out.println("---------------正则-------------------------");
        System.out.println("请输入生日：");
        Scanner scan_bir = new Scanner(System.in);
        if (scan_bir.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            String bir = scan_bir.next("\\d{4}-\\d{2}-\\d{2}");
            System.out.println("生日为：" + bir);
        }else {//输入的不是生日
            System.out.println("输入的格式有误,请重新输入");
        }

        System.out.println("---------------设置分隔符，这个功能BufferedReader没有-------------------------");
        File file =  new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\\test.txt");
        InputStream input = new FileInputStream(file);
        Scanner scan_Delimiter = new Scanner(input);
        scan_Delimiter.useDelimiter("Hell");  //TODO 设置以什么为分隔符分割文件中的内容
        while (scan_Delimiter.hasNext()){
            System.out.println(scan_Delimiter.next());
        }
        scan.close();
    }
    /**@总结：在以后的开发中程序输出数据使用打印流，输入数据使用Scanner,如果Scanner不好用了，使用BufferedReader
     * InputStream类的功能不足以及被Scanner解决了
     * Reader类的功能不足被BufferedReader解决了
     * OutputStream类的功能不足被PrintStream类解决了
     * Writer类的功能不足被PrintWriter类解决了
     */
}
