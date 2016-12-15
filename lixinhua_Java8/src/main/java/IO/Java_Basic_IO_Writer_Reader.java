package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * Created by Doctor on 2016/11/21.
 * 字符流
 * Writer 类时在JDK1.1之后新增的,其类的定义如下：
 * public abstract class Writer extends Object implements Appendable, Closeable, Flushable
 * 观察：多了一个Appendable接口,包含如下上个方法：
 * Appendable append(char c)throws IOException
 * Appendable append(CharSequence csq) throws IOException
 * Appendable append(CharSequence csq,int start,int end)throws IOException
 * Writer类im定义有以下的输出方法（部分）：
 * 输出全部字符数组：public void write(char[] cbuf) throws IOException
 * 输出字符串：public void write(String str) throws IOException
 *
 * Reader:
 * public abstract class Reader extends Object implements Readable, Closeable
 * Readable接口和nio有关，解决服务器延迟的相关问题
 * Reader中定义的方法：
 *   |—：读取字符数组：public int read(char[] cbuf) throws IOException
 *   |—：读取单个字符：public int read()throws IOException
 */
public class Java_Basic_IO_Writer_Reader {
    public static void main(String[] args) throws IOException {
        File file =  new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main" + File.separator +"test.txt");
        //1.定义要输入文件的路径
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        //2.实例化Writer类的对象
        Writer out = new FileWriter(file);
        //3.进行内容输出
        String str = "千万不要被。。。";
        out.write(str);
        out.close();
        System.out.println("-----读取数据-------");

        if (file.exists()){
            //2.为Reader类对象实例化
            Reader in = new FileReader(file);
            //3.进行数据读取
            char[] data = new char[1024];
            int len = in.read(data);
            //4.关闭输入流
            in.close();
            System.out.println(new String(data,0,len));
        }
    }
}
