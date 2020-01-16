package com.wjz.springAnno.bean;

import org.springframework.beans.factory.annotation.Value;

public class Prop {

	@Value("iss002")
	private String name;
	@Value("#{20-2}")
	private Integer age;
	@Value("${prop.lastName}")
	private String lastName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Prop [name=" + name + ", age=" + age + ", lastName=" + lastName + "]";
	}

}
