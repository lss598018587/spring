package com.spring;

import com.wm.spring.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MiaoTest {
	private XmlBeanFactory xmlBeanFactory;

	@Before
	public void initXmlBeanFactory() {
		System.setProperty("spring.profiles.active", "dev");
		System.out.println("\n========测试方法开始=======\n");
		xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("spring-base.xml"));
	}
	@After
	public void after() {
		System.out.println("\n========测试方法结束=======\n");
	}

	@Test
	public void test21() {
		System.out.println("yes");
		Student dog1 = xmlBeanFactory.getBean("dog1", Student.class);
	}


}
