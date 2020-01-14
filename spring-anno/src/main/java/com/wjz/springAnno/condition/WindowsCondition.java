package com.wjz.springAnno.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		if (System.getProperty("os.name").contains("Windows")) {
			return true;
		}
		return false;
	}

}
