package com.wjz.springAnno.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	/**
	 * importingClassMetadata 当前标注@Import类的所有注解
	 */
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {"com.wjz.springAnno.bean.Blue", "com.wjz.springAnno.bean.Yellow"};
	}

}
