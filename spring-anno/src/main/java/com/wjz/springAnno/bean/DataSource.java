package com.wjz.springAnno.bean;

public class DataSource {
	
	private String url;
	
	public DataSource(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "DataSource [url=" + url + "]";
	}

	
}
