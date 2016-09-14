package com.study_mars.Practice;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Doctor on 2016/9/7.
 */
public class WRData {
    String input;
    public WRData(String input) {
        this.input = input;
    }



    public boolean writeData(){
        FileWriter fw = null;
        BufferedWriter br = null;
        try {
            fw = new FileWriter("D:\\AndroidStudioProjects\\Java_IO\\mars_java4android\\src\\main\\java\\com\\study_mars\\Practice\\user_data.txt",true);
            br = new BufferedWriter(fw);
            br.write(this.input);
            br.newLine();
            br.flush();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
