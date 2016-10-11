package com.study_java8;

/**
 * Created by Doctor on 2016/10/10.
 * 内部类,私有内部类
 * 内部类有一个最大的优点：可以方便的访问外部类的私有属性，反之，外部类也可以轻松的范围内部内的属性
 */
class Outer{  //外部类
    private String mgs = "Hello World";

    //TODO
    private class Inner{ //内部类  Outer$Inner.class 所有的“$"（Java的标识符中就有$）是在文件中的命名。如果换到了程序里面就变成了
        //“.",也就是说内部类的名称实际上就是“外部类.内部类”此时可以给出内部类对象的实例化语法：
        //外部类.内部类  对象 =  new 外部类（）.new 内部类（）；
        private String info = "世界，你好";
        public void print(){
            //一直要求过，如果要想访问我们的属性前面一定要加上this,但是如果直接在我们print()方法里面加上this,
            //表示的是查找本类的属性，但是此时要访问的实际上是外部类的属性，那么应该使用“外部类.this.属性”
            //外部类.this == 外部类的当前对象
            System.out.println(Outer.this.mgs); //this.mgs 会找不到mgs变量.加上this会再Inner类中去找mgs
        }
    }

    public void fun(){
        new Inner().print();
        System.out.println(new Inner().info); //直接利用了内部类对象访问了内部类中定义的私有属性（通常情况在类的外面不能访问私有属性）
    }
}
public class Java_Basic_InnerClass {
    public static void main(String[] args){
        //内部类不可能离开外部类的实例化对象，所以一定要实例化外部类对象后才可以使用内部类对象
        //如果一个内部类只希望被一个外部类范围,不能够被外部调用，那么可以使用private进行定义
        //此时的内部类是不可能在外部进行对象实例化的
//        Outer.Inner in = new Outer().new Inner();
//        in.print();
        System.out.println("-------------------");
        new Outer().fun();
    }
}
