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
		driver.get("http://cslm-test.com/webapps/login/formlogin.html");
		driver.manage().window().maximize();
		
		WebElement usernameTextBox = driver.findElement(By.name("username"));
		WebElement pwdTextBox = driver.findElement(By.name("pwd"));
		
		//登录过程
		usernameTextBox.sendKeys("marco");
		pwdTextBox.sendKeys("123");
		pwdTextBox.submit(); //用submit()替换
	}
}