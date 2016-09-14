package com.study_mars.Practice.src.org.marsdroid.useradmin.DataCheck;

import java.util.ArrayList;

import org.marsdroid.useradmin.model.User;
import org.marsdroid.useradmin.ui.UserAdminUI;
import org.marsdroid.useradmin.DataCheck.StringFeature;
import org.marsdroid.useradmin.logic.StringToData;;

public class InputDataCheck {
	//������֤ģ�飺��֤����������Ƿ�Ϸ�
	StringFeature stringseprate;
	User user;
	private UserAdminUI userAdminUI ;
	private DataExist dataExist;
//	ArrayList<User> aimArray;
	ArrayList<Integer> idFindList;
	StringToData stringToData ;
	
	public InputDataCheck(){
		super();
		stringseprate = new StringFeature();
		user = new User() ;
		userAdminUI = new UserAdminUI();
		dataExist = new DataExist();
//		aimArray = new ArrayList<User>() ;
		idFindList = new ArrayList<Integer>() ;
		stringToData = new StringToData( stringseprate ) ;
	}
	
	//���������ʽ���
	public StringFeature inputCheck(String stringInput ,ArrayList<User> aimArray){
		stringseprate = stringToData.stringSeprate(stringInput);
		commandCheck(stringseprate ,aimArray);
		return stringseprate;
	}
	
	//�����ʽ��鹤��
	public void commandCheck(StringFeature stringseprate ,ArrayList<User> aimArray){
		if(stringseprate.usefulWord.size() > 0){
			stringseprate.stringState = true;
			switch( stringseprate.usefulWord.get(0).toUpperCase() ){
			case "ADD":
				if( lengthCheck( user.getUserFeature() +1 -1) ){ //+1:ָadd���-1:��ΪId�û������޸�
					//���ָ��Ⱥ��ʣ�ִ��add����ĸ�ʽ���
					addCheck(stringseprate , aimArray);
				}
				break;
			case "DELETE":
				if( lengthCheck( 2 ) ){ //ɾ�������ʽ��������Ϊ2������
					//���ָ��Ⱥ��ʣ�ִ��delete����ĸ�ʽ���
					deleteCheck(stringseprate, aimArray);
				}
				break;
			case "UPDATE":
				if( lengthCheck( 5 ) ){ //���������ʽ��������Ϊ5������
					//���ָ��Ⱥ��ʣ�ִ��update����ĸ�ʽ���
					updateCheck(stringseprate, aimArray);
				}
				break;
			case "QUERY":
				if( lengthCheck( 3 ) ){ //��ѯ�����ʽ��������Ϊ3������
					//���ָ��Ⱥ��ʣ�ִ��query����ĸ�ʽ���
					queryCheck(stringseprate, aimArray);
				}
				break;
			case "1":
				if( lengthCheck( 1 ) & !stringseprate.duplicateNameMaker ){ //���������ʽ��������Ϊ1������,��������ʱ��ID��������
					//���ָ��Ⱥ��ʣ�ִ��query����ĸ�ʽ���
					System.out.println( userAdminUI.getHelpInfo("add_user_help") ); 
				}
				break;
			case "2":
				if( lengthCheck( 1 ) & !stringseprate.duplicateNameMaker ){ //���������ʽ��������Ϊ1������,��������ʱ��ID��������
					//���ָ��Ⱥ��ʣ�ִ��query����ĸ�ʽ���
					System.out.println( userAdminUI.getHelpInfo("delete_user_help") ); 
				}
				break;
			case "3":
				if( lengthCheck( 1 ) & !stringseprate.duplicateNameMaker ){ //���������ʽ��������Ϊ1������,��������ʱ��ID��������
					//���ָ��Ⱥ��ʣ�ִ��query����ĸ�ʽ���
					System.out.println( userAdminUI.getHelpInfo("update_user_help") ); 
				}
				break;
			case "4":
				if( lengthCheck( 1 ) & !stringseprate.duplicateNameMaker ){ //���������ʽ��������Ϊ1������,��������ʱ��ID��������
					//���ָ��Ⱥ��ʣ�ִ��query����ĸ�ʽ���
					System.out.println( userAdminUI.getHelpInfo("query_user_help") ); 
				}
				break;
			case "5":
				if( lengthCheck( 1 ) & !stringseprate.duplicateNameMaker ){ //���������ʽ��������Ϊ1������,��������ʱ��ID��������
					//���ָ��Ⱥ��ʣ�ִ��query����ĸ�ʽ���
					System.exit(0);//�˳�ϵͳ 
				}
				break;
			default:
				System.out.println( userAdminUI.getHelpInfo("wrong_command_help") ); 
			}
		}
		else{
			stringseprate.stringState = false;
			System.out.println( userAdminUI.getHelpInfo("please_command") ); 
		}
	}
	
	public boolean lengthCheck(int commandLength){
		boolean b = ( stringseprate.sepWordNum == commandLength ) ;//ָ������ϸ�Ҫ��
		if( !b ){
			System.out.println( userAdminUI.getHelpInfo("wrong_length_help") ); //������Դ�ļ�����ָ���������ʾ
			stringseprate.stringState = false;
		}
		else{
			stringseprate.stringState = true;
		}
		return b; //���ؽ�������Ⱥ���Ϊtrue������������Ϊfalse
	}
	
	public boolean dataRangeCheck(String dataKind,String dataString){
		boolean b = false;
		switch(dataKind){
		case "id":
			//id�û����ɼ�������û�з�Χ��顣�ھ��崦��ʱ����������ڣ��ٱ���

			break;
		case "name":
			b = true;//����û�з�ΧҪ��
			break;
		case "age":
			b = stringToData.toInt(dataKind,dataString) > 0 
				& stringToData.toInt(dataKind,dataString) < 150 
				& stringToData.toInt(dataKind,dataString) != -654321;//������0-150֮��,������������
			break;
		case "gender":
			//Ϊ���������԰������󣬸������԰���ġ��С���Ů����Ϊ�ж�����
			b = ( dataString.equals( userAdminUI.getHelpInfo("male") )  | 
					dataString.equals(  userAdminUI.getHelpInfo("female") ) | 
					dataString.toUpperCase().equals("MALE") | 
					dataString.toUpperCase().equals("FEMALE")) ;
			break;
		case "salary":
			b = stringToData.toFloat(dataKind,dataString) > 0 
				& stringToData.toFloat(dataKind,dataString) != (float) -65432.1 ;
			break;
		default:
			b=false;
		}
		return b; //������ݷ�Χ��ȷ��������
	}
	

	public void addCheck(StringFeature stringseprate ,ArrayList<User> aimArray){
		String name = stringseprate.usefulWord.get(1) ;
		String age = stringseprate.usefulWord.get(2) ;
		String gender = stringseprate.usefulWord.get(3) ;
		String salary = stringseprate.usefulWord.get(4) ;
		if( !dataRangeCheck( "name", name  ) |  
			!dataRangeCheck( "age", age  ) |
			!dataRangeCheck( "gender", gender  ) |
			!dataRangeCheck( "salary", salary  ) ){
			stringseprate.stringState = false;
			System.out.println( userAdminUI.getHelpInfo("wrong_add_help") ); 
		}
		else{
			stringseprate.stringState = true;
		}
	}
	
	public ArrayList<Integer> deleteCheck(StringFeature stringseprate, ArrayList<User> aimArray ){
		ArrayList<Integer> idFindListTemp1 = new  ArrayList<Integer>();
		ArrayList<Integer> idFindListTemp2 = new  ArrayList<Integer>();
		
		String idOrName = stringseprate.usefulWord.get(1) ;
		String sign = "="; //ɾ������ֻ֧�ֵȺ�
		idFindListTemp2 = dataExist.idExist( idOrName , sign , aimArray , idFindListTemp1 ) ;
		idFindListTemp1 = dataExist.nameExist( idOrName , sign , aimArray , idFindListTemp2 ) ;
		if(	idFindListTemp1.size() == 0  ){
			stringseprate.stringState = false;
			System.out.println( userAdminUI.getHelpInfo("wrong_delete_help") ); 
		}
		else{
			boolean b = idFindListTemp1.size() > 1; //�ҵ���idFindList�����ظ�id�������������ݴ���1����˵��������
			if(b){
				stringseprate.duplicateNameMaker = true ;
				System.out.println( userAdminUI.getHelpInfo("name_duplicate") ); 
			}
			stringseprate.stringState = true;
		}
		return idFindListTemp1;
	}
	
	public ArrayList<Integer> updateCheck(StringFeature stringseprate , ArrayList<User> aimArray){
		ArrayList<Integer> idFindListTemp1 = new  ArrayList<Integer>();
		
		String updateId = stringseprate.usefulWord.get(2) ;
		String updateIterm = stringseprate.usefulWord.get(3);
		String updateItermData = stringseprate.usefulWord.get(4);
		idFindListTemp1 = dataExist.idExist( updateId , "=" , aimArray , idFindListTemp1 ) ; //����ֻ��Ҫ����id���ڲ����ھ����ˣ�������==�ж�id
		if(	idFindListTemp1.size() == 0 ) {  
			stringseprate.stringState = false;
			System.out.println( userAdminUI.getHelpInfo("wrong_update_help") ); 
		}
		else if( !dataRangeCheck( updateIterm, updateItermData )  ){
			stringseprate.stringState = false;
			System.out.println( userAdminUI.getHelpInfo("wrong_update_help") ); 
		}
		else{
			stringseprate.stringState = true;
		}
		return idFindListTemp1;
	}
	
	public void queryCheck(StringFeature stringseprate , ArrayList<User> aimArray){
		String queryIterm = stringseprate.usefulWord.get(1);
		String queryItermData = stringseprate.usefulWord.get(2);
		if( !dataRangeCheck( queryIterm , queryItermData )  ){
			stringseprate.stringState = false; 
			System.out.println( userAdminUI.getHelpInfo("wrong_query_help") ); 
		}
		else{
			stringseprate.stringState = true;
		}
	}

	
}
