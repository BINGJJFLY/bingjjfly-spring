package com.wjz.springAnno.bean;

public class Car {
	
	public Car() {
		System.out.println("构造器");
	}

	public void init() {
		System.out.println("初始化");
	}
	
	public void destroy() {
		System.out.println("销毁");
	}
}
