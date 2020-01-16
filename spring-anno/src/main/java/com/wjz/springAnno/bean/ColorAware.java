package com.wjz.springAnno.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class ColorAware implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware, BeanFactoryAware {

	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		System.out.println(resolver.resolveStringValue("hello ${prop.lastName}, i am #{18*20}"));
	}

	public void setBeanName(String name) {
		System.out.println("Bean name" + name);
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext" + applicationContext);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory);
	}

}
