package class_set_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Doctor on 2016/12/14.
 * Collections
 * 在Java提供类库的时候考虑到用户的使用方便性，所以专门提供了一个集合的工具类--Collections
 * 这个工具类可以实现，List、Set、Map 集合的操作。
 * public class Collections extends Object   //直接继承自Object
 * 提供如下方法：
 * 为集合添加多个数据：public static <T> boolean addAll(Collection<? super T> c,T... elements)
 * 反转：public static void reverse(List<?> list)
 */
public class Java_Basic_Collections {
    public static void main(String[] args) {
        List<String> list =  new ArrayList<String>();
        Collections.addAll(list,"A","B","C","D");
        System.out.println(list);
        //输出：[A, B, C, D]
        Collections.reverse(list);
        System.out.println(list);
        //Todo 面试题：Collection与Collections的区别？
        //Collection是集合操作的接口
        //Collections是集合操作的工具类,可以进行List、Set、Map 集合的操作
    }
}
