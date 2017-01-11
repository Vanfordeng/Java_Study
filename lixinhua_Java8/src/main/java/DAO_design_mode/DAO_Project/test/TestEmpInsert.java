package DAO_design_mode.DAO_Project.test;

import java.util.Date;

import DAO_design_mode.DAO_Project.factory.ServiceFactory;
import DAO_design_mode.DAO_Project.vo.Emp;

/**
 * Created by Doctor on 2017/1/6.
 * 因为业务层设计完毕之后,整个项目的内核就设计完毕了,但是业务层是需要给其它层调用的.
 * 所以需要进行功能的测试，测试分为两种：
 *
 * 1.按照传统方式产生对象,而后调用里面的方法进行操作。保存在tes子包内
 */
//1.测试增加操作.
public class TestEmpInsert {
    public static void main(String[] args) {
        Emp vo = new Emp();
        vo.setEmpno(8817);
        vo.setEname("Doctor");
        vo.setJob("编程员");
        vo.setHirdate(new Date());
        vo.setSal(10.0);
        vo.setComm(100.0);
        try {
            System.out.println(ServiceFactory.getIEmpServiceInstance().insert(vo));
            //此时客户端的调用非常的简单，就是调用业务层方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
