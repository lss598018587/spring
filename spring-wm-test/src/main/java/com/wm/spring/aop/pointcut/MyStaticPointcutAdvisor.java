package com.wm.spring.aop.pointcut;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import java.lang.reflect.Method;
/**
 * 静态普通方法名匹配切面
 */
public class MyStaticPointcutAdvisor extends StaticMethodMatcherPointcutAdvisor {

	private static final long serialVersionUID = 1L;

	private static String METHOD_NAME = "sayHello";

	/**
	 * 静态方法匹配判断，这里只有方法名为sayHello的，才能被匹配
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return METHOD_NAME.equals(method.getName());
	}

	/**
	 * 覆盖getClassFilter，只匹配Dog类
	 * @return
	 */
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return Dog.class.isAssignableFrom(clazz);
			}
		};
	}
}
