package com.wm.spring.aop.aspectJ;

public class Dog  implements Animal {
	public void sayHello() {
		System.out.println("--被增强的方法");
	}
}