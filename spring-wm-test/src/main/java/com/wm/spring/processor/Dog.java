package com.wm.spring.processor;

public class Dog {
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void sayHello(){
		System.out.println("大家好, 我叫"+name+", 我今年"+age+"岁了");
	}
}
