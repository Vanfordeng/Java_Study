package com.study_mars.Class_eg;

public class Student extends Person {
	int grade;
	int age =7;
	//在子类的构造函数当中,必须调用父类的构造函数
	Student(){
//		super();  默认隐藏调用父类构造函数代码
		super();
		System.out.println("This is student no arguments constructor");
	}
	Student(int age,String name, int grade){
		super(age,name);
		this.grade = grade;
		//如下代码代表：this.age = super.age
//		this.age = age;
		//如下的age,是在构造函数执行完成之前.此时还没有对象产生。所有调用的是super.age
		System.out.println("This is student arguments constructor:"+age+"-->"+name+"---->"+grade);
	}

	//如下为重写
//	public int eat()由于返回值int不能区分程序调用的函数为父类还是之类.因为有的代码调用函数并不关心返回值。所以此段代码语法错误
//	如果将student类的eat方法注释,执行Test，会调用父类的eat方法.所谓：覆盖,子类有的调用子类的方法,子类没有的调用父类的方法。也可用super显示调用父类方法
	public void eat(){
//		eat();
		//如下代码打印的age是在构造函数执行完毕后已经有了Student对象,调用时使用this.age
		System.out.println("this is Student eat method:"+age);
	}
}
