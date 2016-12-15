package class_library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Doctor on 2016/11/3.
 * public class Date extends Object implements Serializable, Cloneable, Comparable<Date>
 * 日期:Date 这个类的toString方法就直接输出当前时间，格式为 // "EEE MMM dd HH:mm:ss zzz yyyy";
 * 包含的重要方法有：
 *  无参构造：public Date()
 *  有参数构造：public Date(long date),接收long型数据变为long
 *  转换为long型：public long getTime()
 *-----------------------------------------------------------------------------------------------------
 * @java.text时一个专门实现国际化程序的开发包，而SimpleDateFormat是一个专门处理格式化日期的工具类,将
 * @Date型的对象转换为String型的形式显示，主要方法：
 * public class SimpleDateFormat extends DateFormat
 * 构造方法：public SimpleDateFormat(String pattern) 需要传递转换格式
 * 将Date转换为String: public final String format(Date date)
 * 将String转换为Date：public Date parse(String source) throws ParseException
 * 现在问题的关键就在于转换格式上，对于常见的转换单位：年（yyyy）、月（MM）、日（dd）、时（HH）、分（mm）、秒（ss）、毫秒（SSS）
 * 其中："HH:mm:ss"是24小时制的，"hh:mm:ss"是12小时制。
 * @Date与String类之间的转换依靠的是SimpleDateFormat
 * @String与基本数据类型之间的转换依靠的是包装类与String.valueOf()方法
 * @long与Date转换依靠的是Date类提供的构造(public Date(long date))以及getTime()方法public long getTime()
 * -----------------------------------------------------------------------------------------------------
 * Calendar:是一个抽象类
 *  public abstract class Calendar extends Object implements Serializable, Cloneable, Comparable<Calendar>
 *  提供的方法有：
 *  public static Calendar getInstance()
 */
public class Java_lib_Date {
    public static void main(String[] args) {
        long start_all = System.currentTimeMillis();


        Date data = new Date();
        System.out.println(data);  //输出对象信息data  Thu Nov 03 11:27:16 CST 2016
        //如果只是Date输出的时间格式只能是：Thu Nov 03 11:27:16 CST 2016
        //long 用来表示：时间，日期,数据，文件大小等
        System.out.println("----------------------");
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 1000 ; i++) {
            str+=i;
        }
        long end = System.currentTimeMillis();

        Date d = new Date(end-start);   //public Date(long date)   27542

        System.out.println(d);              //Thu Jan 01 08:00:27 CST 1970  是以1970年的08:00:00开始计时计算
        System.out.println(d.getTime());     //public long getTime()      //27542

        System.out.println("--------------------------------");

        Date now =  new Date();
        //如果不以yyyy-MM-dd HH:mm:ss:SSS 这种格式转换,那么转换回Date就会出错。因为日期的表现形式各个国家不一样
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS"); //public SimpleDateFormat(String pattern) 需要传递转换格式
        String s = sdf.format(now);  //将Date转换为String: public final String format(Date date)
        System.out.println(s);       //以转换后的格式输出：2016-11-03 13:31:31:108
        try {
            Date d1 = sdf.parse(s);
            //如果转换的格式不符合,那么就会出现异常.如：d2
           // Date d2 = sdf.parse("2016-27-03 131:31:108"); //Unparseable date: "2016-27-03 131:31:108"
            //在将字符串变为日期型数据的时候,如果日期型数据给出的月不对,那么会自动进行进位。如：d3
            Date d3 = sdf.parse("2016-234-03 13:36:25:848"); //Sun Jun 03 13:36:25 CST 2035
            System.out.println(d1);        //又以Date形式输出：Thu Nov 03 13:31:31 CST 2016
            //System.out.println(d2);
            System.out.println(d3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // TODO: 2016/11/3 总结：关于数据类型的转换
        //在数据表的操作里面中断说过几个常用类型：VARCHAR2(String),CLOB(String),Number（Double或int）,Date(java.util.Date)
        System.out.println("--------------------------------");
        Calendar cal = Calendar.getInstance();  //取得本类对象
        StringBuffer buf =  new StringBuffer();
        buf.append(cal.get(Calendar.YEAR)).append("-");
        buf.append((cal.get(Calendar.MONTH))+ 1).append("-");
        buf.append(cal.get(Calendar.DAY_OF_MONTH)).append(" ");
        buf.append(cal.get(Calendar.HOUR_OF_DAY)).append(":");
        buf.append(cal.get(Calendar.MINUTE)).append(":");
        buf.append(cal.get(Calendar.SECOND)).append(":");
        buf.append(cal.get(Calendar.MILLISECOND)).append(" ");
        System.out.println(buf);
        //如上的实现获取日期虽然麻烦，但是当要计算3天后或者多少小时后是什么日期.就比较实用。直接在Calendar.xxx后面直接加上就可以了

        long end_all = System.currentTimeMillis();
//        * @Date与String类之间的转换依靠的是SimpleDateFormat   将Date转换为String: public final String format(Date date) 将String转换为Date：public Date parse(String source) throws ParseException
//        * @String与基本数据类型之间的转换依靠的是包装类与String.valueOf()方法
//        * @long与Date转换依靠的是Date类提供的构造(public Date(long date))以及getTime()方法public long getTime()
        Date date_all = new Date(end_all - start_all);
        //其中："HH:mm:ss"是24小时制的，"hh:mm:ss"是12小时制。

        SimpleDateFormat sdf_all = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");  //Todo:1970-01-01 08:00:00:032中包含有年月子和小时
        System.out.println("--------------------------------");
        System.out.println(sdf_all.format(date_all));
    }
}
