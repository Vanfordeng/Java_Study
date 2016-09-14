package com.study_mars.IO_eg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Doctor on 2016/9/6.
 */
public class TestChar {
    public static void main(String [] args){
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fr = new FileReader("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\IO_eg\\from.txt");
            fw = new FileWriter("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\IO_eg\\to.txt");
            char[] buffer = new char[100];
            while (true){
                int temp = fr.read(buffer,0,buffer.length);
                if (temp == -1){
                    break;
                }
                fw.write(buffer,0,temp);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
