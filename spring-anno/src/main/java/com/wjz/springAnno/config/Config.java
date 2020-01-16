package com.wjz.springAnno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.wjz.springAnno.bean.Color;
import com.wjz.springAnno.bean.ColorAware;
import com.wjz.springAnno.bean.DataSource;
import com.wjz.springAnno.bean.Person;
import com.wjz.springAnno.bean.Prop;
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
@PropertySource({"classpath:/prop.properties"})
@Profile("dev")
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
	
	/**
	 * @PropertySource 引入外部配置文件至环境变量中
	 * @return
	 */
	@Bean
	public Prop prop() {
		return new Prop();
	}
	
	/**
	 * @Autowired位置，构造器、方法、参数、属性
	 * @Bean 方法参数，参数对象从容器中获取
	 * 			构造器，只有一个构造器时，构造器中的参数自动从容器中获取
	 * 
	 * @param dog
	 * @return
	 */
	@Bean
	public Color autowired(Prop p) {
		return new Color();
	}
	
	@Bean
	public ColorAware colorAware() {
		return new ColorAware();
	}
	
	/**
	 * 根据不同的环境动态注入Bean，默认default
	 * 可以使用命令行参数指定环境：-Dspring.profiles.active=test
	 * @Profile可以用在方法上也可以用在类上，在类上时不符合Profile时所有Bean不注入
	 * 未标注Profile的Bean无论什么环境都会注入，前提是类上的Profile符合环境或者压根没有指定
	 * @return
	 */
	@Profile("dev")
	@Bean
	public DataSource dev() {
		return new DataSource("jdbc://dev");
	}
	
	@Profile("test")
	@Bean
	public DataSource test() {
		return new DataSource("jdbc://test");
	}
	
	@Bean
	public DataSource pred() {
		return new DataSource("jdbc://pred");
	}
	
	@Profile("prod")
	@Bean
	public DataSource prod() {
		return new DataSource("jdbc://prod");
	}
}
