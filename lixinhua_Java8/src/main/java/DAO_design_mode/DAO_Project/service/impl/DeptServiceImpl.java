package DAO_design_mode.DAO_Project.service.impl;

import java.util.List;
import java.util.Set;

import DAO_design_mode.DAO_Project.dbc.DatabaseConnection;
import DAO_design_mode.DAO_Project.factory.DAOFactory;
import DAO_design_mode.DAO_Project.service.IDeptService;
import DAO_design_mode.DAO_Project.vo.Dept;

/**
 * Created by Doctor on 2017/1/8.
 * 第六步：实现DeptServiceImpl子类
 */
public class DeptServiceImpl implements IDeptService{
    private DatabaseConnection dbc = new DatabaseConnection();

    @Override
    public boolean insert(Dept vo) throws Exception {
        try {
            if (DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findById(vo.getDeptno()) == null){
                return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doCrate(vo);
            }
            return false;
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean update(Dept vo) throws Exception {
        try {
            return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doUpdate(vo);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public boolean delete(Set<Integer> ids) throws Exception {
        try {
            return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doRemoveBatch(ids);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public List<Dept> list() throws Exception {
        try {
            return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findAll();
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }

    @Override
    public Dept get(int id) throws Exception {
        try {
            return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findById(id);
        } catch (Exception e) {
            throw e;
        } finally {
            this.dbc.close();
        }
    }
}
