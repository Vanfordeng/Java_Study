package DAO_design_mode.DAO_Project.junit_test;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import DAO_design_mode.DAO_Project.factory.ServiceFactory;
import DAO_design_mode.DAO_Project.vo.Dept;

import static org.junit.Assert.*;

/**
 * Created by Doctor on 2017/1/8.
 */
public class IDeptServiceTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {
        Dept vo = new Dept();
        vo.setDeptno(11);
        vo.setDname("测试部门");
        vo.setLoc("北京");
        TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().insert(vo));
    }

    @Test
    public void testUpdate() throws Exception {
        Dept vo = new Dept();
        vo.setDeptno(11);
        vo.setDname("开发");
        vo.setLoc("成都");
        TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().update(vo));
    }

    @Test
    public void testDelete() throws Exception {
        Set<Integer> ids = new HashSet<Integer>();
        ids.add(11);
        TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().delete(ids));
    }

    @Test
    public void testList() throws Exception {
        TestCase.assertTrue(ServiceFactory.getIDeptServiceInstance().list().size() > 0);
    }

    @Test
    public void testGet() throws Exception {
        TestCase.assertNotNull(ServiceFactory.getIDeptServiceInstance().get(1));
    }
}