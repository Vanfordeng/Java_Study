package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Created by Doctor on 2016/11/22.
 * 编码
 * 计算机中所有的信息注册都是二进制数据，那么所有能够描述出的中文字都是经过处理后的结果。
 *  | GBK 、GB2312：中文的国标编码，其中GBK包含有简体中文与繁体中文两种，而GB2312只包含简体
 *  | ISO8859-1：是国际编码，可以描述任何的文字信息
 *  | UNICODE: 是十六进制编码，造成传输的无用数据过多
 *  | UTF编码（UTF-8): 融合了ISO8859-1 和UNICODE编码的特点。
 *  在以后的所有开发里面，使用都是UTF-8编码
 *  所谓的乱码最本质的方式就是编码与解码的字符集不统一。
 */
public class Java_Basic_IO_Encode {
    public static void main(String[] args) throws IOException {
        System.getProperties().list(System.out);
        File file =  new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main" + File.separator +"test.txt");
        OutputStream out =  new FileOutputStream(file);
        out.write("中国万岁,世界万岁".getBytes("GBK"));  //getBytes(Charset charset) 接收字符集编码
        //如下的代码会出现乱码
        //out.write("中国万岁,世界万岁".getBytes("ISO8859-1"));  //getBytes(Charset charset) 接收字符集编码
        out.close();
    }
}
