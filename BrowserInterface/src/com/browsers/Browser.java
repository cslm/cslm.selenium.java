package com.browsers;

//实现BrowserIF接口获取getActualResponseTime方法
abstract public class Browser implements BrowserIF 
{
	private String name; //浏览器名称
	private String manufacturer; //制作商
	private String expectedResponseTime; //期望响应时间
	
	// 成员变量赋值
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getExpectedResponseTime() {
		return expectedResponseTime;
	}
	public void setExpectedResponseTime(String expectedResponseTime) {
		this.expectedResponseTime = expectedResponseTime;
	}
}