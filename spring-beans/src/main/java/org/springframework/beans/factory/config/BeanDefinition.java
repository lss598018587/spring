/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.config;

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.AttributeAccessor;
import org.springframework.lang.Nullable;

/**
 * A BeanDefinition describes a bean instance, which has property values,
 * constructor argument values, and further information supplied by
 * concrete implementations.
 *
 * <p>This is just a minimal interface: The main intention is to allow a
 * {@link BeanFactoryPostProcessor} such as {@link PropertyPlaceholderConfigurer}
 * to introspect and modify property values and other bean metadata.
 *
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @since 19.03.2004
 * @see ConfigurableListableBeanFactory#getBeanDefinition
 * @see org.springframework.beans.factory.support.RootBeanDefinition
 * @see org.springframework.beans.factory.support.ChildBeanDefinition
 */
public interface BeanDefinition extends AttributeAccessor, BeanMetadataElement {

	// 我们可以看到，默认只提供 sington 和 prototype 两种，
	// 很多读者都知道还有 request, session, globalSession, application, websocket 这几种，
	// 不过，它们属于基于 web 的扩展。
	String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
	String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;


	int ROLE_APPLICATION = 0;
	int ROLE_SUPPORT = 1;
	int ROLE_INFRASTRUCTURE = 2;


	// 设置父 Bean，这里涉及到 bean 继承，不是 java 继承。请参见附录介绍
	void setParentName(@Nullable String parentName);

	// 获取父 Bean
	@Nullable
	String getParentName();

	// 设置 Bean 的类名称
	void setBeanClassName(@Nullable String beanClassName);

	// 获取 Bean 的类名称
	@Nullable
	String getBeanClassName();

	// 设置 bean 的 scope
	void setScope(@Nullable String scope);

	@Nullable
	String getScope();

	// 设置是否懒加载
	void setLazyInit(boolean lazyInit);

	boolean isLazyInit();

	// 设置该 Bean 依赖的所有的 Bean，注意，这里的依赖不是指属性依赖(如 @Autowire 标记的)，
	// 是 depends-on="" 属性设置的值。
	void setDependsOn(@Nullable String... dependsOn);

	// 返回该 Bean 的所有依赖
	@Nullable
	String[] getDependsOn();

	// 设置该 Bean 是否可以注入到其他 Bean 中，只对根据类型注入有效，
	// 如果根据名称注入，即使这边设置了 false，也是可以的
	void setAutowireCandidate(boolean autowireCandidate);

	// 该 Bean 是否可以注入到其他 Bean 中
	boolean isAutowireCandidate();

	// 主要的。同一接口的多个实现，如果不指定名字的话，Spring 会优先选择设置 primary 为 true 的 bean
	void setPrimary(boolean primary);

	// 是否是 primary 的
	boolean isPrimary();

	// 如果该 Bean 采用工厂方法生成，指定工厂名称。对工厂不熟悉的读者，请参加附录
	void setFactoryBeanName(@Nullable String factoryBeanName);

	// 获取工厂名称
	@Nullable
	String getFactoryBeanName();

	// 指定工厂类中的 工厂方法名称
	void setFactoryMethodName(@Nullable String factoryMethodName);

	// 获取工厂类中的 工厂方法名称
	@Nullable
	String getFactoryMethodName();

	// 构造器参数
	ConstructorArgumentValues getConstructorArgumentValues();

	// Bean 中的属性值，后面给 bean 注入属性值的时候会说到
	MutablePropertyValues getPropertyValues();


	// Read-only attributes

	// 是否 singleton
	boolean isSingleton();

	// 是否 prototype
	boolean isPrototype();

	// 如果这个 Bean 原生是抽象类，那么不能实例化
	boolean isAbstract();

	int getRole();

	@Nullable
	String getDescription();

	@Nullable
	String getResourceDescription();

	@Nullable
	BeanDefinition getOriginatingBeanDefinition();

}
