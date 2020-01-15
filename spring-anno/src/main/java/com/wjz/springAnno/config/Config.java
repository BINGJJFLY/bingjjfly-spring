package com.wjz.springAnno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.wjz.springAnno.bean.Color;
import com.wjz.springAnno.bean.Person;
import com.wjz.springAnno.condition.ColorFactoryBean;
import com.wjz.springAnno.condition.MyImportBeanDefinitionRegistrar;
import com.wjz.springAnno.condition.MyImportSelector;
import com.wjz.springAnno.condition.WindowsCondition;

@Configuration
//@ComponentScan(value = "com.wjz", excludeFilters = {
//		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }, includeFilters = {
//				@Filter(type = FilterType.ANNOTATION, classes = { Service.class }) }, useDefaultFilters = false)
//@ComponentScan(value = "com.wjz", includeFilters = {
//		@Filter(type = FilterType.CUSTOM, classes = { MyTypeFilter.class }) })
//@Conditional(LinuxCondition.class)
@Import({Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class Config {

	@Bean
	@Lazy // 懒加载
	@Conditional(WindowsCondition.class)
	public Person person() {
		Person p = new Person();
		p.setAge(18);
		p.setName("iss002");
		return p;
	}

	@Bean
	@Scope("prototype") // 多实例，单实例在IOC创建时便创建，多实例在获取Bean时创建
	public Person scope() {
		Person p = new Person();
		p.setAge(18);
		p.setName("iss002");
		return p;
	}
	
	/**
	 * 给容器注册组件
	 * 1) 包扫描+组件注解，局限于自己写的类
	 * 2) @Bean 可以导入第三方类
	 * 3) @Import 可以导入第三方类，Bean的id默认是类的全类名
	 * 4) ImportSelector 批量导入
	 * 5) ImportBeanDefinitionRegistrar 自定义Bean注入
	 * 6) FactoryBean
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
