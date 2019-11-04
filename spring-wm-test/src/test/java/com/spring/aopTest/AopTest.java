package com.spring.aopTest;

import com.wm.spring.aop.cglib.TaobaoCglibProxy;
import com.wm.spring.aop.cglib.TeaOnlineCglibShop;
import com.wm.spring.aop.jdkdynamicproxy.OnlineShop;
import com.wm.spring.aop.jdkdynamicproxy.TaobaoProxy;
import com.wm.spring.aop.jdkdynamicproxy.TeaOnlineShop;
import com.wm.spring.aop.spring.IBussinessService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Proxy;

public class AopTest {
	@Test
	public void jdkDynamicProxyTest() throws Exception{
		//被代理的对象
		TeaOnlineShop teaShop = new TeaOnlineShop();
		//Proxy 入参三个 加载器，class文件， 实现innovationhandler接口的代理对象
		OnlineShop shop = (OnlineShop) Proxy.newProxyInstance(this.getClass().getClassLoader()
				,new Class[]{OnlineShop.class}
				,new TaobaoProxy(teaShop));
		shop.sellSomething(30d);


	}

	@Test
	public void cgLibProxyTest(){
		TaobaoCglibProxy proxy = new TaobaoCglibProxy();
		//通过生成子类的方式创建代理类
		Object obj = proxy.getProxy(TeaOnlineCglibShop.class);
		TeaOnlineCglibShop shopProxy = (TeaOnlineCglibShop)obj;
		shopProxy.sellSomething(22d);
	}


	@Test
	public void testProxyFactoryBean(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop-bean.xml");
		IBussinessService bussinessServiceImpl =  applicationContext.getBean("methodProxy",IBussinessService.class);
		bussinessServiceImpl.bussiness();

	}

}
