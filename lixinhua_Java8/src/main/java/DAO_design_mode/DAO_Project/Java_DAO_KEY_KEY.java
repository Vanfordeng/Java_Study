package DAO_design_mode.DAO_Project;

/**
 * Created by Doctor on 2017/1/8.
 * 处理关系
 * 已经实现了雇员和部门的基础操作,但是在雇员里面存在有mgr和deptno 两个关联字段（在数据库里面有）
 * 1.修改VO类的定义
 *   |-：修改Emp.java
 *   |-:修改Dept.java
 * 2.修改DmpDAOImpl子类
 *   |-增加数据时需要考虑到雇员的领导以及部门编号
 *   |-修改数据时也需要考虑到（更换部门）
 *   |-查询单个雇员信息的时候也需要进行全部内容的查询
 *
 * Todo 如果要想很好的完成所有的开发要求,前提：单表操作必须非常熟练
 */
public class Java_DAO_KEY_KEY {
}
