package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Doctor on 2016/11/17.
 * IO
 * 如果要进行输入,输出操作一般都会按照如下的步骤进行：
 * |—：通过File类定义一个要操作文件的路径
 * |—：通过字节流或字符流的子类对象为父类对象实例化
 * |—：进行数据的读（输入）、写（输出）操作
 * |—：数据流属于资源操作，资源操作必须关闭
 *
 * java.io提供了两种流：
 * 1.字节流(JDK1.0)：InputStream、OutputStream
 * 2.字符流(JDK1.1)：Reader、Writer
 *
 *
 * OutputStream: public abstract class OutputStream extends Object implements Closeable, Flushable
 * 发现实现了两个接口：Closeable、Flushable接口
 *
 * Closeable接口(JDK 1.5之后)
 * 定义：public interface Closeable extends AutoCloseable
 * AutoCloseable（JDK 1.7）
 * 方法：void close()throws IOException
 * Flushable接口(JDK 1.5之后)
 * 定义：public interface Flushable
 * 方法：void flush() throws IOException （flush 清空）
 *但是OutputStream类是在JDK1.0的时候就提供的,这个类原本就定义了close()和flush()两个方法，所以现在以上的两个接口就几乎可以忽略了。
 * 在OutputStream中提供有三个方法：
 * |—：输出单个字节：public abstract void write(int b) throws IOException
 * |—：输出全部字节数组：public void write(byte[] b) throws IOException
 * |—：输出部分直接数组：public void write(byte[] b,int off,int len) throws IOException
 * Todo OutputStream(JDK1.0) 本身是属于抽象类,如果想要为抽象类进行对象的实例化操作,那么一定要使用抽象类的子类.本次
 * Todo 由于要进行的是文件操作,可以使用FileOutputStream子类。在子类实例化对象向父类转型的过程中,最关注的是子类中的构造方法
 * public class FilterOutputStream extends OutputStream
 * Todo FileOutputStream子类的构造方法有：
 *   |—创建或覆盖已有文件：public FileOutputStream(File file) throws FileNotFoundException
 *   |—是不是要进行文件追加：public FileOutputStream(File file,boolean append)throws FileNotFoundException
 * Todo InputStream(Since:JDK1.0 ) 抽象类
 * public abstract class InputStream extends Object implements Closeable
 *   |—读取单个字节：public abstract int read()throws IOException
 *      |—返回值：返回读取的字节内容,如果现在已经没有内容。返回-1
 *   |—将读取的数据保存在字符数组里：public int read(byte[] b)throws IOException
 *      |—返回值：返回读取的数据长度，但是如果读取到结尾了，返回-1
 *   |—将读取的数据保存在部分字符数组里：public int read(byte[] b,int off,int len) throws IOException
 *      |—返回值：返回读取部分的数据长度，但是如果读取到结尾了，返回-1
 * Todo FileInputStream子类的构造方法有：
 *   public FileInputStream(File file)throws FileNotFoundException
 */
public class Java_Basic_IO_InputStream_OutputStream {
    public static void main(String[] args) throws IOException {
        //1.定义要输出文件的路径
        File file =  new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main" + File.separator +"test.txt");
        //1.此时由于目录不存在,所以文件不能够输出，那么应该创建目录
        if (!file.getParentFile().exists()){ //文件目录不存在
            file.getParentFile().mkdir(); //创建目录
        }
        //2.应该使用OutputStream和其子类进行对象的实例化，此时目录存在，文件还不存在
        OutputStream output = new FileOutputStream(file,true);
        //3.要进行文件内容的输出
        String str = "好好学习，天天向上";
        byte[] data = str.getBytes();  //将字符串变为字符数组
        output.write(data); //将内容输出
        for (int i = 0; i < data.length; i++) {
            output.write(data[i]); //输出单个字节
        }
        output.write(data,2,4);  //输出部分（有可能出现乱码：一个中文占两个字符）

        output.close();
        System.out.println("OK");
        //如果此时要输出的文件不存在，那么会自动进行创建
        //--------------------------------------读取--------------------------
        if (file.exists()){  //判断文件是否存在
            //2.使用InputStream进行读取
            InputStream input = new FileInputStream(file);
            byte[] datai = new byte[1024];  //准备出一个1024的数组
//            int len = input.read(datai);  //将内容保存到字节 数组中


            //--------------------------------------单个直接数据读取--------------------------
            System.out.println("-------单个字节数据读取------");
            int foot =0;
            int temp = 0;
//            do {
//                temp = input.read();  //读取一个字节
//                if (temp!= -1){
//                    datai[foot++] = (byte)temp;
//                }
//            }while (temp != -1);
            while ((temp = input.read())!= -1 ){
                datai[foot ++] = (byte) temp;
            }

            System.out.println(new String(datai,0,foot));
        }
    }
}
