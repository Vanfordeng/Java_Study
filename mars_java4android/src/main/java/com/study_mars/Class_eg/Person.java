package com.study_mars.Class_eg;

//Tips:越抽象,越不容易犯错
public class Person{
	protected int age;
	String name;

	protected Person(){
		System.out.println("this is Person no arguments constructor");
	}
	Person(int age,String name){
		this.age = age;
		this.name = name;
		System.out.println("this is Person arguments constructor:"+age+"--->"+name);
	}

	public void eat(){
		System.out.println("this is Person eat method:"+age);
	}
}