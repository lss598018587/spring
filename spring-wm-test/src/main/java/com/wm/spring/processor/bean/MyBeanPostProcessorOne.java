package com.wm.spring.processor.bean;
import com.wm.spring.processor.Dog;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class MyBeanPostProcessorOne implements BeanPostProcessor, Ordered {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor第" + getOrder() + "次被调动\n");
		if (bean instanceof Dog) {
			((Dog) bean).setName("强强");
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Dog) {
			((Dog) bean).setAge(5);
		}
		return bean;
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
