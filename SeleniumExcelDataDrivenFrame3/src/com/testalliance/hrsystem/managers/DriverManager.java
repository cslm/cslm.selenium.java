package com.testalliance.hrsystem.managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager 
{
	WebDriver driver;
	
	public WebDriver preTest()
	{	
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		return driver;
	}
	
	public void cleanUp()
	{
		driver.quit();
	}
}
