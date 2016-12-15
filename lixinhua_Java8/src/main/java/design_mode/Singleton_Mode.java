package design_mode;

/**
 * Created by Doctor on 2016/10/24.
 *
 /*分析步骤：
 * 1.构造方法使用了private声明，一旦使用了private。就表示这个构造方法只能被类的内部说使用。既然如此，可以在类的内部实例化一个对象
 * 2.现在的instance在Singleton里面只是一个普通的类属性，而所有的普通类必须在类产生实例化对象之后才可以使用，是否存在有一种方式，可以让这个类熟悉不受
 * Singleton类实例化对象的控制呢？
 * 如果使用static声明instance属性,那么就表示可以在一个类没有产生实例化的对象的时候直接使用该属性
 * 3.在一个类定义的时候应该首先考虑到就是类中的属性需要进行封装
 * 4.一旦一个属性封装之后要想访问此属性只能够通过getter方法，那么久需要提供有一个getter方法可以通用不受到Singleton实例化对象的控制，继续使用static属性
 *-------------------------------------------------------------------------------------------------------------------------
 * 单例设计模式：让某个类在系统里面只允许实例化一个子类。
 * 单例设计模式有两种形式：
 * 饿汉式：在之前所编写的单例实际上就属于饿汉式的应用，在Singleton类定义的时候就已经准备好了实例化对象INSTANCE,而并没有关心这个对象是否使用
 * 懒汉式：而懒汉式最大的特点是在于它是在第一使用的时候才进行实例化操作
 *
 *代码意义：如果想要控制一个类中实例化对象的参数个数，那么首先要锁定的就是类中的构造方法，因为在实例化新对象都要使用构造方法
 * 如果构造方法被锁了，那么久自然无法参数新的实例化对象了。
 *
 */
class Singleton{
    /*懒汉式编写方法：
     *  private static Singleton instance;
     *  private Singleton(){}
     *  public static Singleton getInstance(){
     *    if (instance == null){
     *     instance = new Singleton();
     *     }
     *    return instance;
     *  }
     */

    private static final Singleton INSTANCE = new Singleton();
    private Singleton(){} //构造方法私有化
    public static Singleton getInstance(){
        return INSTANCE;
    }
    public void print(){
        System.out.println("Hello");
    }
}
public class Singleton_Mode {
    public static void main(String[] args){
        Singleton  s = null;
       // s = new Singleton();  //私有化构造方法就无法使用new 实例化对象
        s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        Singleton s3 = Singleton.getInstance();
        Singleton s4 = Singleton.getInstance();
        s.print();
        System.out.println("-----------------------");
        System.out.println(s);  //design_mode.Singleton@677327b6  内存地址相同,只能有一个子类
        System.out.println(s2); //design_mode.Singleton@677327b6  内存地址相同,只能有一个子类
        System.out.println(s3); //design_mode.Singleton@677327b6  内存地址相同,只能有一个子类
        System.out.println(s4); //design_mode.Singleton@677327b6  内存地址相同,只能有一个子类
    }
}
