package DAO_design_mode.DAO_Project.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import DAO_design_mode.DAO_Project.vo.Emp;

/**
 * Created by Doctor on 2017/1/6.
 * 开发业务层
 * Todo 定义emp表的业务层的执行标准,此类一定要负责数据库的打开与关闭操作
 * Todo 此类可以通过DAOFactory 类取得IEmpDAO接口对象
 * 业务层是真正留给外部调用的，可能是控制层，或者是直接调用。既然业务层也是由不同的层进行调用，所以业务层开发的首要任务就是
 * 定义业务层的操作标准
 * 开发业务层标准——IEmpService
 * 业务层也可以称为Service层，既然是描述的是emp表的操作，所以名称就定位了IEmpService,并且保存在Service的子包下，
 * 当时对于业务层的方法定义并没有明确的要求,只不过个人强烈建议还是协商有意义的统一名称；
 */
public interface IEmpService {
    /**
     * 实现雇员数据的增加操作,本次操作要调用IEmpDao接口的如下方法;<br>
     * <li>需要调用IEmpDao.findById()方法，判断要增加的数据的id是否已经存在
     * <li>如果现在要增加的数据编号不存在则调用IEmpDAO.doCreate()方法,返回操作的结果
     * @param vo 包含了要增加数据的VO对象
     * @return  如果增加数据的ID重复或者保存失败返回false，否则返回true
     * @throws Exception SQL执行异常
     */
    public boolean insert(Emp vo) throws  Exception;

    /**
     * 实现雇员数据的修改操作,本次电泳IEmpDAO.doUpdate()方法,本次修改属于全部内容的修改；
     * @param vo 包含了要修改数据的VO对象
     * @return 修改成功返回true,否则返回false
     * @throws Exception  SQL执行异常
     */
    public boolean update(Emp vo) throws Exception;

    /**
     * 执行雇员数据的删除操作,可以删除多个雇员信息,调用IEmpDao.doRemoveBatch()方法
     * @param ids 包含了全部要删除数据的集合,没有重复数据
     * @return 删除成功返回true,否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean delete(Set<Integer> ids) throws Exception;

    /**
     * 根据雇员编号查找雇员的完整信息，调用IEmpDAO.findById()方法
     * @param ids  要查找的雇员编号
     * @return 如果找到了雇员信息以VO对象返回，否则返回null
     * @throws Exception SQL 执行异常
     */
    public Emp get(int ids) throws Exception;

    /**
     * 查询全部雇员信息，调用IEmpDAO.findALL()方法
     * @return 查询结果以List集合的形式返回,如果没有数据则集合的长度为0
     * @throws Exception  SQL 执行异常
     */
    public List<Emp> list() throws Exception;

    /**
     *实现数据的模糊查询与数据统计,要调用IEmpDao接口的两个方法：<br>
     * <li>调用IEmpDAO.findAllSplit()方法,查询出所有的表数据，返回List<Emp>;
     * <li>调用IEmpDao.getAllCount()方法，查询所有的数据量，返回Integer,
     * @param currentPage  当前所在页
     * @param linSize   每页显示的记录数
     * @param column   模糊查询的数据列
     * @param keyWord   模糊查询的关键字
     * @return  本方法由于需要返回多重数据类型，所以使用Map集合返回,由于类型不统一，所以所有value的类型设置为Object.返回内容如下：
     * <li>key = allEmps.value = IEmpDAO.findAllSplit()返回结果，List<Emp>
     * <li>key = empCount.value = IEmpDao.getAllCount()返回结果，Integer
     * @throws Exception  SQL 执行异常
     */
    public Map<String,Object> list(int currentPage,int linSize,String column,String keyWord) throws Exception;

    //TODO 本接口中方法的设计完全符合于之前的分析过程

}
