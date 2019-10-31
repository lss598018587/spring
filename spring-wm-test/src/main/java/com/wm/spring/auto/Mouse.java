package com.wm.spring.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class Mouse {

	@Autowired
	private Teacher teacher;

	public void help(){
		System.out.println("吼叫");
		teacher.test();
	}
}
