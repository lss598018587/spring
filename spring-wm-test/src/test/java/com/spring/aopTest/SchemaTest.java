package com.spring.aopTest;

import com.wm.spring.aop.schema.Cat;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchemaTest {
	@Test
	public void test1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop-schema.xml");
		Cat cat = ctx.getBean("cat", Cat.class);
		cat.sayHello("美美", 3);
	}


	@Test
	public void test2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop-schema.xml");
		Cat cat = ctx.getBean("cat", Cat.class);
		cat.sayException("美美", 3);
	}
}
