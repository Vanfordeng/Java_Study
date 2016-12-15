package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Doctor on 2016/11/22.
 * 字节缓冲区流：
 * public class BufferedInputStream extends FilterInputStream
 * public class BufferedOutputStream extends FilterOutputStream
 * 字符缓冲区流：
 * public class BufferedReader extends Reader
 * public class BufferedWriter extends Writer
 * 这其中最重要的是：BufferedReader，其中提供了一个重要的读取方法：
 * Todo public String readLine() throws IOException [返回的String]
 * 继承结构：
 * java.lang.Object
 java.io.Reader
 java.io.BufferedReader
 *构造方法：
 * public BufferedReader(Reader in)
 */
public class Java_Basic_Buffer_ReaderWriter_Stream {
    public static void main(String[] args) throws IOException {
        System.out.println("------------------读取一行，并解决中文输入的问题-------------");
        //1、System.in是InputStream类的对象
        //2、BufferedReader的构造方法里面需要接收Reader类对象
        //3、利用InputStreamReader将字节流变为字符流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(br.readLine());   //以回车作为换行
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------");
        boolean flag = true;
        System.out.println("请输入年纪：");
        while (flag) {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            String str = br1.readLine();
            //编写一个循环的逻辑

            if (str.matches("\\d{1,3}")) {
                System.out.println("年纪是：" + Integer.valueOf(str));  //将字符串变为各个类型
                flag = false;
            } else {
                System.out.println("年纪输入错误,请重新输入：");
            }
        }

        //除了读取键盘输入,缓冲区字符流还可以读取其它类型的Reader子类，例如FileReader
        File file =  new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\\test.txt");
        BufferedReader br2 = new BufferedReader(new FileReader(file));
        int i = 0;
        String str = null;
        while ((str = br2.readLine())!= null){
            System.out.println(String.format("第%d行", i++));
            System.out.println(str);
        }
    }
}
