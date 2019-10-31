package com.spring.resoueces;

import com.spring.MyTest;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class ResourcesTest {

	@Test
	public void test1() {
		// 从资源文件夹下加载
		Resource resource = new ClassPathResource("spring-processor.xml");
		print(resource);

	}

	@Test
	public void test2() {
		// 使用类信息加载
		Resource resource = new ClassPathResource("/spring-processor.xml", ResourcesTest.class);
		print(resource);

	}

	@Test
	public void test3() {
		// 使用类加载器从资源文件夹下加载
		Resource resource = new ClassPathResource("spring-processor.xml", MyTest.class.getClassLoader());
		print(resource);
	}

	@Test
	public void test4() {
		// 使用DefaultResourceLoader加载
		Resource resource = new DefaultResourceLoader().getResource("spring-processor.xml");
		print(resource);
	}

	@Test
	public void test5() {
		// 使用自定义协议解析器加载
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		resourceLoader.addProtocolResolver(new MyProtocolResolver());
		Resource resource = resourceLoader.getResource("my:/spring-processor.xml");
		print(resource);
	}

	// 打印资源文件内容
	public void print(Resource resource) {
		byte[] read = new byte[10000];
		try {
			resource.getInputStream().read(read, 0, read.length);
			System.out.println(new String(read));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
