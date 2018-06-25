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
		
		//用xpath定位文本框
		WebElement textbox = driver.findElement(By.xpath("//*[@id='form1']/p[2]/input"));
		//用xpath定位链接
		WebElement link = driver.findElement(By.xpath("//*[@id='form1']//p[6]")); 
		//用xpath定位普通按钮
		WebElement button = driver.findElement(By.xpath("//form[@id='form1']/p[5]//input[@id='confirmId']"
														+ "/following-sibling::input[1]")); 
		//用xpath定位单选按钮
		WebElement radioButton = driver.findElement(By.xpath("//label/input[@id='male']")); 
		//用xpath定位复选框
		WebElement checkbox = driver.findElement(By.xpath("//*[@id='form1']//label/input[@name='weixin']")); 
		//用xpath定位文本
		WebElement text = driver.findElement(By.xpath("//*[@id='form1']//p[6]")); 
		//用xpath定位下拉列表
		WebElement dropDown1 = driver.findElement(By.xpath("//*[@id='form1']//label/select"
													+ "/option[contains(text(),'三星')]"));
		//用xpath定位下拉列表
		WebElement dropDown2 = driver.findElement(By.xpath("//*[@id='form1']//select[@name='hobby']"
													+ "/descendant::option[2]"));
		
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
