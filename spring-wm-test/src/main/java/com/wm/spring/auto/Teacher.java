package com.wm.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("teacher")
@Scope(value = "prototype")
public class Teacher {

	@Autowired
	private Mouse mouse;

	boolean FLAG = true;

	public void test(){
		System.out.println("123"+FLAG);
		if(FLAG){
			FLAG =false;
			mouse.help();
		}
	}
}
