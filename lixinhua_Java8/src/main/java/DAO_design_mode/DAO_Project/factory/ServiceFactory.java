package DAO_design_mode.DAO_Project.factory;

import DAO_design_mode.DAO_Project.service.IDeptService;
import DAO_design_mode.DAO_Project.service.IEmpService;
import DAO_design_mode.DAO_Project.service.impl.DeptServiceImpl;
import DAO_design_mode.DAO_Project.service.impl.EmpServiceImpl;

/**
 * Created by Doctory on 2017/1/6.
 *  TODO 定义业务层的工厂类 ——ServiceFactory
 * 业务层应该交给控制层调用，那么也需要准备出工厂类，该类同样保存在factory子包下
 * 如果从实际的开发来讲，业务层应该分为两种：
 *   |-：前台业务逻辑：可以将其保存在service.front 包中，工厂类：ServiceFrontFactory
 *   |-：后台业务路基：可以将其保存在service.back 包中，工厂类：ServiceBackFactory
 */
public class ServiceFactory {
    public static IEmpService getIEmpServiceInstance(){
        return new EmpServiceImpl();
    }
    public static IDeptService getIDeptServiceInstance(){
        return new DeptServiceImpl();
    }

    //Todo 在实际编写之中，子类永远是不可见的，同时在整个操作里面,控制层完全看不到数据库的任何操作，没有任何的JDBC代码
    //Todo 外面调用的时候,只知道调用该操作能够保存,但是怎么保存的，保存到什么地方去.完全不知道。每层做每层的事
}
