package com.wjz.springAnno.ext;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 创建所有的单实例bean完成后触发操作，类似于监听容器刷新完成事件后触发操作
 * 
 * @author iss002
 *
 */
@Component
public class AfterSingletonsInstantiated implements SmartInitializingSingleton, ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void afterSingletonsInstantiated() {
		String[] names = applicationContext.getBeanDefinitionNames();
		System.out.println("所有的单实例Bean创建成功" + Arrays.asList(names));
	}
}
