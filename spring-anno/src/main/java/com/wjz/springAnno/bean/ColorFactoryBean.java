package com.wjz.springAnno.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

	/**
	 * 返回对象会加入到容器中
	 */
	public Color getObject() throws Exception {
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}

	public boolean isSingleton() {
		return true;
	}

}
