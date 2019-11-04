package com.wm.spring.aop.jdkdynamicproxy;

public class TeaOnlineShop implements OnlineShop {
	@Override
	public void sellSomething(double money) {
		System.out.println("shop say    :you give me "+money +"$ and I sell you some tea");

	}
}
