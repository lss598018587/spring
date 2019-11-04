package com.wm.spring.aop.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TaobaoProxy implements InvocationHandler {

	/**
	 * 被代理的对象
	 */
	private Object proxied;

	public TaobaoProxy(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//马云爸爸表示收到的钱先放在淘宝，来提高GMV

		System.out.println("taobao say:    "+args[0]+"$ money temp save to taobao to increase my gmv");

		return method.invoke( proxied, args);

	}
}
