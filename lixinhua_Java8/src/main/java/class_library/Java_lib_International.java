package class_library;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Doctor on 2016/11/11.
 * 国际化应用：根据当前的语言环境读取指定的语言资源文件
 * 所谓资源文件指的是后缀名为"*.properties",里面保存的内容按照"key=value"的形式保存,而且资源文件的命名标准与
 * Java类完全一样eg:Messages.properties
 * @读取Messages.properties文件
 * 使用：java.util.ResourceBundle：public abstract class ResourceBundle extends Object里面提供有一个静态方法：
 *  |——：根据当前语言环境取出：public static final ResourceBundle getBundle(String baseName)  baseName:就是Messages。
 *  |——：根据当前语言环境取出：public static final ResourceBundle getBundle(String baseName,Locale locale)
 *
 *
 * TODO 也可以使用 Properties properties = new Properties();来读取Properties文件
 */
public class Java_lib_International {
    public static void main(String[] args) {
        //访问的时候一定不要加上后缀，以为默认找到哦啊的后缀就是“*.properties"
        //此时的Messages.properties文件一定要放在CLASSPATH路径下
        ResourceBundle rb = ResourceBundle.getBundle("Messages", Locale.ENGLISH);  //Todo 新建了的Messages必须放在CLASSPATH目录下.？？？？现在放在：D:\AndroidStudioProjects\Java_IO\lixinhua_Java8\build\classes\main
        //当取得ResourceBundle类对象之后可以通过以下的方法读取数据：
         //|——：简单读取：public final String getString(String key)
        //java.text是专门负责国际化处理的程序包,在这个程序包有一个专门处理占位数据的操作类：MessageFormat：public class MessageFormatextends Format
        //提供方法：格式化文本：public static String format(String pattern,Object... arguments)
         //|——：设置替代内容(没有直接提供)：

        //读取普通文本：
        System.out.println("----------------------");;
        System.out.println(rb.getString("info"));
        System.out.println("-----------------------");
        String str = rb.getString("wel.msg");  //具备有占位符的内容
        System.out.println(MessageFormat.format(str,"邓",new SimpleDateFormat("yyyy-MM-dd").format(new Date())));  //欢迎邓光临,现在时间是：16-11-11 下午5:35！
        System.out.println(new Date());  //Fri Nov 11 17:35:54 CST 2016
        //国际化程序应该根据所在的国家不同可以显示不同的内容,但是只写了一个资源文件
        //于是这个时候需要Local类来实现.
        //Locale 保存的是一个国家的区域和语言编码,可以在定义资源文件的时候加上指定的语言编码
        //|——：定义中文的资源文件：Messages_zh_CN.properties
        //|——：定义中文的资源文件：Messages_zh_US.properties
        //Todo 设置的baseName设置的一定是Messages,所有的语言代码由Locale类来设置
        //在Local类里面定义有如下方法：
        //|——：构造方法：public Locale(String language,String country)
        //|——：静态方法：取得当前语言环境：public static Locale getDefault()
        System.out.println(Locale.getDefault());
        Locale locale = new Locale("Ch","CssN");
        ResourceBundle rb1 = ResourceBundle.getBundle("Messages");
        String str1 = rb1.getString("wel.msg");
        System.out.println(MessageFormat.format(str1,"邓天"));
        //如果已经存在有特定的语言资源文件，那么就不会读取其他的不设置语言的资源文件.如果不设置Local，而且找不到defaultlocal
        //那么会默认去找默认不设置特定语言的公共资源文件：特定语言的资源文件读取的优先级会高于公共资源文件的优先级
    }
}
