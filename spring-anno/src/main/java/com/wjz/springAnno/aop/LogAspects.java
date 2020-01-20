package com.wjz.springAnno.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspects {
	
	@Pointcut("execution(public int com.wjz.springAnno.aop.Compute.*(..))")
	public void pointCut() {
		
	}

	@Before("pointCut()")
	public void before(JoinPoint point) {
		System.out.println("@Before{"+point.getSignature().getName()+"}args{"+Arrays.asList(point.getArgs())+"}");
	}
	
	@After("com.wjz.springAnno.aop.LogAspects.pointCut()")
	public void after(JoinPoint point) {
		System.out.println("@After{"+point.getSignature().getName()+"}");
	}
	
	@AfterReturning(value="pointCut()", returning="rel")
	public void returning(JoinPoint point, Object rel) {
		System.out.println("@AfterReturning{"+point.getSignature().getName()+"},return{"+rel+"}");
	}
	
	@AfterThrowing(value="pointCut()", throwing="e")
	public void throwing(JoinPoint point, Exception e) {
		System.out.println("@AfterThrowing{"+point.getSignature().getName()+"},throwing{"+e+"}");
	}
}
