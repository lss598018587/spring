package com.spring.aopTest;

import com.wm.spring.aop.advisor.*;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class AdvisorTest {
	@Test
	public void test5() {
		// 前置增强
		// 1、实例化bean和增强
		Animal dog = new Dog();
		MyMethodBeforeAdvice advice = new MyMethodBeforeAdvice();

		// 2、创建ProxyFactory并设置代理目标和增强
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(dog);
		proxyFactory.addAdvice(advice);

		// 3、生成代理实例
		Animal proxyDog = (Animal) proxyFactory.getProxy();
		proxyDog.sayHello("二哈", 3);
	}

	@Test
	public void test6() {
		// 后置增强
		// 1、实例化bean和增强
		Animal dog = new Dog();
		MyAfterReturningAdvice advice = new MyAfterReturningAdvice();

		// 2、创建ProxyFactory并设置代理目标和增强
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(dog);
		proxyFactory.addAdvice(advice);

		// 3、生成代理实例
		Animal proxyDog = (Animal) proxyFactory.getProxy();
		proxyDog.sayHello("二哈", 3);

	}

	@Test
	public void test7() {
		// 异常增强
		// 1、实例化bean和增强
		Animal dog = new Dog();
		MyThrowsAdvice advice = new MyThrowsAdvice();

		// 2、创建ProxyFactory并设置代理目标和增强
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(dog);
		proxyFactory.addAdvice(advice);

		// 3、生成代理实例
		Animal proxyDog = (Animal) proxyFactory.getProxy();
		proxyDog.sayException("二哈", 3);
//		proxyDog.sayHello("二哈", 3);
	}


	@Test
	public void test8() {
		// 环绕增强
		// 1、实例化bean和增强
		Animal dog = new Dog();
		MyMethodInterceptor advice = new MyMethodInterceptor();

		// 2、创建ProxyFactory并设置代理目标和增强
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(dog);
		proxyFactory.addAdvice(advice);

		// 3、生成代理实例
		Animal proxyDog = (Animal) proxyFactory.getProxy();
		proxyDog.sayHello("二哈", 3);

	}
}
