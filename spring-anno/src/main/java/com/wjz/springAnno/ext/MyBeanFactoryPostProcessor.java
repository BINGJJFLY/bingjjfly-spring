package com.wjz.springAnno.ext;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanFactoryPostProcessor#postProcessBeanFactory");
		System.out.println("Bean个数："+beanFactory.getBeanDefinitionCount());
		System.out.println("Bean的名："+Arrays.asList(beanFactory.getBeanDefinitionNames()));
	}

}
