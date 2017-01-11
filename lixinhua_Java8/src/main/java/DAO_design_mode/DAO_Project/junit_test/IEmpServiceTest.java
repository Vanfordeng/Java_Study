package DAO_design_mode.DAO_Project.junit_test;

import junit.framework.TestCase;

import org.junit.*;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import DAO_design_mode.DAO_Project.factory.ServiceFactory;
import DAO_design_mode.DAO_Project.vo.Emp;

import static org.junit.Assert.*;

/**
 * Created by Doctor on 2017/1/8.
 * Junit 测试
 *
 * Todo
 */
public class IEmpServiceTest {
    private  static int empno;
    static {
        empno = new Random().nextInt(1000);  //动态生成一个随机数
    }

    @org.junit.Test
    public void testInsert() throws Exception {
        Emp vo = new Emp();
        vo.setEmpno(empno);
        vo.setEname("Doctor");
        vo.setJob("医生aaaaaaaaaa");
        vo.setHirdate(new Date());
        vo.setSal(10.0);
        vo.setComm(100.0);
        try {
            TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().insert(vo));
            //此时客户端的调用非常的简单，就是调用业务层方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() throws Exception {
        Emp vo = new Emp();
        vo.setEmpno(631);
        vo.setEname("Doctor");
        vo.setJob("医生dddddddddddd");
        vo.setHirdate(new Date());
        vo.setSal(10.0);
        vo.setComm(100.0);
        try {
            TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().update(vo));
            //此时客户端的调用非常的简单，就是调用业务层方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete() throws Exception {
        Set<Integer> set = new HashSet<Integer>();
        set.add(364);
        TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().delete(set));
    }

    @Test
    public void testGet() throws Exception {
        TestCase.assertNotNull(ServiceFactory.getIEmpServiceInstance().get(8812));
    }

    @Test
    public void testList() throws Exception {
        TestCase.assertTrue(ServiceFactory.getIEmpServiceInstance().list().size() > 0);
    }

    @Test
    public void testList1() throws Exception {
        Map<String,Object> map = ServiceFactory.getIEmpServiceInstance().list(2,5,"ename", "");
        int count = (Integer) map.get("empCount");
        List<Emp> all = (List<Emp>) map.get("allEmps");
        TestCase.assertTrue(count > 0 && all.size() > 0);
    }
}