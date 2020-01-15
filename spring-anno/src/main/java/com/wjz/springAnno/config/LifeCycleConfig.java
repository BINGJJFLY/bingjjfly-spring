package com.wjz.springAnno.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wjz.springAnno.bean.Car;
import com.wjz.springAnno.bean.Cat;
import com.wjz.springAnno.bean.Dog;
import com.wjz.springAnno.bean.MyBeanPostProsoccer;

@Configuration
public class LifeCycleConfig {

	/**
	 * 1、@Bean的initMethod和destroyMethod方法
	 * 单实例，容器创建时执行initMethod，容器关闭时执行destroyMethod
	 * 多实例，获取Bean时执行initMethod，容器关闭时不执行destroyMethod
	 * @return
	 */
//	@Scope("prototype")
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public Car car() {
		return new Car();
	}
	
	/**
	 * 2、实现InitializingBean, DisposableBean接口
	 * @return
	 */
	@Bean
	public Cat cat() {
		return new Cat();
	}
	
	/**
	 * 3、使用@PostConstruct和@PreDestroy
	 * @return
	 */
	@Bean
	public Dog dog() {
		return new Dog();
	}
	
	/**
	 * 4、实现BeanPostProcessor
	 * @return
	 */
	@Bean
	public BeanPostProcessor beanPostProsoccer() {
		return new MyBeanPostProsoccer();
	}
}
