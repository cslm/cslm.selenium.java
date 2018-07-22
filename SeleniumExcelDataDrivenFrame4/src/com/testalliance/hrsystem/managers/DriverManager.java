package com.testalliance.hrsystem.managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager 
{
	WebDriver driver;
	String driverBrowser;
	String driverPath;
	String browser;
	
	public DriverManager(String driverBrowser, String driverPath, String browser)
	{
		this.driverBrowser = driverBrowser;
		this.driverPath = driverPath;
		this.browser = browser;
	}
	
	public WebDriver preTest()
	{	
		System.setProperty(driverBrowser, driverPath);
		if(browser.equals("chrome"))
			driver = new ChromeDriver();
		else if(browser.equals("ie"))
			driver = new InternetExplorerDriver();
		else if(browser.equals("firefox"))
			driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void cleanUp()
	{
		driver.quit();
	}
}
