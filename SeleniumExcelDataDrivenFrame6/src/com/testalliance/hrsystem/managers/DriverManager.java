package com.testalliance.hrsystem.managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager 
{
	WebDriver driver;
	EnvManager env;
	
	public DriverManager(String driverBrowser, String driverPath, 
			String browser)
	{
		env = new EnvManager();

		env.setDriverBrowser(driverBrowser);
		env.setDriverPath(driverPath);
		env.setBrowser(browser);
	}
	
	public WebDriver preTest()
	{	
		System.setProperty(env.getDriverBrowser(), env.getDriverPath());
		if(env.getBrowser().equals("chrome"))
			driver = new ChromeDriver();
		else if(env.getBrowser().equals("ie"))
			driver = new InternetExplorerDriver();
		else if(env.getBrowser().equals("firefox"))
			driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public void cleanUp()
	{
		driver.quit();
	}
}
