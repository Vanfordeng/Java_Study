package com.study_mars.IO_eg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Doctor on 2016/9/5.
 */
public class Test {

    public static void main(String[] args){
        //声明输入流引用
        FileInputStream fis = null;
        //声明输出流引用
        FileOutputStream fos = null;
        try {
            //生成代表输入流的对象
            fis =  new FileInputStream("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\IO_eg\\from.txt");
            //生成代表输出流的对象
            fos =  new FileOutputStream("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\IO_eg\\to.txt");
            //生成一个字节数组
            byte buffer[] = new byte[1024];
            //调用输入流对象的read方法,读取数据
            //  public int read(byte b[], int off, int len)
            int temp = 0;
            while (true) {
                //调用输入流对象的read方法，读取数据
                temp = fis.read(buffer,0,buffer.length);
                if (temp == -1){
                    break;
                }
                //调用输出流对象的write方法，读取数据
                fos.write(buffer,0,temp);
            }

//            for (int i = 0; i < 3 ; i++) {
//                System.out.println(buffer[i]);
//            }
            //通过String的构造函数间buffer转换为String字符串
//            String s = new String(buffer);
            //调用一个String对象的trim方法,将会去除掉这个字符串的首尾空格和空字符
//            s = s.trim();
//            System.out.println(s+s.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
