package com.wm.spring.aop.spring;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MethodLoggerAdvice implements MethodBeforeAdvice {


	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		String name = method.getName();
		System.out.println("method name "+ name +" now is invoke");
	}

}

