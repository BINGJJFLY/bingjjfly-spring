package com.wjz.springAnno.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import com.wjz.springAnno.bean.Red;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		
		boolean y = registry.containsBeanDefinition("com.wjz.springAnno.bean.Yellow");
		boolean b = registry.containsBeanDefinition("com.wjz.springAnno.bean.Blue");
		
		if (y && b) {
			RootBeanDefinition definition = new RootBeanDefinition(Red.class);
			registry.registerBeanDefinition("red", definition);
		}
	}

}
