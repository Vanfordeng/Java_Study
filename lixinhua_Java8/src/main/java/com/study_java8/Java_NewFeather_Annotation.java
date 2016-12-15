package com.study_java8;

/**
 * Created by Doctor on 2016/10/31.
 * Annotation:注解
 * Annotation是JDK 1.5最大的特色，利用注解的形式来实现程序的不同功能实现。
 * 在Java SE 里面支持自定义Annotation的开发,并且提供了三个最为常用的基础Annotation:@Override,@SuppressWarnings,@Deprecated
 * @Override:准确的覆写
 * @Deprecated:声明过期操作
 * @SuppressWarnings:压制警告信息
 */
class Book6<T>{
    private T title;

    public void setTitle(T title) {
        this.title = title;
    }

    public T getTitle() {
        return title;
    }

    @Deprecated    //告诉使用者,此方法过期了，利用此操作可以很好的实现方法功能的新旧交替。
    public void fun(){

    }

    @Override            //只要正确的进行了覆写,那么就不会出现编译的语法错误
    public String toString(){               //原本打算覆写（toString）
        return "这是一本书";
    }
}

public class Java_NewFeather_Annotation {
    public static void main(String[] args) {

        new Book6().fun();
        System.out.println(new Book6());
        
        @SuppressWarnings({"uncheck","rawtypes"})           //如果说现在是开发者故意留下的警告信息,但是又不希望其总是提示警告，就可以选择压制警告
        Book6 book6 = new Book6(); //定义Book6没有指定泛型类型,应该有警告
        book6.setTitle("Hello");
        System.out.println(book6.getTitle());
    }
}
