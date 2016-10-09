package com.study_java8;

/**
 * Created by Doctor on 2016/10/9.
 * 简单Java类升级
 */
class Dept{
    private  int deptno;
    private String dname;
    private String loc;
    private Emp[] emps; //多个雇员
    public void setEmps(Emp[] emps){
        this.emps =  emps;
    }
    public Emp[] getEmps(){
        return  this.emps;
    }


    //setter,getter,无参数构造略

    public Dept(int deptno,String dname,String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    public String getInfo(){
        return  "部门编号：" + this.deptno + "、部门名称：" + this.dname + "、部门位置：" + this.loc;
    }

}
class  Emp{
    private  int empno;
    private String ename;
    private String job;
    private double sal;
    private double comm;
    private Dept dept; //表示对应的部门信息
    private Emp mgr; //表示雇员对应的领导

    //setter,getter,无参数构造略

    public void setMgr(Emp mgr){
        this.mgr = mgr;
    }
    public Emp getMgr(){
        return  this.mgr;
    }
    public void setDept(Dept dept){
        this.dept = dept;
    }
    public Dept getDept (){
        return  this.dept;
    }
    public Emp(int empno,String ename,String job,double sal,double comm){
        this.empno =  empno;
        this.ename =  ename;
        this.job = job;
        this.sal = sal;
        this.comm = comm;
    }
    public String getInfo(){
        return  "员工编号：" + this.empno + "、员工姓名：" + this.ename + "、员工职位：" +  this.job + "、员工薪资：" + this.sal + "、员工绩效:" + this.comm;
    }
}


public class Java_Basic_Simple_Java_Class1 {
    public static void main(String[] args){
        //第一步：设置数据
        //1.产生各自的独立对象
        Dept dept = new Dept(10,"ACCOUTNTING","NEWYOUR");
        Emp ea = new Emp(7369,"SMITH1","Engingeer",7500.00,41.0);
        Emp eb = new Emp(7368,"SMITH2","Engingeer",7600.00,42.0);
        Emp ec = new Emp(7367,"SMITH3","Engingeer",7700.00,43.0);
        //2.设置雇员和领导的关系
        ec.setMgr(eb);
        ea.setMgr(ec);
        //3.设置雇员和部门关系
        ea.setDept(dept);
        eb.setDept(dept);
        ec.setDept(dept);
        dept.setEmps(new Emp[]{ea,eb,ec}); //一个部门拥有多个雇员
        //第二部：取出数据
        //1.通过雇员找到领导信息和部门信息
        System.out.println(ea.getInfo());
        System.out.println("\t | -领导信息："+ea.getMgr().getInfo());
        System.out.println("\t | -部门信息："+ea.getDept().getInfo());
        //2.根据部门找到所有雇员以及每个雇员的领导信息
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(dept.getInfo());
        for (int i = 0; i < dept.getEmps().length; i++) {
            System.out.println("\t | -员工信息：" + dept.getEmps()[i].getInfo());
            if (dept.getEmps()[i].getMgr() != null){
                System.out.println("\t \t | -领导信息：" + dept.getEmps()[i].getMgr().getInfo());
            }else {
                System.out.println("\t \t | -此员工无领导");
            }
        }

        //整个代码之中都是依靠代码链进行数据的取出的。这个是习惯性的代码编写
    }
}
