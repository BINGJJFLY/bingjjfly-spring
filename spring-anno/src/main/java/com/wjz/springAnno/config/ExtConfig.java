package com.wjz.springAnno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wjz.springAnno.bean.Blue;

/**
 * 扩展原理：
 * 		1、BeanPostProcessor：Bean后置处理器，Bean创建对象初始化前后进行拦截工作
 * 		2、BeanFactoryPostProcessor：BeanFactory后置处理器，在BeanFactory标准初始化完成后
 * 			所有的Bean定义已经加载完成且保存到BeanFactory，但是还没有创建Bean
 *		3、BeanDefinitionRegistryPostProcessor：在所有Bean的定义信息将要被加载，Bean对象还未创建
 *			在BeanFactoryPostProcessor执行之前执行，可以给容器中添加一些自定义的组件通过注册bean定义组件
 *		4、ApplicationListener：监听容器中发布的事件，事件驱动模型开发
 *			监听ApplicationEvent及其子事件
 *
 * @author iss002
 *
 */
@ComponentScan("com.wjz.springAnno.ext")
@Configuration
public class ExtConfig {
	
	@Bean
	public Blue blue() {
		return new Blue();
	}
}
