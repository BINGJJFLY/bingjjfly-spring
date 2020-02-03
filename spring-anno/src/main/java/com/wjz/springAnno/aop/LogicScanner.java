package com.wjz.springAnno.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.PriorityOrdered;

public class LogicScanner extends AbstractAutoProxyCreator
		implements InitializingBean, ApplicationContextAware, PriorityOrdered {

	private static final long serialVersionUID = 1L;

	private ApplicationContext applicationContext;
	private MethodInterceptor interceptor;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		this.setBeanFactory(applicationContext);
	}

	@Override
	protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName,
			TargetSource customTargetSource) throws BeansException {
		return new Object[] { interceptor };
	}

	@Override
	protected Object wrapIfNecessary(Object bean, String beanName, Object cacheKey) {
		try {
			Class<?> serviceInterface = SpringProxyUtils.findTargetClass(bean);
			Class<?>[] interfacesIfJdk = SpringProxyUtils.findInterfaces(bean);
			if (!existsAnnotation(new Class[] { serviceInterface }) && !existsAnnotation(interfacesIfJdk)) {
				return bean;
			}
			if (interceptor == null) {
				interceptor = new LogicInterceptor();
			}
			System.out.println("Bean[" + bean.getClass().getName() + "] with name [" + beanName + "] would use interceptor ["
					+ interceptor.getClass().getName() + "]");
			if (!AopUtils.isAopProxy(bean)) {
				bean = super.wrapIfNecessary(bean, beanName, cacheKey);
			} else {
				AdvisedSupport advised = SpringProxyUtils.getAdvisedSupport(bean);
				Advisor[] advisor = buildAdvisors(beanName, getAdvicesAndAdvisorsForBean(null, null, null));
				for (Advisor avr : advisor) {
					advised.addAdvisor(0, avr);
				}
			}
			return bean;
		} catch (Exception e) {
			System.out.println("Bean[" + bean.getClass().getName() + "] with name [" + beanName + "] 创建代理对象时异常");
			throw new RuntimeException(e);
		}
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (applicationContext instanceof ConfigurableApplicationContext) {
			((ConfigurableApplicationContext) applicationContext).registerShutdownHook();
		}
	}

	@Override
	public int getOrder() {
		return HIGHEST_PRECEDENCE + 100;
	}

	private boolean existsAnnotation(Class<?>[] classes) {
		if (classes != null && classes.length > 0) {
			for (Class<?> clazz : classes) {
				if (clazz == null) {
					continue;
				}
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					Logic trxAnno = method.getAnnotation(Logic.class);
					if (trxAnno != null) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
