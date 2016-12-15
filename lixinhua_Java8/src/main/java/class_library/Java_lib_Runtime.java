package class_library;

import java.io.IOException;

/**
 * Created by Doctor on 2016/11/2.
 * Runtime:public class Runtime extends Object
 * Since:JDK1.0
 * 在每一个JVM进程里面都会存在有一个Runtime类的对象，这个类的主要功能是取得一些与运行时有关的环境的属性或者创建新的进程等操作
 *
 * 在Runtime类定义的时候它的构造方法以及被私有化了(源代码中: private Runtime() {}),这就属于单例设计模式的应用。要保证在整个进程里面只有唯一的一个Runtime类对象。
 * 所以在Runtime里面提供有一个static型的方法：public static Runtime getRuntime()来取得Runtime的实例化对象
 * Runtime类时直接与本地运行有关的所有相关属性的集合，提供有如下方法：
 * 1. public long freeMemory()  //返回空余内存空间
 * 2. public long totalMemory() //返回所有内存空间  除去系统占用的
 * 3. public long maxMemory()  //返回最大内存空间
 */
public class Java_lib_Runtime {
    public static void main(String[] args) {
        Runtime run =  Runtime.getRuntime();
        run.gc();
        System.out.println("Free:" + run.freeMemory());
        System.out.println("Total:" + run.totalMemory());
        System.out.println("Max:" + run.maxMemory());

        String str = "";
        for (int i = 0; i < 1000 ; i++) {
            str += i;
        }
        System.out.println("-----------------------");
        System.out.println("Free:" + run.freeMemory());
        System.out.println("Total:" + run.totalMemory());
        System.out.println("Max:" + run.maxMemory());

        run.gc();  //释放垃圾空间
        System.out.println("-----------------------");
        System.out.println("Free:" + run.freeMemory());
        System.out.println("Total:" + run.totalMemory());
        System.out.println("Max:" + run.maxMemory());

        //Todo 面试题：请解释什么叫GC？如何处理？
        /*GC(Garbage Collector)垃圾收集器,指的是释放无用的内存空间
         *GC 会有系统不定期的进行自动的回收，或者调用Runtime.gc()方法手工回收
         */
        //Todo Runtime类还有一个更加有意思的功能，就是说它可以调用本机的可执行程序，并且创建进程。
        //public Process exec(String command) throws IOException

        System.out.println(run.availableProcessors());

        try {
            Process pro = run.exec("mspaint.exe");//调用本机可执行程序
            Thread.sleep(500);
            pro.destroy();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
