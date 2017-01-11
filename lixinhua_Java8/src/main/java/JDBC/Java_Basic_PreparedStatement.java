package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by Doctor on 2017/1/5.
 * 将分析Statement接口操作的不足,以及通过各种势力讲解PreparedStatement接口的使用
 * 此部分内容时整个JDBC最为重要的组成部分。
 */
public class Java_Basic_PreparedStatement {

        //Oracle驱动程序类：oracle.oracle.jdbc.driver.OracleDriver
        private static final String DBDRIVER= "oracle.jdbc.driver.OracleDriver";
        private static final String DBURL= "jdbc:oracle:thin:@localhost:1521:doctor";
        private static final String USER= "system";
        private static final String PASSWORD="dengqihong";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * （2003年初）虽然JDBC里面提供有Statement接口,但是从实际来讲，Statement接口存在有严重的操作缺陷,是不可能在实际的工作中使用的.
         * 范例：以数据增加操作为例观察一下Statement 的问题:
         *
         *
         */
        String name = "Mr'SMITH'";
//        String birthday = "1988-10-10";
        Date birthday = new Date();
        int age = 18;
        String note = "是个外国人";


        System.out.println("-----第一步：加载数据库驱动程序--------");
        Class.forName(DBDRIVER);
        System.out.println("-----第二部：连接数据库--------");
        Connection conn = DriverManager.getConnection(DBURL,USER,PASSWORD);
        System.out.println(conn);
        System.out.println("-----第三步：进行数据库的数据操作-------");
        Statement statement  = conn.createStatement();
        System.out.println("::更新数据::");
        System.out.println("-->数据增加");
        //Todo 增加的SQL语句：INSERT INTO member (mid,name,birthday,age,note) VALUES (myseq.nextval,'张三'，TO_DATE（'1998-10-10','yyyy-mm-dd'),17,'是个人')
// 【OLD】       String sql = " INSERT INTO member (mid,name,birthday,age,note) VALUES " +
//                " (myseq.nextval,'"+name+"'，TO_DATE（'" + birthday + "','yyyy-mm-dd'),"+age+",'"+ note+"') " ;

        /**@SQLSynctax SQL 语法错误,就查SQL语句
         * "Mr'SMITH'"： Exception in thread "main" java.sql.SQLSyntaxErrorException: ORA-00917: 缺失逗号
         * 问题：Statement 如果要想变为灵活的应用,那么就必须采用拼凑字符串的方式完成,可是如果输入内容存在有“‘”单引号,
         * 那么整个SQL就会出错了，也就是说Statement的执行模式不适合于处理一些敏感字符
         */
        //Todo Statement 执行的关键性的问题是在于它需要一个完整的字符串来定义要使用的SQL语句,这就导致在使用中需要进行SQL的拼凑
        //Todo PreparedStatement 与Statement不同的地方在于,它执行的是一个完整的具备特殊占位标记的SQL语句.并且可以动态的设置的设置所需要的数据
        //Todo PreparedStatement 属于Statement的子接口，但是如果要想取得这个直接扣的实例化对象，依然需要Connection提供的方法：
        //  public PreparedStatement prepareStatement (String sql) throws SQLException,里面在执行的时候需要传入一个
        // SQL语句,这个SQL是一个具备特殊标记的完整SQL，但是此时没有内容，当取得了PreparedStatement接口对象后,需要使用
        // 一系列的SetXxxx（）方法,用于为所使用的标记设置具体内容，而后对于执行操作有两个方法支持：
        // |—：更新操作:boolean execute() throws SQLException
        // |—：查询操作：ResultSet executeQuery() throws SQLException
        System.out.println("改进数据增加");
// 【NEW】
        String sql = " INSERT INTO member (mid,name,birthday,age,note) VALUES "
                + " (myseq.nextval,?,?,?,?) " ;
        //进行数据库的数据操作,执行了完整的SQL
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,name);
        //当使用了PreparedStatement接口操作时最需要注意的是里面的setDate()方法,因为吃方法使用的是java.sql.Date
        //而不再是java.util.Date
        //在java.util.Date类下有三个子类都是在java.sql包中的：
           //|—：java.sql.Date:描述的日期
           //|—：java.sql.Time:描述的是时间
           //|—：java.sql.Timestamp:描述的是时间戳（日期时间）
        //如果想要将java.util.Date变为java.sql.Date（Time、Timestamp）只能够依靠long完成
        //|—：java.util.Date：public long getTime(),可以将Date变为long;
        //|—：java.sql.Date：public Date(long date)，将long变为sql.Date
       // preparedStatement.setDate(2, (java.sql.Date) birthday);//直接转换不了（向下转型之前必须向先上转型）：Exception in thread "main" java.lang.ClassCastException: java.util.Date cannot be cast to java.sql.Date
        preparedStatement.setDate(2,new java.sql.Date(birthday.getTime()));//直接转换不了（向下转型之前必须向先上转型）：Exception in thread "main" java.lang.ClassCastException: java.util.Date cannot be cast to java.sql.Date
        preparedStatement.setInt(3,age);
        preparedStatement.setString(4,note);
        int len = preparedStatement.executeUpdate(); //执行SQL返回更新的数据行  （Todo 数据库如果多执行几次,存储的数据是无序的.相当于多开了几个线程，去执行同一个数据库。）
        System.out.println("\t影响的数据行：" + len);
        /**@更新与删除操作和证件操作的区别不大
         * 整个数据操作里面更新操作几乎都是固定的模式，但是查询操作时最为复杂的。
         */

        //Todo 查询全部数据
        System.out.println("-------------查询全部数据------------------------");
        System.out.println("查询全部数据");
        String sql_query = "SELECT mid,name,birthday,age,note FROM member ORDER BY mid";
        PreparedStatement preparedStatement1 = conn.prepareStatement(sql_query);  //PreparedStatement 代表一次操作，每一次都需要重新实例化
        ResultSet resultSet = preparedStatement1.executeQuery();
        while (resultSet.next()){
            int mid = resultSet.getInt("mid");
            String name1 = resultSet.getString("name");
            Date birthday1 = resultSet.getDate(3);   //返回的依然是sql.Date
            int age1 = resultSet.getInt(4);
            String note1 = resultSet.getString(5);
            System.out.println(mid + "\t" + name1 + "\t" + birthday1 + "\t" + age1 + "\t" + note1);
        }

        //Todo 模糊查询
        //Todo 模糊查询如果省略关键字,那么会查询所有。但是和SELECT *直接查询所有有所不同。模糊查询的查询所有会逐行判断是否包含关键字
        System.out.println("-------------模糊查询------------------------");
        String keyWords = "李";
        String sql_Query = " SELECT mid,name,birthday,age,note FROM member WHERE name LIKE ? ";
        PreparedStatement preparedStatement2 = conn.prepareStatement(sql_Query);
        preparedStatement2.setString(1,"%" + keyWords + "%");
        ResultSet resultSet1 = preparedStatement2.executeQuery();
        while (resultSet1.next()){
            int mid = resultSet1.getInt("mid");
            String name1 = resultSet1.getString("name");
            Date birthday1 = resultSet1.getDate(3);   //返回的依然是sql.Date
            int age1 = resultSet1.getInt(4);
            String note1 = resultSet1.getString(5);
            System.out.println(mid + "\t" + name1 + "\t" + birthday1 + "\t" + age1 + "\t" + note1);
        }

        //Todo 分页显示
        System.out.println("-------------分页显示------------------------");
        int currentPage =2; //通过改变currentPage的值来实现分页显示
        int lineSize =5;
        String keyword = "";
        String sql_page = " SELECT * FROM ("
                + " SELECT mid,name,birthday,age,note,ROWNUM rn "
                + " FROM member "
                + " WHERE name LIKE ? AND ROWNUM<=?) temp "
                + " WHERE temp.rn >? ";
        PreparedStatement preparedStatement3 = conn.prepareStatement(sql_page);
        preparedStatement3.setString(1,"%" + keyword + "%");
        preparedStatement3.setInt(2,currentPage * lineSize);
        preparedStatement3.setInt(3,(currentPage -1) * lineSize);
        ResultSet resultSet2 = preparedStatement3.executeQuery();
        while (resultSet2.next()){
            int mid = resultSet2.getInt("mid");
            String name1 = resultSet2.getString("name");
            Date birthday1 = resultSet2.getDate(3);   //返回的依然是sql.Date
            int age1 = resultSet2.getInt(4);
            String note1 = resultSet2.getString(5);
            System.out.println(mid + "\t" + name1 + "\t" + birthday1 + "\t" + age1 + "\t" + note1);
        }
        System.out.println("-------------统计数据------------------------");
        String sql_count = "SELECT COUNT(mid) FROM member WHERE name LIKE ?";
        PreparedStatement preparedStatement4 = conn.prepareStatement(sql_count);
        preparedStatement4.setString(1,"%" + keyword + "%");
        ResultSet resultSet3 = preparedStatement4.executeQuery();
        if (resultSet3.next()){  //因为只返回一行数据，这与COUNT有关
           int count = resultSet3.getInt(1);
            System.out.println(count);
        }
        System.out.println("-----第四部：关闭数据库--------");
        statement.close();  //是可选的，并且无用的
        conn.close();  //连接关闭了,statement，resultSet也会自动关闭

        //TODO 总结：在以后的开发之使用的永远不会是Statement接口,只会是PreparedStatement
    }
}
