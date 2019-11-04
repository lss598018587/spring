package com.wm.spring.aop.advisor;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕增强
 * @author: LiYanChao
 * @create: 2018-11-01 22:29
 */
public class MyMethodInterceptor implements MethodInterceptor {

	/**
	 * 环绕增强 这里的方法参数与之前的前置增强、后置增强明显不同，只有一个MethodInvocation类型的参数
	 */
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("==环绕增强开始");
		System.out.println("==方法名：" + invocation.getMethod().getName());
		Object[] args = invocation.getArguments();
		if (null != args && args.length > 0) {
			for (int i = 0; i < args.length; i++) {
				System.out.println("==第" + (i + 1) + "参数：" + args[i]);
			}
		}

		Object proceed = invocation.proceed();

		System.out.println("==环绕增强结束");
		return proceed;
	}
}
