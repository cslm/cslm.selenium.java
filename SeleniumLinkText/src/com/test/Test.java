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
		
		//用link定位
		WebElement link = driver.findElement(By.linkText("点击这里跳转"));
		System.out.println(link.getText());
		
		//用partialLinkText定位
		link = driver.findElement(By.partialLinkText("点击这"));
		System.out.println(link.getText());
		
		driver.quit();
	}

}
