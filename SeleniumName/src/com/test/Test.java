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
		
		//用name定位
		WebElement confirmBtn = driver.findElement(By.name("confirm"));
		String attrValue = confirmBtn.getAttribute("value");
		System.out.println(attrValue);
		
		//用classname定位
		WebElement cancelBtn = driver.findElement(By.className("CANCEL"));
		System.out.println(cancelBtn.getAttribute("value"));
		
		//用tagname定位
		WebElement dropDownOption = driver.findElement(By.tagName("option"));
		System.out.println(dropDownOption.getAttribute("value"));
		
		driver.quit();
	}

}
