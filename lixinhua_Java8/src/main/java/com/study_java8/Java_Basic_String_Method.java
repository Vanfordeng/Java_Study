package com.study_java8;

/**
 * Created by Doctor on 2016/10/8.
 */
public class Java_Basic_String_Method {
    public static void main(String[] args){
        char c = '9';
        int temp = c;
        System.out.println(temp);
        String stra = "hello";
        String strB = "a";
        System.out.println(stra.equalsIgnoreCase(strB));
        System.out.println(stra.compareTo(strB));
        //32：现在只有String类的对象才具有大小的关系判断
        //public int compareTo(String anotherString)
        //判断两个字符串的大小（按照字符编码比较），此方法的返回值有如下三种结果：
        //=0：表示等于的结果
        //>0:表示大于的结果
        //<0:表示小于的结果

        if (isNumber("123456")){
            System.out.println("由数字组成");
        }else {
            System.out.println("由非数字组成");
        }
        System.out.println();

        String str = "HelloWorld nihao";
        //返回满足条件单次的第一个字母的索引
        System.out.println(str.indexOf("World"));
        //返回的是第一个查找到的
        System.out.println(str.indexOf("l",5));
        //从后开始查找
        System.out.println(str.lastIndexOf("l"));
        //contains查找包含,返回boolean值
        System.out.println(str.contains("World"));
        System.out.println(str.endsWith("World"));
        System.out.println(str.startsWith("Hello"));
        //10代表该字符串中可以以 “ ” 拆分的最大次数,如果超过10，后续的字符串不再进行拆分
        String[] sp = str.split(" ",10);
        for (int i = 0; i < sp.length; i++) {
            System.out.println(sp[i]);
        }
        //拆分如下字符串数据
        String str2 = "张三：22|李四：25|邓：31";

        String[]  s1 = str2.split("\\|");
        for (int i = 0; i < s1.length ; i++) {
            String[] temp1 = s1[i].split("：");
            System.out.println("姓名：" + temp1[0] +"\t年龄：" + temp1[1]);
        }
        //trim:去掉字符串前后的空格
        String str3 = "   h  e  llo   ";
        System.out.println(str3.trim());
        System.out.println(str3);
        System.out.println(str3);
        //虽然String类提供了大量的支持的方法,但是却少了一个重要的方法---initcap()功能，首字母大写，其余字母小写
        System.out.println(initcap(str3));
    }
    //如果一个方法的返回值是boolean，习惯的命名规则以"isXxxx"开头
    public static boolean isNumber(String temp){
        char[] data = temp.toCharArray();
        for (int i = 0; i < temp.length(); i++) {
            if (data[i] > '9' || data[i] < '0'){
                return false;
            }
        }
        return true;
    }

    public static String initcap(String temp){
        return temp.trim().substring(0,1).toUpperCase() + temp.substring(1);
    }
}
