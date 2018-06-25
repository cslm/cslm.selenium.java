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
		
		//用css选择器定位文本框
		WebElement textbox = driver.findElement(By.cssSelector("*[id*='form1']>p:nth-of-type(2)>input"));
		//用css选择器定位链接
		WebElement link = driver.findElement(By.cssSelector("*[id*='form1'] p:nth-of-type(6)")); 
		//用css选择器定位普通按钮
		WebElement button = driver.findElement(By.cssSelector("form[id*='form1']>p:nth-of-type(5) "
																+ "input[id*='confirmId']+input")); 
		//用css选择器定位单选按钮
		WebElement radioButton = driver.findElement(By.cssSelector("#male")); 
		//用css选择器定位复选框
		WebElement checkbox = driver.findElement(By.cssSelector("*[id='form1'] label>input[name='weixin']")); 
		//用css选择器定位文本
		WebElement text = driver.findElement(By.cssSelector("*[id='form1'] p:nth-of-type(6)")); 
		//用css选择器定位下拉列表
		WebElement dropDown1 = driver.findElement(By.cssSelector(".STYLE1>option:nth-of-type(2)"));
		//用css选择器定位下拉列表
		WebElement dropDown2 = driver.findElement(By.cssSelector("*[id='form1'] select[name='hobby'] "
																	+ "option:nth-of-type(2)"));
		
		System.out.println(textbox.isDisplayed());
		System.out.println(link.getText());
		System.out.println(button.getAttribute("value"));
		System.out.println(radioButton.getAttribute("value"));
		System.out.println(checkbox.getAttribute("value"));
		System.out.println(text.getAttribute("value"));
		System.out.println(dropDown1.getAttribute("value"));
		System.out.println(dropDown2.getAttribute("value"));
		
		driver.quit();
	}
}
