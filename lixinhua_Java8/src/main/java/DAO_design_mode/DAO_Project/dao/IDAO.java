package DAO_design_mode.DAO_Project.dao;

/**
 * Created by Doctor on 2017/1/8.
 * TODO 在整个DAO接口定义的过程之中，不同的表区别在于：VO类、主键类型。那么为了解决重复问题,使用泛型实现接口的继承操作
 */

import java.util.List;
import java.util.Set;

/**
 * 定义公共的DAO操作接口标准,基本的功能包括：增加,修改全部，删除数据，根据编号查询，查询全部，分页显示，数据统计
 * @param <K> 表示当要操作的主键类型，由子接口实现
 * @param <V> 表示要操作的VO类型, 由子接口实现
 */
public interface IDAO<K,V> {
    /**
     * 实现数据的增加操作
     * @param vo  包含了要增加的数据的VO对象
     * @return 数据保存成功返回true,否则返回false
     * @throws Exception  SQL执行异常
     */
    public boolean doCrate(V vo) throws Exception;  //如果要求严格,需要对每种异常做处理 throws SQLException,SQLxxxx,xxxx,xxx\

    /**
     * 实现数据的修改操作,本次修改是根据id进行全部字段数据的修改
     * @param vo 包含了要求改的数据的信息,一定要提供ID内容
     * @return 数据修改成功返回true,否则返回false
     * @throws Exception  SQL执行异常
     */
    public boolean doUpdate(V vo) throws Exception;

    /**
     * 执行数据的批量删除操作,所有要删除的数据以Set集合的形式保存
     * @param ids 包含了所有要删除的数据ID，不包含重复内容
     * @return 删除成功返回true,（删除的数据个数与要删除的数据个数相同），否则返回false
     * @throws Exception SQL执行异常
     */
    public boolean doRemoveBatch(Set<K> ids) throws Exception;

    /**
     * 根据雇员编号查询指定的雇员信息
     * @param id 要查询的雇员编号
     * @return 如果雇员信息存在，则将数据以VO类对象的形式返回，如果雇员数据不存在，则返回null
     * @throws Exception SQL 执行异常
     */
    public V findById(K id) throws Exception;

    /**
     * 查询指定数据表的全部几率,并且以集合的形式返回
     * @return 如果表中有数据，则所有的数据会分钟为VO对象而后利用List集合返回，<br>
     * 如果没有数据,那么集合的长度为0（Size()==0,不是null）
     * @throws Exception SQL 执行异常
     */
    public List<V> findAll() throws Exception;

    /**
     * 分页进行数据的模糊查询，查询的结果以集合的形式返回
     * @param currentPage  当前所在的页
     * @param lineSize   每一页显示的数据函数
     * @param column  要进行欧虎查询的数据列
     * @param keyWord 模糊查询的关键字
     * @return如果表中有数据，则所有的数据会分钟为VO对象而后利用List集合返回，<br>
     * 如果没有数据,那么集合的长度为0（Size()==0,不是null）
     * @throws Exception SQL 执行异常
     */
    public List<V> findAllSplit(Integer currentPage,Integer lineSize,String column,String keyWord) throws  Exception;

    /**
     * 进行模糊查询数据量的统计，如果表中没有纪律统计的结果就是0
     * @param column  要进行欧虎查询的数据列
     * @param keyWord  模糊查询的关键字
     * @return 返回表中的数据量，如果没有数据返回0
     * @throws Exception SQL 执行异常
     */
    public Integer getAllCount(String column,String keyWord) throws Exception;

    /**Todo 现在要求使用emp表（empno,ename,job,hiredate,sal,comm）实现如下的操作功能：
     * 【客户提的所有的需求都叫业务层】
     *  【业务层】1.实现雇员数据的添加,但是需要保证被添加的雇员编号不会重复
     *       |-[数据层]判断要增加的雇员编号是否存在
     *       |-[数据层]如果雇员编号不存在这进行数据的保存操作
     *  【业务层】2.实现雇员数据的修改操作
     *       |-[数据层]执行数据的修改操作
     *  【业务层】3.实现多个雇员数据的删除操作
     *       |-[数据层]执行雇员的限定的删除操作
     *  【业务层】4.可以根据雇员编号查找到一个雇员的信息
     *       |-[数据层]根据雇员编号查询指定的雇员数据
     *  【业务层】5.可以查询所有雇员的信息
     *       |-[数据层]查询所有的雇员数据
     *  【业务层】6.可以实现数据的分页显示，同时又可以返回所有的雇员数量
     *       |-[数据层]雇员数据的分页查询
     *       |-[数据层]使用COUNT()函数统计出所有的雇员数量
     */
}
