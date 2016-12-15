package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by Doctor on 2016/11/22.
 * 字符流和字节流之间的转换
 * 在Java.io包里面提供有两个类：InputStreamReader、OutputStreamWriter
 * Todo(since JDK1.1 ): public class InputStreamReader extends Reader
 * 构造方法: public InputStreamReader(InputStream in)   //观察：接收的是InputStream类对象,而InputStreamReader又是Reader类的子类，就相当于把字节流变为了字符流
 * Todo(since JDK1.1 ): public class OutputStreamWriter extends Writer
 * 构造方法:public OutputStreamWriter(OutputStream out)
 * 观察：类的继承结构：
 *  FileInputStream类的继承结构                               FileOutputStream类的继承结构
 *java.lang.Object                                                  java.lang.Object
        java.io.InputStream                                              java.io.OutputStream
                 java.io.FileInputStream                                      java.io.FileOutputStream
 *
 *Todo FileInputStream 与FileOutputStream都是InputStream和OutputStream的直接子类
 * 观察FileWriter和FileReader类的继承结构
 * FileReader类的继承结构：                                   FileWriter类的继承结构
 * java.lang.Object                                           java.lang.Object
        java.io.Reader                                             java.io.Writer
  Todo     java.io.InputStreamReader                              java.io.OutputStreamWriter
                 java.io.FileReader                                           java.io.FileWriter

 *结论：文件保存在磁盘上,磁盘上能够保存的文件形式都是以字节的形式保存的，而在使用字符流读取的时候实际上也是对于字节流进行读取
 * 只不过这个转换过程被操作系统给隐藏了，在缓冲区里面进行了数据的操作
 *
 */
public class Java_Basic_IO_Switch_Stream_and_Char {
    public static void main(String[] args) throws IOException {
        File file =  new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main" + File.separator +"test.txt");
        //1.定义要输入文件的路径
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }

        OutputStream output = new FileOutputStream(file);
        //将OutputStream类对象传递给OutputStreamWriter类的构造方法，而后显示转型为Writer
        Writer out = new OutputStreamWriter(output);
        out.write("Hello World!");
        out.flush();  //一旦转换之后,会按照各个流自己的特点进行输出。
        out.close();
    }
}
