package com.study_mars.Practice.src.org.marsdroid.useradmin.logic;

import java.util.ArrayList;

import org.marsdroid.useradmin.DataCheck.InputDataCheck;
import org.marsdroid.useradmin.DataCheck.StringFeature;
import org.marsdroid.useradmin.io.IOUtils;
import org.marsdroid.useradmin.io.UserInputIO;
import org.marsdroid.useradmin.model.User;

public class MainLooper {
	private boolean flag = true;
	public UserInputIO userInputIO;
	InputDataCheck inputDataCheck;
	StringFeature stringseprate;
	IOUtils ioUtils;
	ArrayList<User> arrayList ;
	DataProcess dataProcess ;
	
	public MainLooper(){
		userInputIO = new UserInputIO(); //����UserInputIO�Ķ���
		inputDataCheck = new InputDataCheck();
		stringseprate = new StringFeature();
		ioUtils = new IOUtils();
		arrayList = new ArrayList<User>();
		dataProcess = new DataProcess();
	}
	
	public void loop(){
		
		
		while(flag){
			arrayList = ioUtils.readFile("resources", "Data.txt");//��ʼ�����ݣ��򿪲������ļ��������б�
			String input = userInputIO.getInputLine();//�����Լ�д�ĺ�������ȡ�û�����
//			System.out.println(input);
			stringseprate = inputDataCheck.inputCheck(input , arrayList);//������������֤
			dataProcess.dataProcess(stringseprate, arrayList);//�����û�������������б������ɾ�Ĳ�Ĵ�����������ս��
		}
	}
}
