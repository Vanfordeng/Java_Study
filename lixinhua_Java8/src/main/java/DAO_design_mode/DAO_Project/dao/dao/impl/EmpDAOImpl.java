package DAO_design_mode.DAO_Project.dao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import DAO_design_mode.DAO_Project.dao.IEmpDAO;
import DAO_design_mode.DAO_Project.vo.Emp;

/**
 * Created by Doctor on 2017/1/6.
 * 数据层实现类
 * 数据层需要被业务层调用，数据层需要进行数据库的执行（PreparedStatement），由于在开发之中一个业务层操作,需要执行
 * 多个数据层的调用。所以数据库的打开与关闭操作应该由业务层控制比较合理。
 *
 * 所有的数据层实现类要求包装在dao.impl子包下
 *
 * Todo  子类里面唯一需要注意的就是构造方法一定要接收一个Connection的接口对象
 */
public class EmpDAOImpl implements IEmpDAO{
    private Connection conn; //需要利用Connection对象操作
    private PreparedStatement pstmt ;

    /**
     * 如果要想使用数据层进行原子性的功能操作实现,必须要提供有Connection接口对象<br>
     * 另外，由于开发之中业务层要调用数据层,所以数据库的打开与关闭交由业务层处理
     * @param conn 表示数据库的连接对象
     */
    //* Todo  子类里面唯一需要注意的就是构造方法一定要接收一个Connection的接口对象
    public EmpDAOImpl(Connection conn){
        this.conn = conn;
    }

    @Override
    public boolean doCrate(Emp vo) throws Exception {
        String sql = " INSERT INTO emp(empno,ename,job,hiredate,sal,comm) VALUES (?,?,?,?,?,?) ";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,vo.getEmpno());   //雇员编号
        this.pstmt.setString(2,vo.getEname());  //雇员姓名
        this.pstmt.setString(3,vo.getJob());  //雇员职位
        this.pstmt.setDate(4,new java.sql.Date(vo.getHirdate().getTime()));  //雇员聘用时间
        this.pstmt.setDouble(5,vo.getSal());  //雇员薪水
        this.pstmt.setDouble(6,vo.getComm());  //雇员年终
        return this.pstmt.executeUpdate() > 0 ;
        //这里面不需要关注conn对象的关闭，交给业务层处理
    }

    @Override
    public boolean doUpdate(Emp vo) throws Exception {
        String sql = " UPDATE emp SET ename=?,job=?,hiredate=?,sal=?,comm=? WHERE empno =? ";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,vo.getEname());  //雇员姓名
        this.pstmt.setString(2,vo.getJob());  //雇员职位
        this.pstmt.setDate(3,new java.sql.Date(vo.getHirdate().getTime()));  //雇员聘用时间
        this.pstmt.setDouble(4,vo.getSal());  //雇员薪水
        this.pstmt.setDouble(5,vo.getComm());  //雇员年终
        this.pstmt.setInt(6,vo.getEmpno());   //雇员编号
        return this.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        if (ids == null || ids.size() == 0){ //没有要删除的数据
            return false;
        }
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM emp WHERE empno In(");
        Iterator<Integer> iter = ids.iterator();
        while (iter.hasNext()){
            sql.append(iter.next()).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(") ");
        this.pstmt = this.conn.prepareStatement(sql.toString());  //StringBuffer 转换为String 使用toString()方法
        return this.pstmt.executeUpdate() == ids.size();
    }

    @Override
    public Emp findById(Integer id) throws Exception {
        Emp vo = null;
        String sql = " SELECT empno,ename,job,hiredate,sal,comm FROM emp WHERE empno =? " ;
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,id);
        ResultSet resultSet = this.pstmt.executeQuery();
        if (resultSet.next()){
            vo = new Emp(); //在使用vo实例化对象之前必须实例化该对象new
            vo.setEmpno(resultSet.getInt(1));
            vo.setEname(resultSet.getString(2));
            vo.setJob(resultSet.getString(3));
            vo.setHirdate(resultSet.getDate(4));
            vo.setSal(resultSet.getDouble(5));
            vo.setComm(resultSet.getDouble(6));
        }
        return vo;
    }

    @Override
    public List<Emp> findAll() throws Exception {
        List<Emp>  all = new ArrayList<Emp>();
        String sql = " SELECT empno,ename,job,hiredate,sal,comm FROM emp ";
        this.pstmt = this.conn.prepareStatement(sql);
        ResultSet resultSet = this.pstmt.executeQuery();
        while (resultSet.next()){
            Emp vo = new Emp(); //在使用vo实例化对象之前必须实例化该对象new
            vo.setEmpno(resultSet.getInt(1));
            vo.setEname(resultSet.getString(2));
            vo.setJob(resultSet.getString(3));
            vo.setHirdate(resultSet.getDate(4));
            vo.setSal(resultSet.getDouble(5));
            vo.setComm(resultSet.getDouble(6));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Emp> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
        List<Emp>  all = new ArrayList<Emp>();
        String sql = " SELECT * FROM "
                +" (SELECT empno,ename,job,hiredate,sal,comm,ROWNUM rn "
                + " FROM emp "
                +" WHERE "+ column + " LIKE ? AND ROWNUM<=?) temp "
                +" WHERE temp.rn >? ";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,"%" + keyWord + "%");
        this.pstmt.setInt(2,currentPage * lineSize);
        this.pstmt.setInt(3,(currentPage -1) * lineSize);
        ResultSet resultSet = this.pstmt.executeQuery();
        while (resultSet.next()){
            Emp vo = new Emp(); //在使用vo实例化对象之前必须实例化该对象new
            vo.setEmpno(resultSet.getInt(1));
            vo.setEname(resultSet.getString(2));
            vo.setJob(resultSet.getString(3));
            vo.setHirdate(resultSet.getDate(4));
            vo.setSal(resultSet.getDouble(5));
            vo.setComm(resultSet.getDouble(6));
            all.add(vo);
        }
        return all;
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        String sql = " SELECT COUNT(empno) FROM emp WHERE " + column + " LIKE ? " ;
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,"%" + keyWord + "%");   //如果此处不加%,会导致如果模块查询keyWord为“”,无法统计数据数量（实际运行结果）
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return null;
    }

    /**Todo 现在要求使用emp表（empno,ename,job,hiredate,sal,comm）实现如下的操作功能：
     * 【客户提的所有的需求都叫业务层】
     *  【业务层】1.实现雇员数据的添加,但是需要保证被添加的雇员编号不会重复
     *       |-[数据层]判断要增加的雇员编号是否存在
     *       |-[数据层]如果雇员编号不存在这进行数据的保存操作
     *  【业务层】2.实现雇员数据的修改操作
     *       |-[数据层]执行数据的修改操作
     *  【业务层】3.实现多个雇员数据的删除操作
     *       |-[数据层]执行雇员的限定的删除操作
     *  【业务层】4.可以根据雇员编号查找到一个雇员的信息
     *       |-[数据层]根据雇员编号查询指定的雇员数据
     *  【业务层】5.可以查询所有雇员的信息
     *       |-[数据层]查询所有的雇员数据
     *  【业务层】6.可以实现数据的分页显示，同时又可以返回所有的雇员数量
     *       |-[数据层]雇员数据的分页查询
     *       |-[数据层]使用COUNT()函数统计出所有的雇员数量
     */
}
