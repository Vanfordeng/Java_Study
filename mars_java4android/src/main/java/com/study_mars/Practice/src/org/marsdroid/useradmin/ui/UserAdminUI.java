package com.study_mars.Practice.src.org.marsdroid.useradmin.ui;

import org.marsdroid.useradmin.io.IOUtils;
import org.marsdroid.useradmin.model.User;
import java.util.Properties;

//�������ڶ�������Ӧ�ó����UIϵͳ
public class UserAdminUI {
	private static Properties properties = null;
	
	static{
		properties = IOUtils.loadProperties("resources", "info.properties");
	}
	public void loadUI(){
		System.out.println(getHelpInfo("welcome"));
	}
	//���ݼ�������Դ�ļ�����ȡ����Ӧ��ֵ
	public String getHelpInfo(String key){
		String helpInfo = (String)properties.get(key);
		return helpInfo;
	}
	
//	public void displayHelp(){
//		System.out.println("****************USER ADMIN******************");
//		System.out.println("��ӭʹ���û�����ϵͳ");
//		System.out.println("����ʹ�÷������£�");
//		System.out.println("1->����û�");
//		System.out.println("2->ɾ���û�");
//		System.out.println("3->�����û�����");
//		System.out.println("4->��ѯ�û�");
//		System.out.println("5->�˳�");
//		System.out.println("****************USER ADMIN******************");
//		System.out.println("��ѡ��������Ҫ�Ĺ��ܣ�");
//	}
//	
//	public void displayAddUserHelp(){
//		System.out.println("����û��Ĳ���������add �û��� ���� �Ա� нˮ");
//		System.out.println("����: add ���� 33 �� 8000.00 ");
//	}
//	
//	public void displayDeleteUserHelp(){
//		System.out.println("ɾ���û��Ĳ���������delete id ���� delete �û���");
//		System.out.println("���ӣ�delete 5 ���� delete ����");
//	}
//	
//	public void displayUpdateUserHelp(){
//		System.out.println("�����û��Ĳ���������update id:id salary=нˮ");
//		System.out.println("���ӣ�update id:5 salary=10000.00");
//	}
//	
//	public void displayQueryUserHelp(){
//		System.out.println("��ѯ�û��Ĳ���������query id=id ���� query name=�û��� ����  query salary>нˮ");
//		System.out.println("���ӣ�query id=5 ���� query name=���� ���� query salary>5000.00");
//	}
	
	public void displayUserInfo(User user){
		System.out.println("id:" + user.getId() + "\tname:" + user.getName() + "\tage:" + user.getAge() +"\tgender:" + user.getGender() + "\tsalary:" + user.getSalary());
	}
}
