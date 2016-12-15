package class_library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Doctor on 2016/11/4.
 * 正则是从JDK1.4的时候正式引入到java中的工具类,所有正则支持的类都定义在java.util.regex包中。在JDK1.4之前，
 * 如果想要使用正则，则需要单独下载一个正则表达式的开发包后才可以使用。
 * 这个包只包含两个类：
 * public final class Matcher extends Object implements MatchResult
 * public final class Pattern extends Object implements Serializable
 * Pattern类：此类对象如果想要取得必须使用compile()方法,功能是编译正则 ：public static Pattern compile(String regex)
 * Matcher类：是通过Pattern类取得
 * Todo 正则标记：(背)
 * 1.单个字符（数量：1）
 *    |—— 字符(eg."x")：表示由一位字符组成   //String str = "tt"; str.matches("t");  false    String str = "t"; str.matches("t");  true
 *    |——\\:表示转义字符"\"
 *    |——\t:表示转义字符"\t"    //The tab character ('\u0009')
 *    |——\n:表示换行"\n"         //The newline (line feed) character ('\u000A')
 * 2.字符集（数量：1）
 *    |——[abc]:表示可能是字符a 或者是字符b，或者是字符c中的任意一位  //a, b, or c (simple class)
 *    |——[^abc]:表示可能不是字符a 或者不是字符b，或者不是字符c中的任意一位
 *    |——[a-z]:表示a-z的所有小写字母
 *    |——[a-zA-Z]:表示a-z和A-Z的所有大小写字母
 *    |——[0-9]:表示0-9的所有数字
 * 3.简化的字符集表达式（数量：1）
 *    |——.:表示任意的一位字符
 *    |——\d:等价于“[0-9]",属于简化写法
 *    |——\D:等价于“[^0-9]",属于简化写法
 *    |——\s:表示任意的空白字符，例如"\t","\n"
 *    |——\S:表示任意的非空白字符
 *    |——\w:等价于“[a-zA-Z_0-9]",表示由任意的字母，数字，_ 所组成
 *    |——\W:等价于“[^a-zA-Z_0-9]",表示不是由任意的字母，数字，_ 所组成  //A non-word character: [^\w]
 * 4.边界匹配（不要再Java中使用，在JavaScript中使用）
 *    |——^:正则的开始
 *    |——$:正则的结束
 * 5.数量表达式
 *    |——正则？：表示此正则可以出现0次或者1次
 *    |——正则+：表示此正则可以出现1次或者1次以上。不表示0次
 *    |——正则*：表示此正则可以出现0次或者1次或者1次以上。
 *    |——正则{n}：表示此正则可以出现n次,也可以用来表示至少出现几次
 *    |——正则{n，}：表示此正则可以出现n次以上,包含n次
 *    |——正则{n，m}：表示此正则可以出现n次-m次,包含n次和m次
 *  6.逻辑运算：Logical operators
 *    |—— 正则1正则2：正则1判断完成之后继续判断正则2
 *    |——正则1 | 正则2：正则1或者正则2有一则满足即可
 *    |——（正则）：将多个正则作为一组,可以为这一组单独设置出现的次数
 *
 * String中对正则的支持：
 * 正则验证,使用指定的字符串判断其是否符合给定的正则表达式结构：public boolean matches(String regex)
 * 全部替换：public String replaceAll(String regex,String replacement)
 * 替换首字母：public String replaceFirst(String regex,String replacement)
 * 全部拆分：public String[] split(String regex)
 * 部分拆分：public String[] split(String regex,int limit)
 */
public class Java_lib_Regex {
    public static void main(String[] args) {
        String str = "ighewjQQQQQQQgoej24295uAAAF3masojfw000eXXXgi3gnaBEEEEsodgjegojmapwoCCCg";
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher matcher = p.matcher(str);
        System.out.println(matcher.toString()); //打印mather

        //------------------------------------------------------------------------------------------------
        System.out.println(str.replaceAll("[a-z]",""));  //只输出小写字母
        String[] result = str.split("//d+");         //按照数字拆分字符串
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
        System.out.println(str.matches("t"));
        System.out.println();
        //Todo 验证一个字符串是否是数字，如果是则将其变为double型
          //|——数字有可能是整数也可能是小数，正则如下：“*[0-9]*.*[0-9]”
        String str1 = "10.3";
        String regex = "\\d+(\\.\\d+)?";  //数字的正则：\\d+表示数字出现1次或者以上,（）表示一个整体.\\.\\d+。？表示0次或者1次
        if (str1.matches(regex)){
            Double i = Double.valueOf(str1);
            System.out.println(i+1);
        }
        //Todo 判断给定的字符串是够是一个IP地址（IPV4）
        //192.168.1.1
        String str2 ="198.168.163.100";
        String regex1 = "(\\d{1,3}\\.){3}\\d{1,3}";
        if (str2.matches(regex1)){
            System.out.println("IP");
        }
        //Todo 给定一个字符串,要求判断是否是日期格式，如果是这将其转换为Date型数据
        //1965-3-12
        String str3 = "1979-03-12";
        String regex2 = "\\d{4}-\\d{2}-\\d{2}";
        if (str3.matches(regex2)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                System.out.println(sdf.parse(str3));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //Todo 判断电话号码,一般要编写电话号码一下集中格式都是满足的：
        //格式一：51283346                 \\d{7,8}
        //格式二：010-51283346             (\\d{3,4}-)?\\d{7,8}
        //格式三：(010)-51283346           ((\d{3,4}-)|(\(\d{3,4}\)-))?\d{7,8}
        String str4 = "010)-51283346";

        String regex3 = "((\\d{3,4}-)|(\\(\\d{3,4}\\)-))?\\d{7,8}";
        if (str4.matches(regex3)){
            System.out.println(str4);
        }
        //Todo 验证email地址
        //格式一：email由字母,数字，_组成    //
        //格式二：用户名要求由字母、数字、_、. 组成，其中必须以字母开头其中必须以字母开头，字母和数字结尾用户名长度不超过30，最后的根域名只能是：
        //com\cn\net\com.cn\net.cn\edu\gov\org
        String str5 = "helli_nihao@mldn.org";
        String regex4 = "\\w+@\\w+.\\w+";
        String regex5 = "[a-zA-Z]\\w{1,28}(\\d|[a-zA-Z])@\\w+.(com|cn|net|(com\\.cn)|(net\\.cn)|edu|gov|org)";
        System.out.println(str5.matches(regex4));
        System.out.println(str5.matches(regex5));
        if (str5.matches(regex5)){
            System.out.println(str5);
        }
        //Java.util.regex
        //在大多数的时候都会采用String类完成
        String str6 = "123214.IEgjejgpj213jjgo312jg3ojg3jg";
        String reg = "\\d+";
        Pattern pattern =  Pattern.compile(reg);  //编译正则
        String[] re = pattern.split(str6);
        System.out.println(Arrays.toString(re));
        Matcher matcher1 = pattern.matcher(str6);  //正则匹配
        System.out.println(matcher1.matches()); //匹配的结果

    }
    public static boolean isNumber(String temp){
        char[] chars = temp.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            if (chars[i]> '9'|| chars[i] < '0'){
                return false;
            }
        }
        return true;
    }
}
