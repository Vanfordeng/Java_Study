package com.study_mars;

/**
 * Created by Administrator on 2016/9/5.
 */
//Tips:抽象类天生就是当爹的，抽象函数会被继承。所以子类如果不实现父类的抽象方法，子类也是抽象类。
// Tips:抽象类具有强制重写的属性，对于必须有的方法.对于具体类来说不会忘记定义该抽象方法
//    如果一段代码在语意上有错误,那么在语法上也应该是有错误的；如果语法上没有错误，就将其设计为语法错误
//    Tips:protected权限首先拥有和default一样的功能，但是该权限只能修饰成员变量和成员函数。在包之外,只有子类有权限访问
//    public >protect >default >private
public abstract class Java_Basic_Abstract {
    abstract public void eat();
}
