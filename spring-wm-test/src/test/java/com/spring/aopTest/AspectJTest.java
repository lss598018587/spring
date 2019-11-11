package com.spring.aopTest;

import com.wm.spring.aop.aspectJ.Bird;
import com.wm.spring.aop.aspectJ.Dog;
import com.wm.spring.aop.aspectJ.IIntroduce;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJTest {

	@Test
	public void test1() {
		// 基于@AspectJ注解方式
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop-aspectJ.xml");
		Dog dog = ctx.getBean("dog", Dog.class);
		Bird bird = ctx.getBean("bird", Bird.class);
		dog.sayHello();
		bird.sayHello();
	}


	@Test
	public void test2() {
		// 引入
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop-aspectJ.xml");
		// 注意：getBean获取的是dog
		IIntroduce introduce = ctx.getBean("dog", IIntroduce.class);
		introduce.sayIntroduce();
	}

}
