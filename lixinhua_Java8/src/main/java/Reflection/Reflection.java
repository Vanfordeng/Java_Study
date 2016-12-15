package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Doctor on 2016/11/8.
 * 反射
 * 反射的话先通过“反”来理解，既然有“反”就一定有“正“，在正常情况下，一定是先有类，再产生对象
 * 所谓的“反”就是指可以利用对象找到对象的出处，在Object类里面提供有一个方法：
 *   |——取得对象的完整类名称，等于找到了对象的出处：public final native Class<?> getClass();   // 此处的"?" 是泛型在反射中最糟糕的应用
 *Todo Class 类对象实例化
 * public final class Class<T> extends Object implements Serializable, GenericDeclaration, Type, AnnotatedElement
 *java.lang.Class 是一个类,这个类时反射操作的源头，即，所有的反射都要从此类开始进行，而最关键的这个类有三种实例化方式：
 *  |-- 调用Object类中的getClass()方法
 *  |-- 使用“类.class"取得
 *  |-- 调用Class类提供的一个方法：此时可以不使用import语句导入一个明确的类，而类名称是采用字符串的形式描述的
 *      |-实例化Class类对象：public static Class<?> forName(String className) throws ClassNotFoundException
 *Todo 反射实例化对象
 * public T newInstance() throws InstantiationException,IllegalAccessException  //Creates a new instance of the class represented by this Class object.
 *
 *
 */

class Book{
    private String title;
    private double price;

    public Book(){
        super();
    }
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "书名称：" + this.title + "\t书价格：" + this.price;
    }
}

public class Reflection {
    public static void main(String[] args) {
        Date date = new Date();//产生对象
        //观察"反"
        System.out.println(date);  //Tue Nov 08 14:29:30 CST 2016
        Object obj = new Object();
        System.out.println(obj.getClass());  //class java.lang.Object
        System.out.println(date.getClass());  //class java.util.Date

        //Class类的三种实例化方式
        //Todo 一：利用对象实例化，调用Object类中的getClass()方法
        System.out.println("---------------------------------------------------------------");
        Class<?> cls = date.getClass();
        Class cls1 = date.getClass();
        System.out.println(cls);  //class java.util.Date
        System.out.println(cls1);  //class java.util.Date
        //Todo 二：使用“类.class"取得(此时没有实例化对象的产生)
        System.out.println("---------------------------------------------------------------");
        Class<?> cls2 = Date.class;
        System.out.println(cls2);   //class java.util.Date
        //Todo 三：调用Class类提供的一个静态方法：public static Class<?> forName(String className) throws ClassNotFoundException    //className
        System.out.println("---------------------------------------------------------------");
        try {
            Class<?> cls3 = Class.forName("java.util.Date");  //此时可以不适用import语句导入一个明确的类，而类名称是采用字符串的形式描述的
            System.out.println(cls3);   //class java.util.Date
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("---------------------------------------------------------------");
        //Todo 反射实例化对象
//        Book book =  new Book();
//        System.out.println(book);
        try {
            System.out.println("反射实例化对象：--------------------------------");
            Class<?> cls_book = Class.forName("Reflection.Book");  //记住了，反射的所有泛型就写“？”
            //发现对象实例化不再只能使用关键字new了，但是这并不代表关键字new被完全取代了
            Object obj_book = cls_book.newInstance();  //Todo 相当于使用new调用无参构造实例化，为什么要用Object接收,可以想为习惯和?有关。如果不想Object可以转型
            System.out.println(obj_book);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //Todo 在任何的开发之中,new是造成耦合的最大元凶，一切的耦合都起源于new
        //观察TestFactory.java:如果Fruit增加了子类,那么就必须修改工厂类.如果随时都可能增加子类？工厂类要被一直进行修改
        //为什么要修改？因为现在工厂类中对象都是通过关键字new直接实例化的，而new就造成了这个问题的关键点。要想解决此问题.就只能
        //依靠反射完成。
        //Todo 使用反射调用构造
        System.out.println("使用反射调用构造：--------------------------------");
        //如果没有默认无参构造而调用无参构造会出现：java.lang.InstantiationException: Reflection.Book
        //在Class中提供有一个方法可以取得构造：
          //|——取得全部构造：public Constructor<?>[] getConstructors() throws SecurityException
          //|——取得一个指定参数顺序的构造：public Constructor<T> getConstructor(Class<?>... parameterTypes)throws NoSuchMethodException,SecurityException
          //以上两个方法都是返回的java.lang.reflect.Constructor对象：public final class Constructor<T> extends Executable
          //在这个类中提供有一个明确传递有参构造的内容的实例化对象方法：public T newInstance(Object... initargs) throws InstantiationException IllegalAccessException,IllegalArgumentException,InvocationTargetException
          //
        try {
            Class<?> cls_book1 = Class.forName("Reflection.Book");
            //public Book(String title, double price),找的是类型
            Constructor<?> con = cls_book1.getConstructor(String.class,double.class);
            Object obj1 = con.newInstance("Java 开发",79.8);
            //这样的实例化感觉很麻烦，而且没有无参数构造会报错。所以，简单Java类中不管提供多少个构造方法，请至少保留有无参构造
            System.out.println(obj1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //Todo 使用反射调用方法
        //类中的普通方法只有在一个类参数实例化之后才可以调用。并且实例化对的方式有三种：new,clone，反射
        try {
            System.out.println("使用反射调用方法：--------------------------------");
            Class<?> cls_method = Class.forName("Reflection.Book");
            Object obj_method = cls_method.newInstance();
            String fieldName = "title";   //要获取的方法的属性名称
            //在Class类里面提供有以下取得类中Method的操作：
            // 取得指定方法：public Method getMethod(String name,Class<?>... parameterTypes)throws NoSuchMethodException,SecurityException
            // 取得一个类中的全部方法：public Method[] getMethods()throws SecurityException
            //以上两个方法都是返回的java.lang.reflect.Method对象：public final class Method extends Executable
            //在这个类中重点关注一个方法：
            //调用方法：public Object invoke(Object obj,Object... args)throws IllegalAccessException,IllegalArgumentException,InvocationTargetException
            Method setMet = cls_method.getMethod("set"+initcap(fieldName),String.class); //这也是为什么简单Java类中的属性统一规格为set和get方法的原因,在获取的时候可以统一获取
            Method getMet = cls_method.getMethod("get"+initcap(fieldName));//相当于:Book类对象.getTitle();
            setMet.invoke(obj_method,"Python开发");
            System.out.println(getMet.invoke(obj_method));
//            Book book_method = (Book) obj_method;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //Todo 使用反射调用成员（属性为private，但是可以通过反射调用。所谓的封装都是骗人的）
        //类中的属性一定要在本类实例化对象产生之后才可以分配内存空间。和普通方法的调用方法不大
        //|——:取得全部成员：public Field[] getDeclaredFields()throws SecurityException
        //|——:取得指定成员：public Field getDeclaredField(String name)throws NoSuchFieldException,SecurityException
        //以上两个方法都是返回的java.lang.reflect.Field对象：public final class Field extends AccessibleObject implements Member
        //在这个类中重点关注两个个方法：
        //|——:取得属性内容：public Object get(Object obj)throws IllegalArgumentException,IllegalAccessException
        //|——:设置属性内容：public void set(Object obj,Object value)throws IllegalArgumentException,IllegalAccessException
        try {
            System.out.println("使用反射调用成员：--------------------------------");
            Class<?> cls_field= Class.forName("Reflection.Book");
            Object obj_field= cls_field.newInstance();
            Field file_titled = cls_field.getDeclaredField("title");
//            file_titled.set(obj_field,"C#开发");//相当于:Book类对象.title = "C#开发"; 会提示异常：IllegalAccessException: Class Reflection.Reflection can not access a member of class Reflection.Book with modifiers "private"
//            System.out.println(file_titled.get(obj_field));//相当于:Book类对象.title;
            //Filed的父类：java.lang.reflect.AccessibleObject 下有两个子类：Executable, Field ，Executable下面有两个子类：Constructor, Method
            //JDK1.8之后修改：只有两个子类Executable, Field ，1.8之前有三个子类：Constructor, Method，Field。所以是Field类继续保持。而Constructor和Method封装给了Executable子类
            //在AccessibleObject中提供有一个方法:设置是否封装：public void setAccessible(boolean flag)throws SecurityException
            //下面使用该方法取消封装：（TODO 所谓的封装都是骗人的,因为Constructor,Method也是AccessibleObject的子类所以也可以取消封装，但是很少这么做）
            file_titled.setAccessible(true);
            file_titled.set(obj_field,"C#开发");
            System.out.println(file_titled.get(obj_field));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        /**@总结：
         * @实例化对象的方式又增加了一种：反射
         * @对于简单Java类的定义应该更加清晰了：包括为什么要提供无参构造,必须提供setter,getter方法
         * @反射调用类结构只是一个开始
         */

    }
    public static String initcap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
