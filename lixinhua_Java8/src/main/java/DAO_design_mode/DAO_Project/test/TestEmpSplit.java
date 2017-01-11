package DAO_design_mode.DAO_Project.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import DAO_design_mode.DAO_Project.factory.ServiceFactory;
import DAO_design_mode.DAO_Project.vo.Emp;

/**
 * Created by Doctor on 2017/1/6.
 * 测试分页查询
 */
public class TestEmpSplit {
    public static void main(String[] args) {
        try {
            Map<String,Object> map = ServiceFactory.getIEmpServiceInstance().list(2,5,"ename", "");
            int count = (Integer) map.get("empCount");
            System.out.println("数据量：" + count);
            List<Emp> all = (List<Emp>) map.get("allEmps");
            Iterator<Emp> iterator = all.iterator();
            while (iterator.hasNext()){
                Emp vo = iterator.next();
                System.out.println(vo.getEname() + "," + vo.getJob());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Todo 整个操作流程客户端的调用非常容易，了不需要设计到具体的数据存储细节
}
