package com.wm.spring.xmls;

public class Bicker {

	private Car car;
	boolean flag =true;
	public void call(){
		System.out.println("我是Bicker");
		if(flag){
			flag=false;
			car.call();
		}
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
