package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Doctor on 2016/12/22.
 * 1.使用JDBC 技术连接Oracle数据库
 * 2.观察JDBC 中常用的类与接口的使用结构
 */
public class Java_Basic_JDBC_Oracle {
    //Oracle驱动程序类：oracle.oracle.jdbc.driver.OracleDriver
    private static final String DBDRIVER= "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL= "jdbc:oracle:thin:@localhost:1521:doctor";
    private static final String USER= "system";
    private static final String PASSWORD="dengqihong";


    public static void main(String[] args) throws SQLException {
        //在Java之中,所有的数据库操作的类和接口都保存在了java.sql包里面，在这个包里面核心的组成如下：
         /**
          * 1. 一个类：DriverManager类：
          * 2. 四个接口：Connection、Statement、ResultSet、PreparedStatement
          * 与IO包正好相反：一个接口，四个类，
          */

        /**@所有的JDBC连接数据库的操作流程都是固定的,按照如下的几步完成。
         *   1.加载数据库的驱动程序（向容器加载）
         *   2.进行数据库连接（通过DriverManager类完成，Connection表示连接）
         *   3.进行数据的操作主要四种：CRUD，通过（Statement、ResultSet、PreparedStatement）完成   //不建议使用JDBC去创建表
         *   4.关闭数据库操作以及连接（直接关闭连接就够了）
         */
        //Todo 一：加载驱动程序->所有的JDBC实际上都是由各个不同的数据库生产商提供的数据库驱动程序，这些驱动程序
        //Todo 都以*.jar文件给出来的，所以如果要使用那么就需要为其配置CLASSPATH，而后要设置驱动程序的类名称（包.类）

        //Todo 第一步：加载数据库驱动程序
        System.out.println("-----第一步：加载数据库驱动程序--------");
        try {
            //加载类使用：Class.forName("包.类")
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName(DBDRIVER);  //此时可以不适用import语句导入一个明确的类,而类名称是采用字符串的形式描述的
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Todo 第二步：连接数据库
        /**@如果想要连接数据库需要提供有如下的几个信息（前提是：数据库服务打开（Oracle 有两个服务要打开：OracleOraDb11g_home1TNSListener 和 一个是Oracle的主服务：OracleServiceORCL)）
         * 1.数据库的连接地址：jdbc:oracle:连接方式:@主机名称:端口名称:数据库的SID
         *    |—要连接本机的doctor数据库:jdbc:oracle:thin:@localhost:1521:doctor
         * 2.数据库的用户名：system
         * 3.数据库的密码:admin
         */
        //要连接数据库必须依靠DriverManager类完成,在此类定义有如下的方法：
        //public class DriverManager extends Object   //since JDK1.0
        //|—：连接数据库:public static Connection getConnection(String url,String user,String password) throws SQLException
        //在JDBC里面,每一个数据库连接都要求使用一个Connection对象进行封装，所有只要有一个新的Connection的对象，就表示要连接一次数据库
        //|—：
        //
        System.out.println("-----第二部：连接数据库--------");
        Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        System.out.println(conn);  //oracle.jdbc.driver.T4CConnection@621be5d1 不为null,说明连接成功了

        /** @此时的程序已经可以正常的连接Oracle数据库,可是很多时候你是连接不上Oracle数据库的。
         *  1.监听服务出现了错误(改了计算机名称)
         *     |—：监听的主机名称不是本机的计算机名称，也（如果是动态IP）不要使用IP地址：
         *     |—：监听配置文件路径：E:\product\11.2.0\dbhome_1\NETWORK\ADMIN
         *          |—：监听文件：listener.ora   //内容文件修改后一定要重新启动OracleOraDb11g_home1TNSListener 服务
         *          |—：监听的名称文件：tnsnames.ora  //内容文件修改后一定要重新启动OracleOraDb11g_home1TNSListener服务
         *     如果监听有问题,那么会出现如下的错误提示：Exception in thread "main" java.sql.SQLException: Listener refused the connection with the following error:
         *     ORA-12505, TNS:listener does not currently know of SID given in connect descriptor
         *     如果监听服务没有打开提示如下错误：
         *     Exception in thread "main" java.sql.SQLException: The Network Adapter could not establish the connection
         *  2.不能够找到指定的SID
         *    数据库的名字就是SID的名字,但是很多的时候回发现该名称不会自动注册，也就是说只有数据库名称，但是没有对应的SID名称，
         *    于是可以打开数据库的网络管理工具：Net Manager（E:\product\11.2.0\dbhome_1\BIN\launch.exe "E:\product\11.2.0\dbhome_1\network\tools" ..\network\tools\netmgr.cl）
         */

        /** Todo 结构总结：通过以上的操作可以发现,整个数据库进行连接操作的时候都是按照同样的步骤进行
         *  DriverManager 类取得Connection类的对象
         *  原来JDBC操作之中，在驱动数据库连接对象时，采用的是工厂设计模式，而DriverManager就是一个工厂类,那么客户端
         *  调用的时候回完全隐藏具体的实现子类。
         */
        /**Todo 总结：
         * 1 .以后不管连接何种关系型数据库，都一定通过DriverManager进行数据库连接
         * 2.每一个Connection接口对象就表示一个数据库连接,程序的最后必须关闭数据库连接。
         */

        //Todo 第四步：关闭数据库
        /**@Connection
         * public interface Connection extends Wrapper, AutoCloseable 实现了AutoCloseable接口
         * 提供有public void close() throws SQLException 方法
         */
        System.out.println("-----第四部：关闭数据库--------");
        conn.close();
    }
}
