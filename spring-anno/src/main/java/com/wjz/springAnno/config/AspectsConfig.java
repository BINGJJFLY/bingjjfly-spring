package com.wjz.springAnno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.wjz.springAnno.aop.Compute;
import com.wjz.springAnno.aop.LogAspects;
import com.wjz.springAnno.aop.Logging;
import com.wjz.springAnno.aop.LogicScanner;

/**
 * 1、导入AOP模块：spring-aspects
 * 2、定义一个业务类，逻辑执行时打印日志（执行前、后、返回、异常）
 * 3、定义一个切面类，切面类里的方法需要动态感知业务类方法执行到哪一步了
 * 		通知方法：
 * 			前置通知
 * 			后置通知
 * 			返回通知
 * 			异常通知
 * 			环绕通知
 * 4、给切面类标注注解
 * 5、业务类和切面类加入容器
 * 6、告诉容器谁是切面类：@Aspect
 * 7、启用注解配置：@EnableAspectJAutoProxy
 * 
 * 原理：
 * 		@EnableAspectJAutoProxy内部有@Import(AspectJAutoProxyRegistrar.class),
 * 		AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar,可以注册组件
 * 		判断是否有org.springframework.aop.config.internalAutoProxyCreator这个Bean，如果没有则注入
 * 		org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator类型的Bean
 * @author iss002
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectsConfig {
	
	@Bean
	public Compute compute() {
		return new Compute();
	}
	
	@Bean
	public LogAspects logAspects() {
		return new LogAspects();
	}

	@Bean
	public Logging logging() {
		return new Logging();
	}
	
	@Bean
	public LogicScanner logicScanner() {
		return new LogicScanner();
	}
}
