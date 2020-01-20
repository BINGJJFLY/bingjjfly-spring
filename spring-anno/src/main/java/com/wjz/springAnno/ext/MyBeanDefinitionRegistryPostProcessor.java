package com.wjz.springAnno.ext;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import com.wjz.springAnno.bean.Blue;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor#postProcessBeanFactory");
		System.out.println("Bean的个数："+beanFactory.getBeanDefinitionCount());
		System.out.println("Bean的名："+Arrays.asList(beanFactory.getBeanDefinitionNames()));
	}

	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("MyBeanDefinitionRegistryPostProcessor#postProcessBeanDefinitionRegistry");
		System.out.println("Bean的个数："+registry.getBeanDefinitionCount());
		System.out.println("Bean的名："+Arrays.asList(registry.getBeanDefinitionNames()));
	
//		RootBeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
		BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(Blue.class).getBeanDefinition();
		
		registry.registerBeanDefinition("hello", beanDefinition);
	}

}
