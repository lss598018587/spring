package com.wm.spring.xmls;

public class Car {
	private  Bicker bicker;
	public void call(){
		System.out.println("我是Car");
		bicker.call();
	}

	public void setBicker(Bicker bicker) {
		this.bicker = bicker;
	}
}
