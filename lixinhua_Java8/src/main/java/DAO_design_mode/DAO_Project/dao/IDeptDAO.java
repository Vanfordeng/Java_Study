package DAO_design_mode.DAO_Project.dao;

import DAO_design_mode.DAO_Project.vo.Dept;

/**
 * Created by Doctor on 2017/1/8.
 * 第二步：定义IDeptDAO接口
 */
public interface IDeptDAO extends IDAO<Integer,Dept>{
//    public boolean doCreate(Dept vo) throws Exception;
//    public boolean doUpdate(Dept vo) throws Exception;
//    public boolean doRemoveBatch(Set<Integer> ids) throws Exception;
//    public Dept findById(Integer id) throws Exception;
//    public List<Dept> findAll() throws Exception;

    //几乎所欲的数据表都应该具备有举出的（CRUD）功能,（增加,修改全部，删除数据，根据编号查询，查询全部，分页显示，数据统计）
    //那么这些功能的方法每个接口都要重复定义
    //在整个DAO接口定义的过程之中，不同的表区别在于：VO类、主键类型。那么为了解决重复问题,使用泛型实现接口的继承操作

}
