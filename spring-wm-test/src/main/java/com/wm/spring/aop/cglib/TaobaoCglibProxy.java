package com.wm.spring.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib要实现MethodInterceptor接口
 */

public class TaobaoCglibProxy<T> implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();

	public Object getProxy(Class<T> clazz){
		//用enhancer 重新编制传入的class的对象
		enhancer.setSuperclass(clazz);
		//回调实现CallBack接口的类（MethodInterceptor基础于CallBack）此处就是回调TaobaoProxy
		enhancer.setCallback(this);
		return enhancer.create();
	}


	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("taobao say:    "+args[0]+"$ money temp save to taobao to increase my gmv");

		Object result = proxy.invokeSuper(obj, args);
		return result;
	}
}
