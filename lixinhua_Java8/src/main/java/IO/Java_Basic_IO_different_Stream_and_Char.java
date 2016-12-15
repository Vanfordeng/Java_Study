package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Created by Doctor on 2016/11/21.
 * 字节流和字符流的区别：
 * 字节流与字符流最大的区别是，字节流直接与终端进行数据交互，而字符流需要将数据经过缓冲区处理后才可以输出。
 * 在使用OutputStream输出数据的时候即使最后没有关闭输出流,那么内容也可以正常输出，但是反过来如果使用的字符输出流，如果不
 * 关闭,那么就表示在缓冲区之中处理的内容不会被强制的清空，所有就不会输出数据。如果我们现在有特殊情况，不能够关闭字符输出流，
 * 可以使用flush()方法亲自清空缓冲区。
 */
public class Java_Basic_IO_different_Stream_and_Char {
    public static void main(String[] args) throws IOException, InterruptedException {
        //1.定义File对象
        File file = new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src" + File.separator + "\\main\\test.txt");

        //2.生成相应的文件
        if (!file.getParentFile().exists()){
            file.mkdir();
        }
        //3.定义Stream对象
        OutputStream output =  new FileOutputStream(file);
        //4.准备数据
        byte[] data = new byte[1024];
        String str = "你好啊,Stream";
        data = str.getBytes();
        output.write(data);
        System.out.println("-----------------Writer--------------------------");
        Thread.sleep(3000);
        Writer out =  new FileWriter(file);
        out.write("yes,你好啊");
        out.flush();//强制清空缓冲区，这个就是怎么字符流只用到缓冲区最好的证据

        //字符流最大的优势在于能处理中文
    }
}
