package com.study_java8.Class_eg;

/**
 * Created by Doctor on 2016/9/21.
 */
public class SimpleJavaClass {
    public static void main(String[] args){
        Emp emp = new Emp(1,"dengqihong",8000.0,20.0);
        System.out.println(emp.getInfo());
    }
}
class Emp{
    private int eEmpID;
    private String eName;
    private double ePay;
    private double comm;

    public Emp(){};
    public Emp(int e,String n,double p,double c){
        eEmpID =e;
        eName = n;
        ePay = p;
        setComm(c);
    };

    public void seteEmpID(int e){
        eEmpID =e;
    }
    public void seteName(String n){
        eName = n;
    }
    public void setePay(double p){
        ePay = p;
    }
    public void setComm(double c){
        comm = c;
    }
    public int geteEmpID(){
        return eEmpID;
    }
    public String geteName(){
        return eName;
    }
    public double getePay(){
        return ePay;
    }
    public double getComm(){
        return comm;
    }

    public String getInfo(){
        return "员工编号：" + eEmpID + "\n" +
                "员工姓名：" + eName + "\n" +
                "员工工资：" + ePay + "\n" +
                "员工绩效：" + comm;
    }
}
