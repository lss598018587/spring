package com.wm.spring.aop.advisor;

public class Dog implements Animal {

	@Override
	public void sayHello(String name, int age) {
		System.out.println("==名字：" + name + " 年龄：" + age);
	}

	@Override
	public void sayException(String name, int age) {
		System.out.println("==名字：" + name + " 年龄：" + age);
//		if(true){
//			throw new RuntimeException();
//		}
	}
}
