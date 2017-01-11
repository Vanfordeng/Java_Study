package DAO_design_mode.DAO_Project.vo;

import java.io.Serializable;

/**
 * Created by Doctor on 2017/1/8.
 * 要求使用部门表（Dept）实现如下的功能：
 *  1.【业务层】进行部门数据的添加
 *        |—：[数据层] 判断要增加的部门编号是否存在,如果不存在则可以添加
 *        |—：[数据层] 实现部门数据的保存
 *  2.【业务层】进行部门数据的修改
 *        |—：[数据层]进行部门数据修改
 *  3.【业务层】进行部门数据的删除
 *        |—：[数据层]进行部门数据删除
 *  4.【业务层】进行部门数据的全部查询
 *        |—：[数据层]查询全部
 *  5.【业务层】可以根据部门编号查询一个部门完整信息
 *        |—：[数据层]根据编号查询
 *  第一步：定义Dept.java类
 *  第二步：定义IDeptDAO接口
 *  第三步：定义DeptDAOImpl类
 *  第四步：修改DAOFactory类,增加新的接口对象取得方法
 *  第五步：开发IDeptService接口
 *  第六步：实现DeptServiceImpl子类
 *  第七步：修改服务层工厂ServiceFactory,增加型的接口对象取得方法
 *  在使用之前还是需要进行我们的测试。
 */
public class Dept implements Serializable{
    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    private Integer deptno ;
    private String dname ;
    private String loc ;
}
