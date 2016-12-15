package class_library;

/**
 * Created by Doctor on 2016/11/2.
 * System
 * 1.如何计算某段代码的执行时间  public static long currentTimeMillis()
 * 2.垃圾收集操作:public static void gc()  //The call System.gc() is effectively equivalent to the call: Runtime.getRuntime().gc()
Todo:对象产生一定会调用构造方法，可以进行一些处理操作。但是某一个对象如果要被回收了，那么连一个收尾的机会都没有
 Todo:@@如果需要给对象一个收尾的机会,那么久可以考虑覆写Object类中的finalize()方法完成(类似于C++中的析构函数)
 Todo:finalize():protected void finalize() throws Throwable  【protected访问权限的特点：同一包中的类和不同包的子类】
 Throwable 的意思是：在finalize()方法中可能产生Error或者Exception两种异常，暂时理解会有JVM处理 |-- 在对象回收时就算抛出了任何的异常，也不会影响到整个程序的正常秩序
 *
 * 包含有以下方法：
 * 数组拷贝： public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
 * 获取当前系统时间：public static long currentTimeMillis()
 *
 */
class Member{
    public Member(){
        System.out.println("我出生了！");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("我Die了");
        throw new Exception("十八年后我还会回来的,于是Die了");
    }
}
public class Java_lib_System {
    public static void main(String[] args) {
        try {
            Member mem = new Member();  //会出现一些辅助操作
            mem = null;  //会产生垃圾被GC回收
            System.gc();  //等效于Runtime.getRuntime().gc();
        }catch (Exception e){
            e.printStackTrace();
        }
        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("本次操作所花费的时间：" + (end-start));
    }

    //Todo 面试题：final，finally,finalize的区别？
    /* final：关键字,定义不能够被继承的类,不能被覆写的方法，常量
     * finally:关键字，异常的统一出口
     * finalize:方法，Object类提供的方法（protected void finalize() throws Throwable),指的是对象回收前的收尾方法,即使出现了异常也不会导致程序中断执行。
     */
}
