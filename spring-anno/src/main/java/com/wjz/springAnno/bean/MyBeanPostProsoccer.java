package com.wjz.springAnno.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProsoccer implements BeanPostProcessor {

	/**
	 * @Bean initMethod方法、@PostProcessor注释方法、InitializingBean's afterPropertiesSet方法执行之前执行
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessBeforeInitialization" + beanName + bean);
		return bean;
	}

	/**
	 * 初始化方法之后执行
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization" + beanName + bean);
		return bean;
	}

}
