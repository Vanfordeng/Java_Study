package com.study_mars.Practice.src.org.marsdroid.useradmin.DataCheck;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.marsdroid.useradmin.logic.StringToData;
import org.marsdroid.useradmin.model.User;
import org.marsdroid.useradmin.ui.UserAdminUI;

public class DataExist {
	private UserAdminUI userAdminUI;
	StringToData stringToData;
	StringFeature stringFeature;
//	ArrayList<Integer> idFindList;
	
	public DataExist(){
		super();
		userAdminUI = new UserAdminUI() ;
		stringToData = new StringToData() ;
		stringFeature = new StringFeature() ;
	}
	
	public ArrayList<Integer> itemExist( String stringToSearch, String sign , String itemToSearch, ArrayList<User> aimArray , ArrayList<Integer>  idFindList ){
		idFindList =   searchString(stringToSearch, itemToSearch , sign , aimArray ,idFindList );
		if(!( idFindList.size() > 0 ) ){ //����ҵ���idFindListΪ�գ���˵��������
			System.out.println( userAdminUI.getHelpInfo( itemToSearch ) + userAdminUI.getHelpInfo("notfind") ); 
		}
		return idFindList; 
	}
	
	public ArrayList<Integer> idExist( String stringToSearch, String sign , ArrayList<User> aimArray , ArrayList<Integer>  idFindList ){
		return itemExist( stringToSearch,  sign , "id",  aimArray ,  idFindList ); 
	}
	
	public ArrayList<Integer> nameExist( String stringToSearch, String sign , ArrayList<User> aimArray , ArrayList<Integer>  idFindList  ){
		idFindList = itemExist( stringToSearch,  sign , "name",  aimArray ,  idFindList ); 
		idFindList = duplicateName( idFindList , stringFeature ); //������⣬�����ظ���id
		return idFindList;
	}
	
	public ArrayList<Integer> duplicateName( ArrayList<Integer>  idFindList ,StringFeature stringFeature ){
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		
		Set<Integer> setTemp = new TreeSet<Integer>();
		Collection<Integer> col = idFindList;
		setTemp.addAll(col);//�ü����������ظ���id�ţ���Ϊid����Ψһ�ġ�
		Iterator<Integer> itr = setTemp.iterator();//���Ҫ��setTempװ�����������ָʾ��
		while(itr.hasNext()){
				 tempList.add( itr.next() ) ;
		}
		
		return tempList;
	}
	
	public ArrayList<Integer> ageExist( String stringToSearch, String sign , ArrayList<User> aimArray , ArrayList<Integer> idFindList ){
		return itemExist( stringToSearch,  sign , "age",  aimArray ,  idFindList ); 
	}
	
	public ArrayList<Integer> genderExist( String stringToSearch, String sign , ArrayList<User> aimArray , ArrayList<Integer>  idFindList  ){
		return itemExist( stringToSearch,  sign , "gender",  aimArray ,  idFindList ); 
	}
	
	public ArrayList<Integer> salaryExist( String stringToSearch, String sign , ArrayList<User> aimArray , ArrayList<Integer>  idFindList ){
		return itemExist( stringToSearch,  sign , "salary",  aimArray ,  idFindList ); 
	}
	
	//��Ѱ����Ҫ����û����ݣ���������������id����Ϊϵͳ��id��Ψһ�ģ����Դ洢���ص�id����
	public ArrayList<Integer> searchString( String stringToSearch, String searchItem , String searchSign ,ArrayList<User> aimArray ,ArrayList<Integer> idFindList){
		for(int i = 0 ; i < aimArray.size(); i++){
			int id = aimArray.get(i).getId();
			String name = aimArray.get(i).getName();
			int age = aimArray.get(i).getAge();
			String gender = aimArray.get(i).getGender();
			float salary = aimArray.get(i).getSalary();
			switch( searchItem ){
			case "id":
				if( signExplain(searchSign, (float)id , stringToData.toFloat(searchItem, stringToSearch) )   ){
					idFindList.add(id);
				}
				break;
			case "name":
				if( name.equals( stringToSearch ) ){
					idFindList.add(id);
				}
				break;
			case "age":
				if( signExplain(searchSign, (float)age , stringToData.toFloat(searchItem, stringToSearch) ) ){
					idFindList.add(id);
				}
				break;
			case "gender":
				if( gender.equals( stringToSearch )  ){
					idFindList.add(id);
				}
				break;
			case "salary":
				if( signExplain(searchSign, salary , stringToData.toFloat(searchItem, stringToSearch) ) ){
					idFindList.add(id);
				}
				break;
			}
		}
		return idFindList;
	}
	
	//�����������ֻ���������͵�������Ч
	public boolean signExplain(String sign, float searchItem , float searchLimit){
		boolean b = false;
		switch( sign ){
		case ">=":
			b = searchItem >= searchLimit;
			break;
		case "<=":
			b = searchItem <= searchLimit;
			break;
		case ">":
			b = searchItem > searchLimit;
			break;
		case "<":
			b = searchItem < searchLimit;
			break;
		default:
			b = searchItem == searchLimit; //Ĭ�϶��ǵȺŲ�����
			break;
		}
		return b;
	}
}
