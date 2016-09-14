package com.study_mars.Practice.src.org.marsdroid.useradmin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���ڽ����û��Ӽ������������
public class UserInputIO {
	private BufferedReader bufferedReader;
	public UserInputIO(){
		bufferedReader =new BufferedReader(new InputStreamReader(System.in));
	}
	
	public String getInputLine(){
		String inputLine = null;
		try{
			inputLine = bufferedReader.readLine();//�û���������֮�󣬰��»س��������д��뼴�ɶ�ȡ�û�������
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return inputLine;
	}
}
