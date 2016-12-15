package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Doctor on 2016/11/22.
 * DOS系统中文件的拷贝系统
 */
public class Java_Basic_IO_Practice {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        if (args.length !=2){  //初始化参数不足2位
            System.out.println("命令执行错误!");
            System.exit(1);   //程序退出执行
        }
        //如果输入参数正确了,应该对文件进行验证
        File inFile = new File(args[0]);  //第一个为源文件路径
        if (!inFile.exists()){
            System.out.println("源文件不存在，请确认执行路径");
            System.exit(1);
        }
        //如果此时源文件正确，那么就需要定义输出文件，同时要考虑到数据文件目录
        File outFile = new File(args[1]);
        if (!outFile.getParentFile().exists()){
            outFile.getParentFile().mkdir();
        }
        //实现文件内容的拷贝
        InputStream input =  new FileInputStream(inFile);
        OutputStream output = new FileOutputStream(outFile);
        int temp = 0 ; //保存每次读取的内容
//        while ((temp = input.read())!= -1){   //读取单个字节
//            output.write(temp);   //写入单个字节
//        }
        //改进while循环和读取方式
        //TODO 虽然data的长度1024设置大一点可以增加拷贝的速度.但是现在绝大多数的程序都是并发的执行的。在增加速度不多的情况，调用的越多越会浪费内存资源
        byte[] data = new byte[1024];  //每次读取时保存到data字节数据中作为缓存，先读取一堆数据。相当于搬砖的小推车
        //将每次读取进来的数据保存在字节数组里面，并且返回读取的个数
        while((temp = input.read(data)) != -1){
            output.write(data);
        }

        input.close();
        output.close();
        long end = System.currentTimeMillis();
        long total =  end -start;
        System.out.println("拷贝所花费的时间："+ new SimpleDateFormat("mm:ss:SSS").format(new Date(total)));
        //这个时候发现一个字节一个字节的读取与写入会造成while循环执行很多次。降低了读写的效率：拷贝所花费的时间：00:20:680
        //Todo InputStream：public int read(byte[] b) throws IOException
            //|- 将内容读取到字节数组中，如果没有数据返回的是-1，否则是读取的字节的长度。（1.如果读取到的长度能装满直接数组，那么长度就是自己的数组和读取字节的长度，2.如果读取的内容不足以装满整个少数组，那么得到的是读取到的字节数据的长度）
        //Todo OutputStream:public void write(byte[] b,int off,int len) throws IOException
        //Todo              public void write(byte[] b) throws IOException
            //|-要设置的直接数组实际上就是read()方法里面使用的数组
            //|-一定是从直接数据的第0个元素开始输出，输出读取的数据长度
    }
}
