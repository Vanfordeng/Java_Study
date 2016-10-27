package design_mode;

/**
 * Created by Doctor on 2016/10/20.
 * 代理设计模式:核心精髓就在于有一个主题操作接口（可能有多重方法），接口为方法的抽象
 * Tips:代理设计模式的目的是：一个核心的操作需要在执行前或者执行后附加上一些步骤或者说功能才能去执行。增加一个代理类来完成。核心类只关心核心操作
 * 与装饰者模式类似。但是两者的用途不同：装饰者模式主要作用于给现有的功能增加功能，重点在增加功能,代理模式主要是用于让核心类专注于核心功能
 */
interface Subject{
    public void make();
}
class  RealSubject implements Subject{
    @Override
    public void make() {
        System.out.println("皇帝陛下正在xxx");
    }
}

//
class ProxySubject implements  Subject{
    private Subject subject;
    //要接收一个真实主题的操作对象
    public  ProxySubject(Subject subject){
        this.subject = subject;
    }
    public void prepare(){
        System.out.println("公公为临幸做准备");;
    }
    @Override
    public void make() {
        this.prepare();
        this.subject.make();
        this.destroy();
    }
    public void destroy(){
        System.out.println("把娘娘搬走了。。");
    }
}

public class Proxy_Mode {
    public static void main(String[] args){
        Subject sub =  new ProxySubject(new RealSubject());
        sub.make(); //调用的是代理主题的操作，由代理主题调用的真实主题。代理完成比真实更多的操作
    }
}
