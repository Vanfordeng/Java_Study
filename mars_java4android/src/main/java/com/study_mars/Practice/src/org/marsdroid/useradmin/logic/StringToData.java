package com.study_mars.Practice.src.org.marsdroid.useradmin.logic;

import java.util.ArrayList;

import org.marsdroid.useradmin.DataCheck.StringFeature;
import org.marsdroid.useradmin.ui.UserAdminUI;


//����ķ����������û����ַ���ת����������Ҫ����������
public class StringToData {
	private UserAdminUI userAdminUI;
	StringFeature stringseprate;
	
	public StringToData(){
		super();
		userAdminUI = new UserAdminUI();
	}
	
	public StringToData( StringFeature stringseprate ){
		super();
		userAdminUI = new UserAdminUI();
		this.stringseprate = stringseprate;
	}
	
	
	public int toInt(String stringName,String stringData){
		int b = -654321;
		try{
			b = Integer.parseInt(stringData);
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println( stringName + userAdminUI.getHelpInfo("not_number")  );
		}
		return b; 
	}
	
	public float toFloat(String stringName,String stringData){
		float b = (float) -65432.1;
		try{
			b = Float.parseFloat(stringData);
		}catch (Exception e) {
			//e.printStackTrace();
			System.out.println( stringName + userAdminUI.getHelpInfo("not_number")  );
		}
		return b; 
	}
	
	
	//�ѳ��ַ��������ʸ������֣��Ҽ�¼�ַ���������
	public StringFeature stringSeprate(String stringInput){
		StringFeature stringFeatureTemp = new StringFeature();
		String stringTemp1[] = null;
		ArrayList<String> arrayListTemp1 = new ArrayList<String>(); 
		ArrayList<String> arrayListTemp2 = new ArrayList<String>();
		
		stringTemp1 =stringInput.trim().split("\\ "); //���ݿո��һ�β���ַ���
		for(int i = 0 ; i < stringTemp1.length ; i++ ){
			arrayListTemp1.add(stringTemp1[i]); //����ֵ��ַ�����ֵ����ʱ�������б�
		}
		arrayListTemp2 = stringSeprateBy(":",arrayListTemp1 ,stringFeatureTemp ); //����ð�ż�������ַ��������������Լ�д�ĺ���
		arrayListTemp1 = stringSeprateBy(">=",arrayListTemp2 ,stringFeatureTemp ); //����>=�ż�������ַ��������������Լ�д�ĺ�������Ҫ�����ȼ�
		arrayListTemp2 = stringSeprateBy("<=",arrayListTemp1 ,stringFeatureTemp ); //����<=�ż�������ַ��������������Լ�д�ĺ�������Ҫ�����ȼ�
		arrayListTemp1 = stringSeprateBy("=",arrayListTemp2 ,stringFeatureTemp ); //���ݵȺż�������ַ��������������Լ�д�ĺ���
		arrayListTemp2 = stringSeprateBy(">",arrayListTemp1 ,stringFeatureTemp ); //����>�ż�������ַ��������������Լ�д�ĺ���
		arrayListTemp1 = stringSeprateBy("<",arrayListTemp2 ,stringFeatureTemp ); //����<�ż�������ַ��������������Լ�д�ĺ���
		
		
		stringFeatureTemp.sepWordNum = arrayListTemp1.size();
		stringFeatureTemp.usefulWord = arrayListTemp1;
		return stringFeatureTemp;
	}
	
	//�ж��Ƿ��ǲ�ѯ��Ȼ�󴢴��ѯ�ķ��ţ�>,<,=,>=��<=��
	public void queryGetSign(ArrayList<String> arrayListInput,ArrayList<String> arrayListAfter, String sign ,StringFeature stringseprate){
		String s = null;
		if(arrayListAfter.size() > 0 ){
			if( arrayListAfter.get(0).trim().toUpperCase().equals("QUERY") ){
				for(int i = 0; i < arrayListInput.size(); i++ ){
					if( arrayListInput.get(i).contains(sign) ){
						s = sign;
					}
				}
			}
		}
		//�ж��ǲ��ǲ�ѯ��������Һ���stringSeprateSign���ţ��򴢴�÷��ŵ�stringseprate.querySign
		if( s != null &&  !s.isEmpty()  ){  //ʹ�ö�·�룬��ΪisEmpty�Կ��ַ��ᱨ����������ǿ��ַ�����=null�����жϣ��������isEmpty�Ϳ��Բ���ִ�У��Ͳ��ᱨ��
			stringseprate.querySign = s;
		}
	}
	
	//���������ַ����β�����飬������������ղ�ֺ�Ľ���������б�
	public ArrayList<String> stringSeprateBy(String stringSeprateSign,ArrayList<String> arrayListInput , StringFeature stringseprate){
		ArrayList<String> arrayListTemp = new ArrayList<String>(); //���հ�Ҫ������������б��ô��ǳ��ȿ�������
		
		for(int i = 0; i < arrayListInput.size()  ; i++){
			String stringTemp1[] = null; //�������飬��ʱ���stringInput[i]��Ҫ���ֺ�Ľ��,ÿ��ѭ��ǰ�����һ�ν��
			if( arrayListInput.get(i) != null ){
				int j = 0; //��ֵ�ǰstringTemp[i]�����ַ�����õ����±�
				stringTemp1 = arrayListInput.get(i).trim().split("\\" +stringSeprateSign);
				j = stringTemp1.length;
				for(int m=0;m< j; m++){
					if(  stringTemp1[m] != null & !stringTemp1[m].isEmpty() ){
						arrayListTemp.add( stringTemp1[m].trim() );
					}
				}
			}
		}
		queryGetSign(arrayListInput, arrayListTemp, stringSeprateSign , stringseprate);
		return arrayListTemp;
	}
		
}
