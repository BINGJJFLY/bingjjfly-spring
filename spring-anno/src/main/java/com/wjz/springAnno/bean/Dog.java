package com.wjz.springAnno.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog {
	
	/**
	 * Bean创建完成且属性赋值完成后执行初始化方法
	 */
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct");
	}
	
	/**
	 * 容器销毁Bean之前执行
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("@PreDestroy");
	}

}
