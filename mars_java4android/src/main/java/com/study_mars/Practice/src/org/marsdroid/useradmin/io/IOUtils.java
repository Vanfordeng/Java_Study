package com.study_mars.Practice.src.org.marsdroid.useradmin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;

import org.marsdroid.useradmin.DataCheck.DataExist;
import org.marsdroid.useradmin.DataCheck.InputDataCheck;
import org.marsdroid.useradmin.DataCheck.StringFeature;
import org.marsdroid.useradmin.logic.StringToData;
import org.marsdroid.useradmin.model.User;
import org.marsdroid.useradmin.ui.UserAdminUI;


//���൱�а����˳��õ�IO���ߺ���
public class IOUtils {
		
	private UserAdminUI userAdminUI ;
	private StringToData stringToData;
	private InputDataCheck inputDataCheck;
	ArrayList<Integer> idFindList ;
	DataExist dataExist ;
	UserInputIO userInputIO;
	
	
	
	public IOUtils(){
		userAdminUI = new UserAdminUI() ;
		stringToData = new StringToData() ;
		dataExist = new DataExist() ;
		userInputIO = new UserInputIO() ;
		idFindList = new ArrayList<Integer>() ;
		inputDataCheck = new InputDataCheck();
	}
	
	//�ú�������װ����Դ�ļ�
	public static Properties loadProperties(String dir,String fileName){
		Properties properties = new Properties();
		String projectDir = System.getProperty("user.dir");
		String propertiesFilePath = projectDir + File.separator + dir
				+ File.separator + fileName;
		try{
			properties.load(new FileInputStream(new File(propertiesFilePath)));
		}catch(Exception e){
			e.printStackTrace();
		}
		return properties;
	}
	
	//�ú������ڶ�ȡData�ļ�
	@SuppressWarnings("finally")
	public ArrayList<User> readFile(String dir,String fileName){
		ArrayList<User> userArrayList = new ArrayList<User>();
		BufferedReader bfreader = null ;
		StringFeature stringfeature = new StringFeature();
		
		String projectDir = System.getProperty("user.dir");
		String propertiesFilePath = projectDir + File.separator + dir
				+ File.separator + fileName;
		
		try{
			bfreader = new BufferedReader( new FileReader(propertiesFilePath) );
			while(true){
				String temp = bfreader.readLine();
				if(temp == null){
					break;
				}
				stringfeature = stringToData.stringSeprate(temp);
				if( stringfeature.sepWordNum == 5 ){ //ֻ���г��ȵļ�飬����Ϊ�����ļ�Ĭ���û��ǿ������ģ�������������������Ч��
					addData(stringfeature,userArrayList);
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
			System.out.println(userAdminUI.getHelpInfo("wrong_readfile") );
		}
		finally{
			try{
				bfreader.close();
			}
			catch(final Exception e){
				System.out.println(e);
			}
			return userArrayList;
		}
	}
	
	//���ڽ�����д��Data�ļ�
	public void writeFile(String dir,String fileName,ArrayList<User> arrayToWrite){
		BufferedWriter bfwriter = null ;
		
		String projectDir = System.getProperty("user.dir");
		String propertiesFilePath = projectDir + File.separator + dir
				+ File.separator + fileName;
		
		try{
			bfwriter = new BufferedWriter( new FileWriter(propertiesFilePath) );
			//������д�����ݱ��⣬�����ö�ȡ�ļ���ʱ���һ�оͲ���User����ˣ���ͳһ�����Ǿ�����������ʹ�User�࣬����ʾ��ʱ���ټ���ͷ����
			//bfwriter.write(dataTitle()); 
			for(int i = 0 ; i < arrayToWrite.size() ; i++){
					bfwriter.write(arrayToWrite.get(i).getId() + " " + arrayToWrite.get(i).getName() + " " + arrayToWrite.get(i).getAge() 
							+ " " + arrayToWrite.get(i).getGender() + " " + arrayToWrite.get(i).getSalary() );
					bfwriter.newLine();//����
			}
		}
		catch(Exception e){
			System.out.println(e);
			System.out.println(userAdminUI.getHelpInfo("wrong_writefile") );
		}
		finally{
			try{
				bfwriter.close();
			}
			catch(final Exception e){
				System.out.println(e);
			}
		}
	}
		
	//���ڶ�Ŀ�������б�д������
	public ArrayList<User> addData(StringFeature stringfeature,ArrayList<User> aimArray){
		
		try{
			int id = aimArray.size() + 1; //IDȡ�û�����Ŀ���ɡ���Ϊsizeȡ�õĴ�С����add֮ǰ�ģ�����+1ʹ����add֮��˳���Ǻ�
			//�����id�ǹ̶��ģ���Ҫ����д�㷨��������ѧ������������ѧ������Ӧ�����û���������ĲŶԡ�
			int age =  Integer.parseInt ( stringfeature.usefulWord.get(2) ) ;//��age���ַ���ת��������ֵ
			float salary =  Float.parseFloat ( stringfeature.usefulWord.get(4) ) ;//��Salary���ַ���ת��double����ֵ
			String name = stringfeature.usefulWord.get(1);
			String gender = stringfeature.usefulWord.get(3);
			//��Ӣ�ĵ��Ա�ת����������Ҫ�����ԣ�����������
			if( gender.equals("male") ){
				gender = userAdminUI.getHelpInfo("male");
			}
			else if(  gender.equals("female") ){
				gender = userAdminUI.getHelpInfo("female");
			}
			aimArray.add(new User(id, name, age, gender, salary));
		}
		catch(Exception e){
			System.out.println(e);
		}
		return aimArray;
	}
	
	//���ڶ�Ŀ�������б�ɾ������,�ж��㷨��inputDataCheck�����ж�deleteCheck����������ͬ��ֱ�ӵ���
	public ArrayList<User> deleteData(StringFeature stringfeature,ArrayList<User> aimArray){
		//�����ǣ�Delete 3 ���� Delete ����
		idFindList = inputDataCheck.deleteCheck(stringfeature, aimArray);
		if(	idFindList.size() > 0 ){ //���ж��Ƿ񶼴��ڣ����ж��Ƿ�������
			if( !stringfeature.duplicateNameMaker ){//���û��������ֱ��ɾ��������������Ѿ�������idFindList����Ϊ1�����ơ�
//				System.out.println( idFindList.get(0) -1 );
				aimArray.remove( idFindList.get(0) -1 ); //id�� = �����±��+1������Ҫʹ�������±��
			}
			else {
				aimArray = deleteDuplicate( stringfeature, aimArray ,idFindList );
//				stringfeature.duplicateNameMaker = false; //����ɾ��������ɣ���Ҫ��������׼Ϊ��,��������û�ã���ѭ�����ⲿ�ò����ġ�C������ָ�룬�����Եõ���
			}
			idFindList.removeAll(idFindList) ;//ִ����ɺ���ջ������������id
		}
		return aimArray;
	}
	
	//����ɾ���������ݣ����û�ѡ��id��ΪΨһ��ʾ��ֻ������delete name����������֮��
	public ArrayList<User> deleteDuplicate(StringFeature stringfeature,ArrayList<User> aimArray, ArrayList<Integer> idFindList2){
		//���������������ʾ���������ݣ�Ȼ�����û�ѡ��Ҫɾ���Ķ����id
		//System.out.println( userAdminUI.getHelpInfo("name_duplicate") ); //�����ݼ��ʱ�Ѿ�����ʾ������
		idFindPrint( idFindList2 , aimArray );
		
		String input = userInputIO.getInputLine();
		StringFeature stringfeatureTemp = new StringFeature();
		stringfeatureTemp = stringToData.stringSeprate(input);
		if(stringfeatureTemp.sepWordNum == 1){  //���������ַ���ֻ����һ�����ұ�����id���ڵ�
			int idChoose = stringToData.toInt( userAdminUI.getHelpInfo("id") , stringfeatureTemp.usefulWord.get(0) );
			aimArray.remove( idChoose - 1 ); //id�� = �����±��+1������Ҫʹ�������±��
		}
		return aimArray;
	}
	
	//���ڶ�Ŀ�������б��������
	public ArrayList<User> updateData(StringFeature stringfeature,ArrayList<User> aimArray){
		//�����ǣ�Update id:4 salary=5000.00
		//���ж�id�Ƿ����,Ȼ����ִ�и�������
		String updateItem = stringfeature.usefulWord.get(3);
		String updateData = stringfeature.usefulWord.get(4);
		idFindList = inputDataCheck.updateCheck(stringfeature, aimArray);
		if(	idFindList.size() > 0 ){ //�ж��Ƿ����ҵ�����������id
			if( updateItem.toUpperCase().equals("NAME") 
					| updateItem.toUpperCase().equals( userAdminUI.getHelpInfo("name") ) ){//Ϊ���������԰���Ҫ��
				aimArray.get( idFindList.get(0) -1 ).setName(updateData);//id�� = �����±��+1������Ҫʹ�������±��
			}
			else if( updateItem.toUpperCase().equals("AGE") 
					| updateItem.toUpperCase().equals( userAdminUI.getHelpInfo("age") )  ){
				aimArray.get( idFindList.get(0) -1 ).setAge(stringToData.toInt(updateItem, updateData) );//id�� = �����±��+1������Ҫʹ�������±��
			}
			else if( updateItem.toUpperCase().equals("GENDER") 
					| updateItem.toUpperCase().equals( userAdminUI.getHelpInfo("gender") )  ){
				//��Ӣ�ĵ��Ա�ת����������Ҫ�����ԣ�����������
				String genderTemp = updateData;
				if( genderTemp.equals("male") ){
					genderTemp = userAdminUI.getHelpInfo("male");
				}
				else if(  genderTemp.equals("female") ){
					genderTemp = userAdminUI.getHelpInfo("female");
				}
				//�Ѿ������԰�ת������Ա���Ϣupdate
				aimArray.get( idFindList.get(0) -1 ).setGender(genderTemp) ;//id�� = �����±��+1������Ҫʹ�������±��
			}
			else if( updateItem.toUpperCase().equals("SALARY") 
					| updateItem.toUpperCase().equals( userAdminUI.getHelpInfo("salary") )  ){
				aimArray.get( idFindList.get(0) -1 ).setSalary(stringToData.toFloat(updateItem, updateData) );//id�� = �����±��+1������Ҫʹ�������±��
			}
		}
		idFindList.removeAll(idFindList) ;//ִ����ɺ���ջ������������id
		
		return aimArray;
	}
	
	//���ڶ�Ŀ�������б��ѯ���ݣ���ѯ����ֻҪ���ز�ѯ����id����
	public void queryData(StringFeature stringfeature,ArrayList<User> aimArray){
		//�����ǣ�Query age > 30
		String queryItem = stringfeature.usefulWord.get(1) ;
		String queryData = stringfeature.usefulWord.get(2) ;
		String sign = stringfeature.querySign ;
		
		if( queryItem.toUpperCase().equals("GENDER") ){//���Ա�����԰������չ�һ��
			switch( queryData.toUpperCase() ){
			case "MALE":
				idFindList = dataExist.itemExist( userAdminUI.getHelpInfo("male") , sign , queryItem ,aimArray , idFindList ) ; 
				break;
			case "FEMALE":
				idFindList = dataExist.itemExist( userAdminUI.getHelpInfo("female") , sign , queryItem ,aimArray , idFindList ) ; 
				break;
			}
		}
		else{
			idFindList = dataExist.itemExist( queryData , sign , queryItem ,aimArray , idFindList ) ; 
		}
		//��ӡ�ҵ��ķ��ϵ�����
		idFindPrint( idFindList , aimArray );
		
		idFindList.removeAll(idFindList) ;//ִ����ɺ���ջ������������id
	}

	//��ӡ���е�����
		public String dataTitle(){ //���ݱ�ͷ����resources�����info.properties������԰�����
			String datatitle = userAdminUI.getHelpInfo("id") + " "
					+ userAdminUI.getHelpInfo("name") + " "
					+ userAdminUI.getHelpInfo("age") + " "
					+ userAdminUI.getHelpInfo("gender") + " "
					+ userAdminUI.getHelpInfo("salary") + " ";
			return datatitle;
		}
		
		public void dataPrint(ArrayList<User> aimArrayList){
			System.out.println( userAdminUI.getHelpInfo("splitline") );
			System.out.println( userAdminUI.getHelpInfo("print_all_data") );
			System.out.println(dataTitle());
			for(int i = 0 ; i < aimArrayList.size() ; i++){
				System.out.println(aimArrayList.get(i).getId() + " " + aimArrayList.get(i).getName() + " " + aimArrayList.get(i).getAge() 
						+ " " + aimArrayList.get(i).getGender() + " " + aimArrayList.get(i).getSalary() );
			}
			System.out.println( userAdminUI.getHelpInfo("splitline") );
		}
		
		public void idFindPrint(ArrayList<Integer> idFindList, ArrayList<User> aimArrayList ){
			if( idFindList.size() > 0 ){ //ֻ����idFindList��������ʱ�Ŵ�ӡ
				System.out.println(userAdminUI.getHelpInfo("print_idfind"));
				System.out.println(dataTitle());
				for(int i = 0 ; i < idFindList.size() ; i++){
					int j = idFindList.get(i) -1 ;//id�� = �����±��+1������Ҫʹ�������±��
					System.out.println(aimArrayList.get(j).getId() + " " + aimArrayList.get(j).getName() + " " + aimArrayList.get(j).getAge() 
							+ " " + aimArrayList.get(j).getGender() + " " + aimArrayList.get(j).getSalary() );
				}
			}
			else{
				System.out.println(userAdminUI.getHelpInfo("print_notfind"));
			}
		}
		
		
}
