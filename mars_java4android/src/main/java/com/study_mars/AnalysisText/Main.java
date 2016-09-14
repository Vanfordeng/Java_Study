package com.study_mars.AnalysisText;

import com.study_mars.AnalysisText.IO.TextIO;

/**
 * Created by Doctor on 2016/9/14.
 */
public class Main {
    public static void main(String[] args){
        String path = "C:\\Users\\Administrator\\Desktop\\L506_PPP拨号.txt";
        TextIO textIO = new TextIO();
        textIO.read(path);
    }
}
