package class_set_framework;

import java.util.Stack;

/**
 * Created by Doctor on 2016/12/14.
 * 栈
 * Stack表示的是栈操作,栈是一种先进后出的数据结构
 * Stack是Vector的子类
 * public class Stack<E> extends Vector<E>
 * Since:JDK1.0
 * 虽然是Stack是Vector子类,可是他不会使用Vector类的方法
 *  |-：入栈  public E push(E item)
 *  |-：出栈  public E pop()
 *
 */
public class Java_Basic_Stack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
        //在进行栈操作的过程之中,如果栈以及没有数据了，那么无法继续出栈。
//        stack.pop();   //Exception in thread "main" java.util.EmptyStackException
        //Todo 栈的这种操作现在唯一还算是有点能够编程的应用，就在Android上(Back键，先进后出。有点类似弹夹)。
    }
}
