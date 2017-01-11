package DAO_design_mode.DAO_Project.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Doctor on 2017/1/6.
 * 本类专门负责数据库的连接与关闭操作，在实例化类对象时就意味着要进行数据库的开发<br>
 * 所以在本类的构造方法里面进行数据库驱动加载与数据库连接取得
 */
public class DatabaseConnection {
    private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL = "jdbc:oracle:thin://@localhost:1521:doctor";
    private static final String USER = "system";
    private static final String PASSWORD ="dengqihong";
    private Connection conn = null ;

    /**
     * 在构造方法里面为conn对象进行实例化,可以直接取得数据库的连接对象<br>
     * 由于所有的操作都是局域数据库完成的，所以如果数据库取不到连接，那么也就意味着所有的操作都可以停止了
     */
    public DatabaseConnection(){
        try {
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 取得一个数据库的连接对象
     * @return
     */
    public Connection getConnection(){
        return this.conn;
    }

    /**
     * 负责数据库的关闭
     */
    public void close(){
        if (this.conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /** Todo 整个的操作过程之中,DatabaseConnection只是无条件的提供有数据连接(按照JAVA8的说话，就叫供给型操作)
     *  Todo 至于说有多少个线程（conn 对象）需要找到此类，它都不关心。
     *  Todo 额外话题：
     *  从最早的DAO设计模式来讲实际上还会考虑到有一个问题,多数据库间的移植问题。
     *  此时就需要设置一个专门的表示连接标准的接口 （图）
     *  考虑到显示的开发之中，说提供的第三方框架平台越来越完善，所以以上的复杂设计就慢慢被忽略掉了。
     */
}
