package com.wm.spring.annotionConfig;

import org.springframework.beans.factory.annotation.Autowired;

public class Juice {
	@Autowired
	private Apple apple;


	public void call(){
		System.out.println("juice call");
		apple.call();
	}
}
