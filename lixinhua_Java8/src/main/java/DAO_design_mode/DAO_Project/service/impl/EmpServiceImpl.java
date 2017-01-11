package DAO_design_mode.DAO_Project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import DAO_design_mode.DAO_Project.dbc.DatabaseConnection;
import DAO_design_mode.DAO_Project.factory.DAOFactory;
import DAO_design_mode.DAO_Project.service.IEmpService;
import DAO_design_mode.DAO_Project.vo.Emp;

/**
 * Created by Doctor on 2017/1/6.
 * 业务层的实现类
 * 业务层的实现类的核心功能：
 *  |—：负责控制数据库的打开和关闭，当存在了业务层对象后其目的就是为了操作数据库；即：业务层对象实例化之后就必须准备好数据库连接
 *  |—：根据DAOFactory调用getImpDAOInstance()方法而后取得IEmpDAO接口对象
 *  业务层的实现类保存在dao.impl子包中
 */
public class EmpServiceImpl implements IEmpService {

    //在DatabaseConnection 这个类对象内部就提供有一个数据库连接了的实例化对象
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Emp vo) throws Exception {
        try {
            //要增加的雇员编号如果不存在,则findById()返回的结果就是null,null表示可以进行新的雇员数据的保存
            //Todo 整个过程中使用的都是代码链 （UiAutomator）
            //Todo 整个过程中使用的都是代码链
            if (DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findById(vo.getEmpno()) == null){
                return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).doCrate(vo);
            }
            return false;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Emp vo) throws Exception {
        try {
            return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).doUpdate(vo);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return  DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Emp get(int ids) throws Exception {
        try {
            return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findById(ids);
        }catch (Exception e){
           throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Emp> list() throws Exception {
        try {
            return DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findAll();
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    @Override
    public Map<String, Object> list(int currentPage, int linSize, String column, String keyWord) throws Exception {
        try {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("allEmps",DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).findAllSplit(currentPage,linSize,column,keyWord));
            map.put("empCount",DAOFactory.getIEmpDaoInstance(this.dbc.getConnection()).getAllCount(column,keyWord));
            return map;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }

    //TODO 不同层之间的访问依靠的就是工程类和接口进行操作。
    //TODO 日后只要写了接口了，取得实例化对象就用工程类
}
