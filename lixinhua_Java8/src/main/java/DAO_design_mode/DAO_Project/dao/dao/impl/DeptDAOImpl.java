package DAO_design_mode.DAO_Project.dao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import DAO_design_mode.DAO_Project.dao.IDeptDAO;
import DAO_design_mode.DAO_Project.vo.Dept;

/**
 * Created by Doctor on 2017/1/8.
 * 第三步：定义DeptDAOImpl类
 */
public class DeptDAOImpl implements IDeptDAO {
    private Connection conn;
    private PreparedStatement pstmt;
    public DeptDAOImpl(Connection conn){
        this.conn = conn;
    }
    @Override
    public boolean doCrate(Dept vo) throws Exception {
        String sql = "INSERT INTO dept(deptno,dname,loc) VALUES (?,?,?)";
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setInt(1,vo.getDeptno());
        this.pstmt.setString(2,vo.getDname());
        this.pstmt.setString(3,vo.getLoc());
        return this.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doUpdate(Dept vo) throws Exception {
        String sql = "UPDATE dept SET dname=?,loc=? WHERE deptno=? " ;
        this.pstmt = this.conn.prepareStatement(sql);
        this.pstmt.setString(1,vo.getDname());
        this.pstmt.setString(2,vo.getLoc());
        this.pstmt.setInt(3,vo.getDeptno());
        return this.pstmt.executeUpdate() > 0 ;
    }

    @Override
    public boolean doRemoveBatch(Set<Integer> ids) throws Exception {
        if (ids == null || ids.size() == 0){
            return false;
        }
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM dept WHERE deptno IN(");
        Iterator<Integer> iter = ids.iterator();
        while (iter.hasNext()){
            sql.append(iter.next()).append(",");
        }
        sql.delete((sql.length() -1),sql.length()).append(") ");
        this.pstmt = this.conn.prepareStatement(sql.toString());
        return this.pstmt.executeUpdate()  == ids.size();
    }

    @Override
    public Dept findById(Integer id) throws Exception {
        Dept vo = null;
        String sql = "SELECT deptno,dname,loc FROM dept WHERE deptno=? " ;
        this.pstmt = conn.prepareStatement(sql);
        this.pstmt.setInt(1,id);
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()){
            vo = new Dept();
            vo.setDeptno(rs.getInt(1));
            vo.setDname(rs.getString(2));
            vo.setLoc(rs.getString(3));
        }
        return vo;
        //Todo 发现与EmpDAOImpl的内容很相像。如果要消除这些重复代码。需要把反射理解得非常清楚
    }

    @Override
    public List<Dept> findAll() throws Exception {
       List<Dept> all = new ArrayList<Dept>();
        String sql = "SELECT deptno,dname,loc FROM dept " ;
        this.pstmt = conn.prepareStatement(sql);
        ResultSet rs = this.pstmt.executeQuery();
        if (rs.next()){
            Dept vo = new Dept();
            vo.setDeptno(rs.getInt(1));
            vo.setDname(rs.getString(2));
            vo.setLoc(rs.getString(3));
            all.add(vo);
        }
        return all;
    }

    @Override
    public List<Dept> findAllSplit(Integer currentPage, Integer lineSize, String column, String keyWord) throws Exception {
       throw new Exception("此方法未实现");
    }

    @Override
    public Integer getAllCount(String column, String keyWord) throws Exception {
        throw new Exception("此方法未实现");
    }
}
