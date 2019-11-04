package com.wm.spring.aop.pointcut;

public class Cat implements Animal {

	@Override
	public void sayHello() {
		System.out.println("我是Cat类的sayHello方法。。。");
	}

	public void sayHelloCat() {
		System.out.println("我是一只猫。。。");
	}

}
