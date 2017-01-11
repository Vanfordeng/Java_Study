package DAO_design_mode.DAO_Project.factory;

import java.sql.Connection;

import DAO_design_mode.DAO_Project.dao.IDeptDAO;
import DAO_design_mode.DAO_Project.dao.IEmpDAO;
import DAO_design_mode.DAO_Project.dao.dao.impl.DeptDAOImpl;
import DAO_design_mode.DAO_Project.dao.dao.impl.EmpDAOImpl;

/**
 * Created by Doctor on 2017/1/6.
 * 定义数据层工厂类 --- DAOFactory
 * 业务层要想进行数据层的调用，那么必须要去的IEmpDAO接口对象,但是不同层之间如果要想取得接口对象实例需要使用
 * 工厂设计模式,这个工厂类保存在factory 子包下
 *
 * TODO 使用工厂的特征就是外层不需要知道具体的子类
 * 对于业务层来说,只需要关注数据库的开关,Connection,取得工厂类实例（具体是取得IEmpDAO 子类实例）DAOFactory 去操作数据
 *
 */
public class DAOFactory {
    public static IEmpDAO getIEmpDaoInstance(Connection conn){
        return new EmpDAOImpl(conn);
    }

//    第四步：修改DAOFactory类,增加新的接口对象取得方法
    public static IDeptDAO getIDeptDAOInstance(Connection conn){
        return new DeptDAOImpl(conn);
    }
}
