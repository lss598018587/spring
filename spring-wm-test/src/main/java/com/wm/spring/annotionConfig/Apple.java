package com.wm.spring.annotionConfig;

import org.springframework.beans.factory.annotation.Autowired;

public class Apple {
	@Autowired
	private Juice juice;


	boolean Flag = true;
	public void call(){
		System.out.println("apple call");
		if(Flag){
			Flag = false;
			juice.call();
		}
	}
}
