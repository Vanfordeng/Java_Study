package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Doctor on 2016/11/22.
 * 内存流
 * 当学习到AJAX+XML(JSON) 应用的时候才会牵涉到内存流
 * 在之前使用过了文件操作流实现了针对于文件数据的输入与输出操作，但是如果现在某一种应用需要进行IO操作可是又不想产生文件。
 * 就可以利用内存来实现输入与输出的操作。java.io包提供了两组操作：
 * 字节内存流： public class ByteArrayInputStream extends InputStream
 *              public class ByteArrayOutputStream extends OutputStream
 * 字符内存流： public class CharArrayReader extends Reader
 *              public class CharArrayWriter extends Writer
 *  ----------------------------------------------------------------------------
 *  ByteArrayInputStream                         ByteArrayOutputStream
 *
 * 继承结构：
 * java.lang.Object                               java.lang.Object
        java.io.InputStream                            java.io.OutputStream
            java.io.ByteArrayInputStream                     java.io.ByteArrayOutputStream
 *
 * 构造方法：
 * public ByteArrayInputStream(byte[] buf)         public ByteArrayOutputStream()
 * 表示将要操作的数据设置到输入流                   从内存输出数据
 *
 * 以文件操作为例：
 *   |—：输出（OutputStream): 程序  —> FileOutputStream ->文件
 *   |—：输入（InputStream): 程序  <— FileInputStream <-文件
 * 以内存操作为例：
 *   |—：输出（InputStream): 程序  —> ByteArrayInputStream -> 内存
 *   |—：输入（OutputStream): 程序  <— ByteArrayOutputStream <- 内存
 */
public class Java_Basic_IO_Memory {
    public static void main(String[] args) throws IOException {
        //利用内存流实现一个小写字母转大写的操作
        String str = "Hello world!!";   //要被转换的字符串
        //将所有要读取的数据设置到内存数据流之中，本次利用向上转型为InputStream对象
        InputStream input = new ByteArrayInputStream(str.getBytes());
        //读取内存数据
        OutputStream output = new ByteArrayOutputStream();

        int temp = 0;  //读取每一个直接数据
        while((temp = input.read())!=-1){  //每次读取一个数据
            output.write(Character.toUpperCase(temp));  //直接输入流
        }
        System.out.println(output);
        input.close();
        output.close();
        //此处ByteArrayInputStream和ByteArrayOutputStream都向上转型了，但是ByteByteArrayOutputStream里面有一个特别重要的方法
        // public byte[] toByteArray() 这个方法可以将所有的包装在内存中的直接数据变为直接数组存在
        //利用这个ByteArrayOutputStream可以实现合并去读两个文件的内容
        System.out.println("-----------------------------------------");

        File fileA = new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\\A.txt");
        File fileB = new File("D:\\AndroidStudioProjects\\Java_IO\\lixinhua_Java8\\src\\main\\B.txt");

        InputStream inputA = new FileInputStream(fileA);
        InputStream inputB = new FileInputStream(fileB);

        ByteArrayOutputStream memoryOutput = new ByteArrayOutputStream();

        int temp1 = 0;
        while ((temp1 = inputA.read())!= -1){
            memoryOutput.write(temp1);
        }
        while ((temp1 = inputB.read())!= -1){
            memoryOutput.write(temp1);
        }
        //现在所有的内容保存在了内存输出流里面，所有的内容变为直接数组取出
        byte[] data = memoryOutput.toByteArray();
        inputA.close();
        inputB.close();
        memoryOutput.close();
        System.out.println(new String(data));

    }
}
