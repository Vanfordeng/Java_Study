package DAO_design_mode.DAO_Project.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Doctor on 2017/1/6.
 * 开发Value Object(VO)
 * 严格来讲：最终操作的都是数据库,或者更 严格来说是数据库中的数据表
 * 我们认为数据层如果想要操作的话,需要一种类型来表示数据表。才能方便的进行数据操作。这就是（VO:简单Java类）
 * 简单Java类---对应数据库表
 *
 * 现在的程序严格来讲已经给出了四个层次，不同层次之间一定要进行数据的传递，但是既然要操作的是指定的数据表，所以
 * 数据的结构必须要和表的接口一一对应。那么自然就可以想到简单Java类（po、to、pojo、vo）
 *
 */
public class Emp implements Serializable{
    /**@在实际的工作之中,针对于简单Java类的开发给出如下的要求：
     * 1.考虑到日后程序有可能出现的分布式应用问题,所以简单Java类必须要实现java.io.Serializable接口。
     * 2.简单Java类的名称必须与表名称保持一致；
     *     |—表名称有可能采用这样的名字：student_info,类名称：StudentInfo
     * 3.类中的属性不允许使用基本数据类型,都必须使用基本数据类型的包装类
     *     |—基本数据类型的数值型默认值为0，而如果是包装类默认值就是null(要的就是这个null)
     * 4.类中可以定义有多个构造方法,但是必须要保留有一个无参构方法；
     * 5.类中的属性必须使用private关键字封装,封装后的属性必须提供有Setter、Getter方法
     * 【可选要求，基本不用】覆写equals(),toString(),hashCode()
     */
    //不管有多少张表,只要是实体表,那么一定要写简单Java类，而且不要试图想着一次性将所有的表都转换到位.
    //而且所有的简单Java类都要保存在VO包中.
    private Integer empno;
    private String ename;
    private String job;
    private Date hirdate;
    private Double sal;
    private Double comm;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Date getHirdate() {
        return hirdate;
    }

    public void setHirdate(Date hirdate) {
        this.hirdate = hirdate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }
}
