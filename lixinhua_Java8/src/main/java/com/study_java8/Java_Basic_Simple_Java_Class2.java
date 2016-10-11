package com.study_java8;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Doctor on 2016/10/9.
 * 一对多
 * 要求：可以根据一个城市找到它所对应的省份的信息
 * 可以通过一个省份找到所有城市的信息
 * 简单Java类的编写原则：
 * 类名称 = 表名称；
 * 属性名称（类型） = 表字段（类型）
 * 一个实例化对象 =  一行记录；
 * 多个实例化对象（对象数组） = 多行记录（外键）
 * 引用关系 = 外键约束；
 */
class Province{
    private int pID;
    private String pName;
    private City[] cities;
    //getter 、setter略，无参构造略
    public Province(int pID,String pName){
        this.pID = pID;
        this.pName = pName;
    }

    public void setCities(City[] cities){
        this.cities = cities;
    }
    public City[] getCities(){
        return this.cities;
    }

    public String getInfo(){
        return "省份编号：" + this.pID + "\t省份名称：" + this.pName;
    }
}

class City{
    private int cID;
    private String cName;
    private Province province;
    //getter 、setter略，无参构造略
    public City(int cID,String cName){
        this.cID = cID;
        this.cName = cName;
    }
    public void  setProvince(Province province){
        this.province =  province;
    }
    public Province getProvince(){
        return  this.province;
    }
    public String getInfo(){
        return "城市编号：" + this.cID + "\t城市名称：" + this.cName;
    }
}

public class Java_Basic_Simple_Java_Class2 {
    public static void main(String[] args){
        //第一步：设置独立的对象
        City city1 =  new City(1010,"成都");
        City city2 =  new City(1012,"简阳");
        City city3 =  new City(1013,"资阳");
        City city4 =  new City(1014,"德阳");
        Province province =  new Province(10,"四川");
        //第二步:设置对象的关系
        province.setCities(new City[]{city1,city2,city3,city4});
        city1.setProvince(province);
        city2.setProvince(province);
        //第三步：取出关系
        // 可以根据一个城市找到它所对应的省份的信息
        System.out.println(city1.getProvince().getInfo());
        System.out.println(city2.getProvince().getInfo());
        // 可以通过一个省份找到所有城市的信息
        for (int i = 0; i < province.getCities().length ; i++) {
            System.out.println(province.getCities()[i].getInfo());
        }
        //如果要对城市进行增加,删除，修改，查找。。会比较麻烦.造成所有困哪的关键在于数组的使用上,但是又不能不适用数组

    }
}
