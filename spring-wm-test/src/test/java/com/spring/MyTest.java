package com.spring;
import com.wm.spring.processor.Dog;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
public class MyTest {
	private XmlBeanFactory xmlBeanFactory;

	@Before
	public void initXmlBeanFactory() {
		System.setProperty("spring.profiles.active", "dev");
		System.out.println("\n========测试方法开始=======\n");
		xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-processor.xml"));
	}

	@After
	public void after() {
		System.out.println("\n========测试方法结束=======\n");
	}

	@Test
	public void test1() {
		// 测试BeanPostProcessor
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-processor.xml");
		Dog dog = applicationContext.getBean("dog", Dog.class);
		dog.sayHello();
	}


	@Test
	public void test2() {
		// 测试BeanFactoryPostProcessor
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-processor.xml");
		Dog dog = applicationContext.getBean("dog", Dog.class);
		dog.sayHello();
	}

}
