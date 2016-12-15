package com.study_java8;

/**
 * Created by Doctor on 2016/10/27.
 * @泛型就是一个标记：这个标记表示在此类内部或者方法内部，说要使用到的类型。可以在使用的时候自定义这个标记
 * 泛型的引出：
 * 现在要求定义一个表示坐标的操作类（Point）,在这个类要求保存有以下几种坐标：
 * *1.保存数字：x = 10、y = 20;
 * *2.保存小数：x = 10.2、y = 20.3
 * *3.保存字符串：x = 东经10.2、y = 20.3
 *现在这个Point类设计的关键就在于x与y这两个变量的类型设计上，先想到的一定是Object类型：
 */

/**@从JDK1.5之后开始增加了泛型技术,而泛型技术的核心意义就在于：类在定义的时候,可以使用一个标记,此标记就表示类中属性或者方法参数的类型标记，在使用的时候才动态的设置类型。*/
class Point{  //定义坐标

    private Object x;
    private Object y;


    public void setX(Object x) {
        this.x = x;
    }

    public Object getX() {
        return this.x;
    }

    public void setY(Object y) {
        this.y = y;
    }

    public Object getY() {
        return this.y;
    }

    public String toString(){
        return "x的值为：" + this.x.toString() + "\ty的值为：" + this.y.toString();
    }
}
//此时设置的T在Point_Generics类定义上只表示一个标记,在使用的时候需要为其设置具体的类型
class Point_Generics<T,Y>{  //定义坐标，Type = T,是一个类型,并且这个类型是引用类型继承自Object(也可以改为其他字母,就是一个标记而已)

    private T x;   //此属性的类型不知道,由Point_Generics类使用的时候动态决定
    private T y;   //此属性的类型不知道,由Point_Generics类使用的时候动态决定
    private Y z;

    public void setZ(Y z) {
        this.z = z;
    }

    public Y getZ() {
        return z;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getX() {
        return this.x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getY() {
        return this.y;
    }

    public String toString(){
        return "x的值为：" + this.x.toString() + "\ty的值为：" + this.y.toString();
    }
}

public class Java_NewFeather_Generics {
    public static void main(String[] args) {
        Point p = new Point();
        //第一步：设置数据
        p.setX("东经100度");
        p.setY("北纬100度");
        //第二部：取出数据
        String x = (String) p.getX();
        String y = (String) p.getY();

        System.out.println("x坐标：" +x + "\ty坐标：" + y);
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        //此时的代码已经利用Object数据类型解决了一切的开发问题,可是解决的关键是靠的是Object,失败的关键也就是Object
        /**
         * @观察错误的代码：
         */
        Point p1 = new Point();
        //第一步：设置数据
        p1.setX("东经100度");
        p1.setY(10);   //Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        //第二部：取出数据
        String x1 = (String) p1.getX();
        String y2 = (String) p1.getY();
        System.out.println("x坐标：" +x + "\ty坐标：" + y);
        //这样的代码还不需要执行,就已经可以观察到本程序可能存在的问题.ClassCastException。我们SetY的时候使用的10,而y2的取出转型为了String
        //所以向下转型要少用.
        //向上转型的核心目的在于统一操作的参数上，而向下转型的目的是操作子类定义的特殊功能。可是现在的问题,向下转型是一件非常不安全的操作。
        //那么这已操作应该在代码运行之前就已经能够自动排查出来这是最好的。可是之前的技术做不到。
        /**@从JDK1.5之后开始增加了泛型技术,而泛型技术的核心意义就在于：类在定义的时候,可以使用一个标记,此标记就表示类中属性或者方法参数的类型标记，在使用的时候才动态的设置类型。*/
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        //泛型类使用：在使用Point_Generics类的时候才去设置标记的内容
        Point_Generics pg1 = new Point_Generics();  //在没有设置标记的具体类型的时候,默认标记为Object类型。因为Java设计之初并没有考虑到泛型的设计。这样也是为了兼容以前的程序
        pg1.setX(new Object());
        //-----------------------------------------------------
        Point_Generics<String,Integer[]> pg = new Point_Generics<String, Integer[]>();  ////定义坐标，Type = T,是一个类型,并且这个类型是引用类型继承自Object(也可以改为其他字母,就是一个标记而已)
        pg.setX("东经10度，泛");
        //pg.setY(10);  //会出语法异常,在代码执行前检查出错误,这是一种编程思想
        pg.setY("北纬100度，泛");
        String xf = (String) pg.getX();
        String yf = (String) pg.getY();
        System.out.println("x的值：" + xf+"\ty的值：" + yf);

        /**@发现使用了泛型之后,所有类中的属性的类型都是动态设置的,而使用泛型标记的方法参数类型也都发送了改变，这样就避免了
         *@向下转型的问题,从而解决了类对象转换的安全隐患*/
        //但是需要特别说明的是,如果要使用泛型,那么它能够采用的类型只能是类,即：不能是基本类型，只能够是引用类型。所以设置基本类型肯定会用到包装类的自动装箱/拆箱功能。
        //这也是为什么JDK1.5中也必须增加自动拆箱和装箱的功能
        /* 两点说明：
         * 1.如果在使用泛型类或者是接口的时候,没有设置泛型的具体类型，在Eclipse中会有警告,但是为了程序不出错默认为Object类型（主要是用于兼容1.5之前的程序）
         * 2.JDK1.7之后,实例化的泛型可以不加标记的类型：eg:Point_Generics<String,Integer[]> pg = new Point_Generics<>();但是建议加上
         *
         */

    }
}
