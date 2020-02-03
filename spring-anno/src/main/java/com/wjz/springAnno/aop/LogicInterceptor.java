package com.wjz.springAnno.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.util.ClassUtils;

public class LogicInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String methodName = null;
		List<Parameter> args = null;
		try {
			Class<?> targetClass = (invocation.getThis() != null ? AopUtils.getTargetClass(invocation.getThis())
					: null);
			Method specificMethod = ClassUtils.getMostSpecificMethod(invocation.getMethod(), targetClass);
			final Method method = BridgeMethodResolver.findBridgedMethod(specificMethod);
			methodName = method.getName();
			args = Arrays.asList(method.getParameters());
			System.out.println("准备执行方法[" + methodName + "]，参数[" + args + "]");
			Object result = invocation.proceed();
			System.out.println("执行方法[" + methodName + "]，参数[" + args + "]完毕");
			return result;
		} catch (Exception e) {
			System.out.println("执行方法[" + methodName + "]，参数[" + args + "]时异常"+ e);
			throw new RuntimeException(e);
		}
	}
}
