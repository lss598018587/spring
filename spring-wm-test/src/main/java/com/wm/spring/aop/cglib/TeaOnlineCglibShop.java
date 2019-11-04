package com.wm.spring.aop.cglib;

/**
 * cglib不需要定义接口，直接给出具体实现
 */
public class TeaOnlineCglibShop {
	public void sellSomething(double money) {
		System.out.println("shop say    :you give me "+money +"$ and I sell you some tea");
	}
}
