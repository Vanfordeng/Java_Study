package com.study_mars.AnalysisText.IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Doctor on 2016/9/14.
 */
public class TextIO {
    FileReader fr = null;
    BufferedReader br = null;

    public void read(String path){
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            while (true){
                String line = br.readLine();
                if (null!=line){
                    if (line.matches(".*xxx.*")){
                        System.out.println(line);
                    }
                }else if (null==line){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
