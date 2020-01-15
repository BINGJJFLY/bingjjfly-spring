package com.wjz.springAnno.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cat implements InitializingBean, DisposableBean {

	public void destroy() throws Exception {
		System.out.println("destroy");
	}

	/**
	 * 创建好Bean且属性设置好值后调用
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

}
