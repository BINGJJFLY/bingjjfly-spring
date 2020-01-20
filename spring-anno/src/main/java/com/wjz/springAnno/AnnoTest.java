package com.wjz.springAnno;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.wjz.springAnno.aop.Compute;
import com.wjz.springAnno.bean.DataSource;
import com.wjz.springAnno.bean.Person;
import com.wjz.springAnno.bean.Prop;
import com.wjz.springAnno.config.AspectsConfig;
import com.wjz.springAnno.config.Config;
import com.wjz.springAnno.config.ExtConfig;
import com.wjz.springAnno.config.LifeCycleConfig;
import com.wjz.springAnno.config.TxConfig;
import com.wjz.springAnno.service.PersonService;

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
	
	@Test
	public void prop() {
		Prop prop = (Prop) ctx.getBean("prop");
		System.out.println(prop);
		Environment env = ctx.getEnvironment();
		System.out.println(env.getProperty("prop.lastName"));
	}
	
	/**
	 * Aware接口的子接口，组件实现这些接口时会自动注入相关组件
	 * xxxAware使用xxxProcessor，后置处理器
	 */
	@Test
	public void aware() {
		
	}
	
	@Test
	public void profile() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		context.register(Config.class);
		context.refresh();
		String[] names = context.getBeanNamesForType(DataSource.class);
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
	
	@Test
	public void aspects() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectsConfig.class);
		Compute compute = context.getBean(Compute.class);
		compute.div(1, 0);
		context.close();
	}
	
	@Test
	public void tx() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TxConfig.class);
		
		PersonService service = context.getBean(PersonService.class);
		service.insert();
		
		context.close();
	}
	
	@Test
	public void beanFactoryPostProcessor() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);
		context.close();
	}
	
	@Test
	public void applicationListener() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class);
		context.publishEvent(new ApplicationEvent(new String("发布事件")) {
		});
		context.close();
	}
}
