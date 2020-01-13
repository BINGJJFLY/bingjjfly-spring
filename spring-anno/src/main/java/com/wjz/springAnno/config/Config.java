package com.wjz.springAnno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.wjz.springAnno.bean.Person;

@Configuration
@ComponentScan(value = "com.wjz", excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, classes = { Controller.class }) }, includeFilters = {
				@Filter(type = FilterType.ANNOTATION, classes = { Service.class }) }, useDefaultFilters = false)
public class Config {

	@Bean
	public Person person() {
		Person p = new Person();
		p.setAge(18);
		p.setName("iss002");
		return p;
	}

}
