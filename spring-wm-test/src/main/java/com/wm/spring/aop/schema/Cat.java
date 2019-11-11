package com.wm.spring.aop.schema;

public class Cat implements Animal {

	@Override
	public void sayHello(String name, int age) {
		System.out.println("--调用被增强方法");
	}

	@Override
	public void sayException(String name, int age) {
		if(true){
			throw new RuntimeException();
		}
	}
}