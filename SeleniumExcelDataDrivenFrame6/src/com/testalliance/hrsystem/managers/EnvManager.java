package com.testalliance.hrsystem.managers;

public class EnvManager 
{
	private String driverBrowser; //设置对应浏览器的driver
	private String driverPath; //设置driver路径
	private String browser; //设置浏览器
	
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getDriverBrowser() {
		return driverBrowser;
	}
	public void setDriverBrowser(String driverBrowser) {
		this.driverBrowser = driverBrowser;
	}
	public String getDriverPath() {
		return driverPath;
	}
	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}
}
