package com.study_mars.hashCode_toString_eg;

/**
 * Created by Doctor on 2016/9/7.
 */
public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        //对象的内存地址是唯一的如果内存地址相同,肯定内容也相同
        if (this == obj){
            return true;
        }
        //判断obj是否是User类型的对象
        boolean b = obj instanceof User;
        if (b){
            //将obj向下转型为User类型.调用成员变量必须是对应的类型的引用.Object对象无法访问age,name成员变量
            User u = (User) obj;
            //age为int类型,可以用==号比对,name为String类型,不能用==比对.需要用String复写的equals来比对
            if (this.age == u.age && this.name.equals(u.name)){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }
//        -----------Alt+insert自动生成的equals 方法
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (age != user.age) return false;
//        return name.equals(user.name);
//
//    }
    //复写hashCode方法,凡是该User对象的hashCode返回的时候都是12.就相等了。
    //hashCode原则：如果两个对象用equals比较是相等的,那这两个对象用调用hashCode返回的hash值也应该是相等的
    public int hashCode(){
       int result =  17;
        result = 31 * result + age;
        result = 31 *result + name.hashCode();

        return result;
    }
//    -----------Alt+insert自动生成的hashCode 方法
//    @Override
//    public int hashCode() {
//        int result = name.hashCode();
//        result = 31 * result + age;
//        return result;
//    }


    public String toString(){
        String result = "";
        result = result + "age:" +age +","+"name:" +name;
        return result;
    }
//    -----------Alt+insert自动生成的toString 方！法
//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//
//    }
}
