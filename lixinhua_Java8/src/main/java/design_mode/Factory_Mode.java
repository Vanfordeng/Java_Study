package design_mode;

/**
 * Created by Doctor on 2016/10/20.
 * 工厂设计模式：接口为类的抽象
 * Tips:工厂设计模式的目的是：使用Factory类根据不同参数，获取不同子类的实例。而且将这些实例返回给客户端。已达到客户端不用去因为接口子类的增加而做new实例的操作。
 *
 * 装饰者模式：接口为方法的抽象
 * Tips:装饰者模式的目的是：使用一个装饰类来接收被装饰者实例,并用被装饰者实例来调用自己的功能。而装饰者类来对该被装饰者的功能做扩充。装饰者和被装饰者拥有同样的父类。在使用时：实例化装饰者就能使用扩充了的功能
 */
interface Fruit{
    public void eat();
}
class Apple implements Fruit{

    @Override
    public void eat() {
        System.out.println("*****吃苹果*****");
    }
}
class Orange implements Fruit{

    @Override
    public void eat() {
        System.out.println("*****吃橘子*****");
    }

    public void cut(){
        System.out.println("---新方法，在向上转型后，Fruit类型的引用无法看到");
    }
}

/**
 * 现在的客户端不会看见具体的子类，因为所有的接口对象对象都是通过Factory类取得的，如果日后需要扩充新的Fruit对象，则只需要修改Factory类即可，
 * 但是客户端的调用不会发生变化
 */
class Factory{
    /*
     *类里面适用static方法有通常情况下有两种情况：
     * 1.不打算定义属性。（方法需要根据属性的不同来执行不同的操作）
     * 2.需要取得实例化对象
     */
    public static Fruit getInstance(String className){
        if ("apple".equals(className)){
            return  new Apple();
        }else if ("orange".equals(className)){
            return  new Orange();
        }else {
            return null;
        }
    }
}
/**判断一个代码是否真的好，有这么几个标准：
 * 客户端调用简单，不需要关注具体的细节
 * 客户端之外的代码修改，不影响用户的使用，即：用户不用去关系代码是否变更
 */
public class Factory_Mode {
    public static void main(String[] args){
        //1.本次程序没有任何的语法错误,但是关键的问题就出现在了关键字“new"上。一个接口不能只有一个子类
        //如果有多个子类，如果直接在客户端上产生了实例化对象，那么每一次想要更换对象。都需要去修改客户端代码。这样的做法明显是不好的
        //在整个代码过程之中，我们最需要关系的就是如何取得一个Fruit接口对象，而后进行方法的调用。至于这个接口对象是被谁实例化的，那不是客户端的工作。
        //经过分析发现：最大的问题就在于关键字new,而这一问题就可以理解为耦合度太高。耦合度太高的直接问题,代买不方便维护，就相当于A一直要与B绑定在一起。可以完全参照Java虚拟机的设计思想
        //程序->jvm->->适用不同的操作系统
        //A->B(中间增加一层，解除应用程序的耦合)->C
        //Fruit f = new Orange();



        Fruit f = Factory.getInstance("orange");
        f.eat();
        Orange o = (Orange) f;
        o.cut();
    }
}
