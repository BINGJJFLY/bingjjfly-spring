package com.wjz.springAnno.aop;

public class Logging {

	@Logic
	public void log(String msg) {
		System.out.println(msg);
	}
}
