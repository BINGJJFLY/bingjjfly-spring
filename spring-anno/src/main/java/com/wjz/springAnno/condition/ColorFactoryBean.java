package com.wjz.springAnno.condition;

import org.springframework.beans.factory.FactoryBean;

import com.wjz.springAnno.bean.Color;

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
