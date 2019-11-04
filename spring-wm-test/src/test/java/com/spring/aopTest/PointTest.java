package com.spring.aopTest;

import com.wm.spring.aop.advisor.MyMethodBeforeAdvice;
import com.wm.spring.aop.pointcut.Animal;
import com.wm.spring.aop.pointcut.Cat;
import com.wm.spring.aop.pointcut.Dog;
import com.wm.spring.aop.pointcut.MyStaticPointcutAdvisor;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class PointTest {
	@Test
	public void test1() {
		// 1、创建目标类、增强、切入点
		Animal animal = new Dog();
		MyMethodBeforeAdvice advice = new MyMethodBeforeAdvice();
		MyStaticPointcutAdvisor advisor = new MyStaticPointcutAdvisor();

		// 2、创建ProxyFactory并设置目标类、增强、切面
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(animal);
		// 为切面类提供增强
		advisor.setAdvice(advice);
		proxyFactory.addAdvisor(advisor);

		// 3、生成代理实例
		Dog proxyDog = (Dog) proxyFactory.getProxy();
		proxyDog.sayHelloDog();
		System.out.println("\n\n");
		proxyDog.sayHello();

	}

	@Test
	public void test2() {
		// 1、创建目标类、增强、切入点
		Animal animal = new Cat();
		MyMethodBeforeAdvice advice = new MyMethodBeforeAdvice();
		MyStaticPointcutAdvisor advisor = new MyStaticPointcutAdvisor();

		// 2、创建ProxyFactory并设置目标类、增强、切面
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(animal);
		// 为切面类提供增强
		advisor.setAdvice(advice);
		proxyFactory.addAdvisor(advisor);

		// 3、生成代理实例
		Cat proxyDog = (Cat) proxyFactory.getProxy();
		proxyDog.sayHelloCat();
		System.out.println("\n\n");
		proxyDog.sayHello();

	}
}
