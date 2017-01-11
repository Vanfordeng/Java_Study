package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * Created by Doctor on 2017/1/5.
 * 掌握批处理的操作流程
 * 掌握JDBC中提供的失误处理操作
 */
public class Java_Basic_JDBC_Batch {

    //Oracle驱动程序类：oracle.oracle.jdbc.driver.OracleDriver
    private static final String DBDRIVER= "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL= "jdbc:oracle:thin:@localhost:1521:doctor";
    private static final String USER= "system";
    private static final String PASSWORD="dengqihong";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * 在之前所使用的全部的数据库操作严格来讲是属于JDBC1.0 中就规定的操作模式,而最新的JDBC 是4.0的版本
         * 但是没人去用,但是从JDBC2.0开始增加了一些神奇的功能：可滚动的结果集，可以利用结果集执行增加,更新，删除操作，批处理
         * ResultSet本来是返回结果的,但是可以删除，更新，增加 违背了原始的设计（不同）,
         * 所谓的批处理指的是一次性向数据库之中发出多条操作命令,一起执行,如果想要操作批处理主要还是在Statement与
         * PreparedStatement上定义的：
         *   |—：Statement接口定义的方法：
         *      增加批处理语句：public void addBatch(String sql) throws SQLException
         *      执行批处理语句|：public int[] executeBatch() throws SQLException
         *          |—：返回的数据是包含了所有批处理语句的执行结果.是每条语句执行影响的函数放在数组中
         *   |—：PreparedStatement接口定义的方法：
         *      增加批处理语句: public void addBatch() throws SQLException
         */
        System.out.println("-----第一步：加载数据库驱动程序--------");
        Class.forName(DBDRIVER);
        System.out.println("-----第二部：连接数据库--------");
        Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        conn.setAutoCommit(false);  //设置事务不自动提交
        System.out.println("-----第三步：进行数据库的数据操作-------");
        System.out.println("执行批处理");
        Statement statement  = conn.createStatement();
        statement.addBatch("INSERT INTO member(mid,name) VALUES (myseq.nextval,'测试A')");
        statement.addBatch("INSERT INTO member(mid,name) VALUES (myseq.nextval,'测试B')");
        statement.addBatch("INSERT INTO member(mid,name) VALUES (myseq.nextval,'测试C')");
        statement.addBatch("INSERT INTO member(mid,name) VALUES (myseq.nextval,'测试D')");
        statement.addBatch("INSERT INTO member(mid,name) VALUES (myseq.nextval,'测试E')");
        int[] result  = statement.executeBatch();
        try {
            System.out.println(Arrays.toString(result));
//            conn.commit();  //如果没有错误,进行提交
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();  //如果出现异常,则进行回滚
        }
        /** 如果假设以上的五条批处理属于一组关联的操作,如果中间有一条语句执行失败,其它的不应该成功
         *  在批处理操作的过程之中,由于JDBC具备有自动的事务提交,所以一旦中间的语句出现了错误,那么结果就是
         *  错误前的语句正常执行,错误后的语句就不执行了，很明显不应该。
         *  可以使用JDBC提供的失误处理操作来进行手工的事务控制，所有的操作方法都在Connection中定义
         *      |-: 事务提交：public void commit() throws SQLException   （没错了就提交）
         *      |-: 事务回滚：public void rollback() throws SQLException
         *      |-: 设置是否自动提交：public void setAutoCommit(boolean autoCommit) throws SQLException
         */


        System.out.println("-----第四部：关闭数据库--------");
        conn.close();  //连接关闭了,statement，resultSet也会自动关闭

        //以上只是演示一下如何手工处理事务，而在实际的工作上，这些操作意义不大。(意义不大不是说没用,而是在日后的容器会自动处理)
        //Connection 接口定义了事务的处理方法：setAutoCommit(),commit(),rollback()
    }
}
