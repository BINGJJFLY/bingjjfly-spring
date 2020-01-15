package com.wjz.springAnno;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wjz.springAnno.bean.Person;
import com.wjz.springAnno.config.Config;
import com.wjz.springAnno.config.LifeCycleConfig;

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
	
	@Test
	public void scope() {
		Person p = (Person) ctx.getBean("person");
		Person scope = (Person) ctx.getBean("scope");
		System.out.println(p == scope);
	}
	
	@Test
	public void _import() {
		scan();
	}
	
	@Test
	public void factoryBean() {
		scan();
		Object bean = ctx.getBean("colorFactoryBean");
		System.out.println(bean.getClass());
		// factoryBean本身
		bean = ctx.getBean("&colorFactoryBean");
		System.out.println(bean.getClass());
	}
	
	@Test
	public void lifeCycle() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
		ctx.getBean("car");
		ctx.close();
	}
}
