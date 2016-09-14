package com.study_mars.Equal_eg;

/**
 * Created by Doctor on 2016/9/7.
 */
public class User {
    String name;
    int age;


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
}
