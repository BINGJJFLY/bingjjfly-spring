package com.wjz.springAnno.ext;

import java.util.Arrays;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnoApplicationListener {

	/**
	 * EventListenerMethodProcessor：注册注解修饰了的方法为一个ApplicationListener
	 * SmartInitializingSingleton原理：
	 * 	AbstractApplicationContext的finishBeanFactoryInitialization方法，创建剩余所有的单实例bean
	 * 	DefaultListableBeanFactory的preInstantiateSingletons方法
	 * 		创建所有的bean实例，getBean()
	 * 		判断bean是否是SmartInitializingSingleton类型的
	 * 			如果是调用afterSingletonsInstantiated()类似于发布ContextRefreshedEvent事件
	 * 	
	 * @param event
	 */
	@EventListener(ApplicationEvent.class)
	public void listen(ApplicationEvent event) {
		System.out.println("注解式事件监听器，事件："+ event);
		if (event instanceof ContextRefreshedEvent) {
			AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) ((ContextRefreshedEvent) event).getSource();
			System.out.println("容器刷新完成后查看所有的Bean" + Arrays.asList(context.getBeanDefinitionNames()));
		}
	}
}
