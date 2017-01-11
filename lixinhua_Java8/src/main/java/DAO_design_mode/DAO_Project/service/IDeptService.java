package DAO_design_mode.DAO_Project.service;

import java.util.List;
import java.util.Set;

import DAO_design_mode.DAO_Project.vo.Dept;

/**
 * Created by Doctor on 2017/1/8.
 * 第五步：开发IDeptService接口
 * Todo 业务型接口最好别再做抽象了，因为做抽象有的方法实现由的方法没实现。用户直接调用不太好
 */
public interface IDeptService {
    public boolean insert(Dept vo) throws Exception;
    public boolean update(Dept vo) throws Exception;
    public boolean delete(Set<Integer> ids) throws  Exception;
    public List<Dept> list() throws Exception;
    public Dept get(int id) throws Exception;
}
