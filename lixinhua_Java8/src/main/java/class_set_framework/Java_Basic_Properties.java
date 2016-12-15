package class_set_framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Doctor on 2016/12/14.
 * Properties 是Hashtable的子类，主要是进行属性的操作（属性的最大特点是利用字符串设置key和value）
 * 观察Properties类的定义结构：
 * public class Properties extends Hashtable<Object,Object>   默认将Hashtable的泛型设置为了Object,Object。消除警告信息
 * 在使用Properties类的时候不需要设置泛型类型,因为从它一开始出现就只能够保存String（因为里面的所有方法都是String相关的）.在Properties类里面主要使用如下的几种方法：
 * 设置属性：public Object setProperty(String key,String value)
 *  取得属性：public String getProperty(String key)，如果key不存在返回null
 * 取得属性：public String getProperty(String key,String defaultValue) ,如果key不存在返回默认值
 */
public class Java_Basic_Properties {
    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        pro.setProperty("BJ","北京");
        pro.setProperty("TJ","天津");
        pro.setProperty("BJ","北京");
        System.out.println(pro.getProperty("BJ"));
        System.out.println(pro.getProperty("TJ"));
        System.out.println(pro.getProperty("NJ"));   //key不存在
        System.out.println(pro.getProperty("NJ","没有此记录"));   //key不存在，并设置默认值

        //在Properties类里面提供有数据的输出操作:
        //public void store(OutputStream out,String comments) throws IOException   //comments时一些说明文档的注释
        //一般而言后缀可以随意设置,但是标准来讲，既然是属性文件,后缀就必须是*.properties。这样做也是为了与国际化挂钩
        pro.store(new FileOutputStream(new File("E:\\"+ File.separator + "1.properties")),"Info");
        //既然可以保存,也可以从指定的输入流中读取属性信息
        //Properties里面有一个操作方法：
        //public void load(InputStream inStream) throws IOException
        //通过文件流读取属性文件
        System.out.println("---------通过文件流读取属性文件-----------");
        pro.load(new FileInputStream(new File("E:\\"+ File.separator + "1.properties")));
        System.out.println(pro.getProperty("TJ"));
        //Todo 对于属性文件（资源文件）而言,除了可以使用Properties类读取之外,也可以使用ResourceBundle类读取。这也就是
        //Todo 我们将属性的属性文件统一设置为后缀为“*.properties"原因所在

        /**
         * 资源文件的特点：
         * key = value
         * key = value
         * 资源文件中的数据一定都是字符串
         */
    }
}
