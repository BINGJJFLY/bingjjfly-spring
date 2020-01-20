package com.wjz.springAnno.aop;

public class Compute {
	
	public int div(int i, int j) {
		System.out.println("Compute#div");
		return i / j;
	}

}
