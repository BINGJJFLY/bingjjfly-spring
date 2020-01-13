package com.wjz.springAnno;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wjz.springAnno.bean.Person;
import com.wjz.springAnno.config.Config;

public class AnnoTest {
	
	ApplicationContext ctx;
	
	@Before
	public void init() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		this.ctx = ctx;
	}

	@Test
	public void bean() {
		Person p = (Person) ctx.getBean("person");
		System.out.println(p);
	}
	
	@Test
	public void scan() {
		String[] names = ctx.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println(name);
		}
	}
}
