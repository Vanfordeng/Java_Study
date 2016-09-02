package com.study_mars;

public class Person{
	int age;
	String name;

	Person(){
		System.out.println("this is Person no arguments construture");
	}
	Person(int age,String name){
		this.age = age;
		this.name = name;
		System.out.println("this is Person arguments construture"+age+"--->"+name);
	}

	public void eat(){
		System.out.println("this is Person eat method");
	}
}