package com.wjz.springAnno.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听事件步骤：
 * 	1）、写一个监听器监听某个事件（ApplicationEvent及其子类）
 * 	2）、将监听器加入到容器中
 * 	3）、只要容器发布相关事件就可以监听到
 * 			ContextRefreshedEvent：容器刷新完成发布事件
 * 			ContextClosedEvent：容器关闭发布事件
 * 	4）、发布自定义事件
 * 		1. 创建自定义事件，继承自ApplicationEvent
 * 		2. 发布事件，ApplicationContext.publishEvent方法
 * @author iss002
 *
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {

	/**
	 * 当容器发布此类型事件时触发
	 */
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("收到事件："+event);
	}

}
