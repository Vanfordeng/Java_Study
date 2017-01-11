package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by Doctor on 2017/1/5.
 * 利用Statement接口实现数据表的更新操作与查询操作
 */
public class Java_Basic_JDBC_Statement {

    //Oracle驱动程序类：oracle.oracle.jdbc.driver.OracleDriver
    private static final String DBDRIVER= "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL= "jdbc:oracle:thin:@localhost:1521:doctor";
    private static final String USER= "system";
    private static final String PASSWORD="dengqihong";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //当取得了数据库连接对象之后，那么实际上就意味着可以进行数据库操作了，而数据库操作可以使用最简单的Statement
        //接口完成，要想取得Statement接口的实例化对象则需要依靠Connection接口提供的方法完成.
        //|—取得Statement接口对象：public Statement createStatement() throws SQLException
        //当取得了Statement接口对象之后,可以使用一下的两个方法实现数据库操作：（一个Connection可以打开多个Statement）
        //Statement定义：public interface Statement extends Wrapper, AutoCloseable
        //数据更新：public int executeUpdate(String sql) throws SQLException  //更新行数
        //数据查询：public ResultSet executeQuery(String sql) throws SQLException  //（返回一个ResultSet集合和类集框架没关系）


        System.out.println("-----第一步：加载数据库驱动程序--------");
        Class.forName(DBDRIVER);
        System.out.println("-----第二部：连接数据库--------");
        Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        System.out.println(conn);
        //Todo 编写数据库创建脚本
        /**
         DROP TABLE member PURGE ;
         DROP SEQUENCE myseq ;
         CREATE SEQUENCE myseq ;
         CREATE TABLE member(
            mid   NUMBER ,
            name  VARCHAR2(20) ,
            birthday DATE DEFAULT SYSDATE ,
            age NUMBER(3),
            note CLOB ,
            CONSTRAINT pk_mid PRIMARY KEY(mid)
         ) ;
         */
        //数据的更新操作最关键性的问题是每次更新完成之后都一定会返回影响的行数。
        //INSERT INTO 表名称 (列,列，...) VALUES (值,值,....);
        System.out.println("-----第三步：进行数据库的数据操作-------");
        Statement statement  = conn.createStatement();
        //Todo 在编写SQL的过程里面，如果太长的时候需要增加换行，那么请一定要记住前后加上空格
        System.out.println("::更新数据::");
        System.out.println("-->数据增加");
        //Todo 增加的SQL语句：INSERT INTO member (mid,name,birthday,age,note) VALUES (myseq.nextval,'张三'，TO_DATE（'1998-10-10','yyyy-mm-dd'),17,'是个人')
        String sql = " INSERT INTO member (mid,name,birthday,age,note) VALUES " +
                " (myseq.nextval,'张三'，TO_DATE（'1998-10-10','yyyy-mm-dd'),17,'是个人') " ;
        int len = statement.executeUpdate(sql); //执行SQL返回更新的数据行  （Todo 数据库如果多执行几次,存储的数据是无序的.相当于多开了几个线程，去执行同一个数据库。）
        System.out.println("\t影响的数据行：" + len);
        System.out.println("-->数据更新");
        //Todo 更新的SQL语句：UPDATE member SET name='李四',birthday=SYSDATE,age=30 WHERE mid IN(3,2,5);
        String sql_update = " UPDATE member SET name='李四',birthday=SYSDATE, age=30 WHERE mid IN(7,3,5) ";  //String 中不需要加“；”号
        int len_update = statement.executeUpdate(sql_update);
        System.out.println("\t更新的行数：" + len_update);
        //Todo 删除的SQL语句：DELETE FROM member WHERE mid IN (1,3,6,7);
        System.out.println("-->数据删除");
        String sql_delete = "DELETE FROM member WHERE mid IN (1,3,6,7)";
        int len_delete  =statement.executeUpdate(sql_delete);
        System.out.println("\t删除的行数：" + len_delete);   //重复执行,影响行数为：0

        /**
         * 整个更新操作完成后会清楚点感受到,原来只是更换了一个字符串而已,没有本质的变化。
         */
        System.out.println("::查询数据::");
        //每当使用SELECT 进行查询的时候实际上会将所有的查询结果返回给有用户显示,而显示的基本结构就是表的形式，可是如果要进行查询
        //进行查询，查询的结果应该返回给程序,由用户来进行处理，那么久必须有一种类型可以接收所有的返回结果。在数据里里面虽然可能有几百张数据表
        //但是整个数据表的组成数据类型都是固定的，所以在ResultSet设计过程之中是按照数据类型的方式来保存返回数据的。（图）
        //在ResultSet里面提供有如下的吩咐：
        //向下移动指针并判断是否有数据行：public boolean next() throws SQLException
                //|--:移动之后就可以直接去的当前数据行中所有数据列的内容了
        //取出数据列的内容:getInt()、getDouble()、getString()、getDate() ete.
        System.out.println("-->查询数据");
        String sql_select = " SELECT mid,name,age,birthday,note FROM member " ;
        ResultSet resultSet  = statement.executeQuery(sql_select);

        while (resultSet.next()){  //循环取出返回的每一行数据
            //取出的数据item 顺序
            int mid = resultSet.getInt("mid");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Date birthday = resultSet.getDate("birthday");
            String note = resultSet.getString("note");
            //等同如下：
//            int mid = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//            int age = resultSet.getInt(3);
//            Date birthday = resultSet.getDate(4);
//            String note = resultSet.getString(5);
            System.out.println( mid + "," + name + "," + age + "," + birthday + "," + note + ","  );
        }

        /**@关于ResultSet的使用有如下的几点忠告：
         * 1.在使用getXxxx 取出列数据的时候,强烈建议按照给定的顺序取  (JDBC以前交换数据会出错)
         * 2.每一列的数据只能够按照顺序取一次  (JDBC以前交换数据会出错)
         * 以上的代码在取列内容的时候重复编写了列名称，这一点实际上可以忽略，因为在写SQL语句的时候就已经明确给出了列名称了，
         * 那么可以按照序号取出
         * 既然已经可以执行查询了，那么久可以继续添加各种复杂查询了，例如：限定查询，分组统计查询，子查询 etc 。只需要更换SQL语句就行了
         */

        System.out.println("-----第四部：关闭数据库--------");
        resultSet.close(); //是可选的，并且无用的
        statement.close();  //是可选的，并且无用的
        conn.close();  //连接关闭了,statement，resultSet也会自动关闭

        /**
         * @总结：
         * 通过演示可以发现Statement接口的执行步骤几乎都是固定的,并且最方便的是可以直接执行SQL的字符串操作，但是
         * 任何的开发都不可能去使用Statement,以后都使用PreparedStatement。
         *
         */
    }
}
