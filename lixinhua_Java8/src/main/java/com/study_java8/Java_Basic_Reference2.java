package com.study_java8;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by Doctor on 2016/10/8.
 */
public class Java_Basic_Reference2 {
    public static void main(String[] args){
        //简单Java类的编写原则：
        /*
         * 类名称 = 表名称；
         * 属性名称（类型） = 表字段（类型）
         * 一个实例化对象 =  一行记录；
         * 多个实例化对象（对象数组） = 多行记录（外键）
         * 引用关系 = 外键约束；
         */

        //第一步：设置数据
        Member m =  new Member(27,"邓启红");  //独立的对象
        Member child =  new Member(0,"邓天易");
        Car c = new Car("宝马320");           //独立的对象
        Car cc =  new Car("法拉利F9");
        //第二步：设置关系
        m.setCar(c);             //一个人用拥有一个车
        c.setMember(m);          //一辆车属于一个人
        child.setCar(cc);        //一个孩子有一辆车
        cc.setMember(child);     //一个车属于一个孩子
        m.setChild(child);       //一个人有一个孩子
        //第三步：取出关系
        //通过人找到车
        System.out.println(m.getCar().getInfo());
        //通过车找到人
        System.out.println(c.getMember().getInfo());
        //通过人找到他孩子的信息
        System.out.println(m.getChild().getInfo());
        //通过人找到他孩子的车的信息
        //代码链        //代码链        //代码链        //代码链
        System.out.println(m.getChild().getCar().getInfo());

    }
}
//这样的设计思路在Java之中称为：合成设计模式
//面向对象的设计方式应该说所有的设计思路来源于生活
//引用是实现两个不同类型之间互相关联的主要手段
//引用是实现两个不同类型之间互相关联的主要手段
//引用是实现两个不同类型之间互相关联的主要手段
class Member{
    private int mid;
    private String name;
    private Member child;
    //car有实例化对象表示有车
    //car为null表示没有车
    private  Car car; // 表示属于人的车

    public Member(int mid,String name){
        this.mid =  mid;
        this.name = name;
    }
    public String getInfo(){
        return  "人员编号： " + this.mid + "\t姓名：" + this.name;
    }
    public void setChild(Member child){
        this.child = child;
    }
    public void setCar(Car car){
        this.car =  car;
    }
    public Member getChild(){
        return this.child;
    }
    public Car getCar(){
        return this.car;
    }

}
class Car{
    private Member member; //车属于一个人
    private String pname;

    public Car(String pname){
        this.pname = pname;
    }
    public String getInfo(){
        return "车的名字：" + this.pname;
    }
    public void setMember(Member member){
        this.member = member;
    }
    public Member getMember(){
        return this.member;
    }
}