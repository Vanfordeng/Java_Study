package com.study_java8;

/**
 * Created by Doctor on 2016/10/27.
 * 枚举的使用：虽然发现枚举的定义比较简单，可是对于之前讲解的多例设计模式里面，发现还可以定义属性、方法。枚举也可以，可以有要求：
 * 1.枚举之中定义的构造方法不能够使用public声明；如果没有无参构造,请手工调用传递参数
 * 2.枚举对象必须要放在首行,随后才可以定义属性、构造、普通方法
 */
interface IMessage2{
    public String getTitle();
}
enum Color2 implements IMessage2{
    RED("红色") {
        @Override
        public void getInfo() {
            System.out.println("变态的抽象方法getInfo:" + this);
        } //枚举里面最变态的一种做法是可以在每一个对象后面,使用匿名内部类的形式实现抽象方法
        @Override
        public String getTitle() {
            return  "自己的" + this;    //this 就代表RED("红色") 这个对象
        }
    },BLUE("蓝色") {
        @Override
        public void getInfo() {
            System.out.println("变态的抽象方法getInfo:" + this);
        }

        @Override
        public String getTitle() {
            return  "自己的" + this;     //this 就代表BLUE("蓝色") 这个对象
        }
    },GREEN("绿色") {
        @Override
        public void getInfo() {
            System.out.println("变态的抽象方法getInfo:" + this);
        }

        @Override
        public String getTitle() {
            return  "自己的" + this;      //this 就代表GREEN("绿色")这个对象
        }
    };  /**@可以在此处实现接口中的方法*/
    private String title;  //属性
//    private Color2(){}  //如果注释掉那么Color2中没有无参构造.RED,BLUE,GREEN定义要变为：
    private Color2(String title){
        //super("1",1);  //call to super is not allowed in enum constructor
        this.title = title;
    }

//    public String getTitle(){   /**@可以在此处实现接口中的方法*/
//        return this.title;
//    }

    //更变态的是，在枚举里面还能够直接蒂尼抽象方法。
    abstract public void getInfo();

    public String toString(){
        return this.title;
    }
}
public class Java_NewFeather_Enum_Usage {
    public static void main(String[] args) {
        for (Color2 c : Color2.values()){
            System.out.println(c.ordinal() + "\t" + c);
        }
        System.out.println("-----------------------------");
        IMessage2 m = Color2.GREEN;
        System.out.println(m.getTitle());
        System.out.println(Color2.BLUE.getTitle());
        System.out.println(Color2.RED.toString());
        System.out.println("-----------------------------");
        IMessage2 m1 = Color2.GREEN;
        System.out.println(m.getTitle());
        System.out.println("-----------------------------");
        Color2.RED.getInfo();

        System.out.println("-----------------------------");
        /**@枚举的实际应用：
         * @1.在switch上使用：
         *
         */
        Color2 c = Color2.BLUE;          //枚举类型实例化
        //Color2 c1 = new Color2();     //提示无法继承自Color2, Color2为final 说明enum定义的为final修饰的

        switch (c){  //在switch上使用：
            case RED:
                System.out.println(c.toString());
                break;
            case GREEN:
                System.out.println(c.toString());
                break;
            case BLUE:
                System.out.println(c.toString());
                break;
        }
    }
}
