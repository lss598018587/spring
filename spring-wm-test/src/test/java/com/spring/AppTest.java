package com.spring;

import com.wm.spring.LifeCycleBean;
import com.wm.spring.MyTestBean;
import com.wm.spring.annotionConfig.Apple;
import com.wm.spring.auto.Mouse;
import com.wm.spring.auto.Teacher;
import com.wm.spring.beanFactoryPosts.Teachers;
import com.wm.spring.xmls.Car;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AppTest {
	@Test
	public void MyTestBeanTest() {
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("spring-config.xml"));
		MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
		System.out.println(myTestBean.getName());
	}
	@Test
	public void test13() {
		// 生命周期测试
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
		LifeCycleBean myLifeCycleBean = applicationContext.getBean("myLifeCycleBean", LifeCycleBean.class);
		System.out.println("08-->bean可以被使用了, beanInfo: " + myLifeCycleBean.toString());
		((ClassPathXmlApplicationContext) applicationContext).destroy();
	}
	@Test
	public void test14() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-auto-base.xml");
		Mouse dog = applicationContext.getBean("mouse", Mouse.class);
		dog.help();
	}
	@Test
	public void test15() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-origin-base.xml");
		Car dog = applicationContext.getBean("car", Car.class);
		dog.call();
	}
	@Test
	public void test16() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-annotion-config.xml");
		Apple dog = applicationContext.getBean("apple", Apple.class);
		dog.call();
	}

	@Test
	public void test17() throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-post-processor-teacher.xml");
		Teachers teacher = applicationContext.getBean("teachers",Teachers.class);
		teacher.teach();

	}

}
