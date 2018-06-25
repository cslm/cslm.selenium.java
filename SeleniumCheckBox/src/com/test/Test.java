package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		try
		{
			WebElement wbCheckbox = driver.findElement(By.name("weibo"));
			wbCheckbox.click();
			WebElement wxCheckbox = driver.findElement(By.name("weixin"));
			wxCheckbox.click();
			WebElement rrCheckbox = driver.findElement(By.name("renren"));
			rrCheckbox.click();
			WebElement otherCheckbox = driver.findElement(By.name("others"));
			otherCheckbox.click();
			
			Thread.sleep(5000);
			wbCheckbox.click();
			rrCheckbox.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
