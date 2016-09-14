package com.study_mars.Practice_Mars.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Doctor on 2016/9/14.
 */
public class UserInputIO {
    private BufferedReader bufferedReader;
    public UserInputIO(){
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }
    public String getInputLine(){
        String inputLine = null;
        try {
            inputLine = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputLine;
    }
}
