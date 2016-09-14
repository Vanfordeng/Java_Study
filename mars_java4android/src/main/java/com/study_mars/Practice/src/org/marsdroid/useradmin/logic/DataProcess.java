package com.study_mars.Practice.src.org.marsdroid.useradmin.logic;

import java.util.ArrayList;

import org.marsdroid.useradmin.DataCheck.StringFeature;
import org.marsdroid.useradmin.model.User;
import org.marsdroid.useradmin.ui.UserAdminUI;
import org.marsdroid.useradmin.io.IOUtils;

public class DataProcess {
	private UserAdminUI userAdminUI;
	User user = new User();
	StringFeature stringseprate;
	IOUtils ioUtils = new IOUtils();
	
	public DataProcess(){
		super();
		userAdminUI = new UserAdminUI();
		user = new User();
		stringseprate = new StringFeature();
		ioUtils = new IOUtils();
	}
	
	public void dataProcess(StringFeature stringseprate, ArrayList<User> aimArray){
		
		//��stringState = true�����û������ָ�����Ҫ���ǰ���£������ݴ�����ɾ�Ĳ�洢�������ļ�
		if( stringseprate.stringState ){
			aimArray = processChoose(stringseprate,aimArray);
		}
		//��ӡ���������ļ��е�����,���Ƿŵ���������ݴ�������ã�Ҫ��Ȼ��ϵͳ������ʱ���û�û�����ݴ�����ʾ�����ݻ�Ϊ�� ��
//		�����ʼ���˾ͳ����ˡ����Ѿ���Mainloop����˳�ʼ����������
		ioUtils.dataPrint(aimArray);
	}
	
	public ArrayList<User> processChoose(StringFeature stringseprate,ArrayList<User> aimArray){
		//�ж��û�������ʲô���������ö�Ӧ�ĺ���
		switch( stringseprate.usefulWord.get(0).toUpperCase() ){
		case "ADD":
			System.out.println( userAdminUI.getHelpInfo("add_process") );
			aimArray = ioUtils.readFile("resources", "Data.txt");//�򿪲������ļ��������б������÷ŵ����ݴ������棬���޸���ִ��
			aimArray = ioUtils.addData(stringseprate, aimArray);
			ioUtils.writeFile("resources", "Data.txt", aimArray);//�������б�Ľ��д�������ļ�
			break;
		case "DELETE":
			System.out.println( userAdminUI.getHelpInfo("delete_process") );
			aimArray = ioUtils.readFile("resources", "Data.txt");//�򿪲������ļ��������б������÷ŵ����ݴ������棬���޸���ִ��
			aimArray = ioUtils.deleteData(stringseprate, aimArray);
			ioUtils.writeFile("resources", "Data.txt", aimArray);//�������б�Ľ��д�������ļ�
			break;
		case "UPDATE":
			System.out.println( userAdminUI.getHelpInfo("update_process") );
			aimArray = ioUtils.readFile("resources", "Data.txt");//�򿪲������ļ��������б������÷ŵ����ݴ������棬���޸���ִ��
			aimArray = ioUtils.updateData(stringseprate, aimArray);
			ioUtils.writeFile("resources", "Data.txt", aimArray);//�������б�Ľ��д�������ļ�
			break;
		case "QUERY":
			System.out.println( userAdminUI.getHelpInfo("query_process") );
			aimArray = ioUtils.readFile("resources", "Data.txt");//�򿪲������ļ��������б���ѯ����д���ļ�
			ioUtils.queryData(stringseprate, aimArray);
			break;
		}
		return aimArray;
	}
	
}
