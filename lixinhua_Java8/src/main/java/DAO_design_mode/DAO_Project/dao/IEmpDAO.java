package DAO_design_mode.DAO_Project.dao;

import java.util.List;
import java.util.Set;

import DAO_design_mode.DAO_Project.vo.Emp;

/**
 * Created by Doctor on 2017/1/6.
 *
 * Todo 定义emp表的数据层操作标准
 * Todo 定义emp表的数据层操作标准
 *
 * 开发数据层
 * 数据层最终是交给业务层进行调用的，所以业务层必须知道数据层的执行标准,即：业务层需要明确知道数据层的操作方法
 * 但是不需要知道它的具体实现。那么这个怎么设计呢？
 *
 * 【数据层 与 数据库】之间使用的JDBC 标准来访问.（不同层之间的访问,一定是需要有标准存在。标准就是一个接口的定义）
 * 【数据层 与 业务层】对于数据层也是一样的，数据层最终是要交给业务层访问,数据层标准。（图）
 * @对于数据层的接口给出如下的开发要求：
 *  数据层既然是进行数据操作的,那么就将其保存在dao包下;
 *  既然不同的数据表的操作有可能使用不同的数据层开发,那么就针对于数据表进行命名
 *     |-emp表：那么数据层的标准（接口）就应该定义为IEmpDAO
 *  对于整个数据层的开发严格来讲就只要两类功能：
 *     |-数据更新：建议它的操作方法以doXxxx()的形式命名，例如：doCreate(),doUpdate(),doDelete()
 *     |-数据查询:对于查询分为两种形式
 *        |-：查询表中数据：以findXxxx（）形式命名：findById(),findByName(),findAll()
 *        |-: 统计表中的数据:以getXxxx()形式命名：例如：getAllCount()
 */
public interface IEmpDAO extends IDAO<Integer,Emp> {

}
