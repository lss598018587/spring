package com.wm.spring.aop.aspectJ;

public class IntroduceImpl implements IIntroduce {

	@Override
	public void sayIntroduce() {
		System.out.println("--引入");
	}
}