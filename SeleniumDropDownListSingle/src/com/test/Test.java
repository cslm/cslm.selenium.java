package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test 
{
	public static void main(String[] args)
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
			WebDriver driver = new ChromeDriver();		
			driver.get("http://cslm-test.com/webapps/elements/webelements.html");
			driver.manage().window().maximize();
			
			WebElement mobileDropDownList = driver.findElement(By.name("mobile"));
			Select mobileOperations = new Select(mobileDropDownList);

			mobileOperations.selectByVisibleText("苹果");
			Thread.sleep(5000);
			//返回"苹果"
			System.out.println(mobileOperations.getFirstSelectedOption().getText()); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}