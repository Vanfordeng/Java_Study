package com.study_mars.IO_eg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Doctor on 2016/9/6.
 */
public class TestBufferReader {
    public static void main(String [] args){
        FileReader fr = null;
        FileWriter fw = null;

        //处理流,实际上BufferReader是从FileReader中读取数据，而真正从文件中读取数据的是FileReader（节点流）
        //Tips:输入流/输出流  字节流/字符流  节点流/处理流 处理流是在节点流上进行了处理和再加工
        //Tips:节点流是被装饰者,处理流是装饰者,装饰者是给被装饰者添加更加丰富的功能的
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            fr =  new FileReader("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\IO_eg\\from.txt");
            fw =  new FileWriter("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\IO_eg\\to.txt");
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            while (true) {
                String temp = br.readLine();
                System.out.println(temp);
                if (null == temp ){
                    break;
                }
                bw.write(temp);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
