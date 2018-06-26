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
		driver.get("http://cslm-test.com/webapps/assertions/assertions.html");
		driver.manage().window().maximize();
		
		//注册案例:1)密码错误信息在不在；2)实际错误信息和期望值相等不相等
		driver.findElement(By.id("user")).sendKeys("marco");
		driver.findElement(By.id("submit")).click();
		
		//验证"在不在"
		int numOfPwdAlert = driver.findElements(By.id("pwd_alert")).size();
		
		if(numOfPwdAlert > 0)
		{
			WebElement pwdAlert = driver.findElement(By.id("pwd_alert"));
			
			System.out.println("密码错误提示是否显示: " + pwdAlert.isDisplayed());
			if(!pwdAlert.isDisplayed())
			{
				System.out.println("密码错误提示未显示, Test Fail");
			}
			else
			{
				//验证"是不是"
				String str_pwdAlert = pwdAlert.getText();
				if(str_pwdAlert.equals("请输入密码!"))
					System.out.println("密码错误信息显示正确, Test Pass");
				else
					System.out.println("密码错误信息显示错误, Test Fail");
			}
		}
		else
			System.out.println("密码错误提示未显示, Test Fail");
			
		//随机数案例:出现的数值大于等于0并且小于100
		driver.findElement(By.id("button")).click();
		try 
		{
			Thread.sleep(5);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		String randomVal = driver.findElement(By.id("math")).getAttribute("value");
		int int_randomVal = Integer.parseInt(randomVal);
		if(int_randomVal >= 0 && int_randomVal < 100)
			System.out.println("取值合理, Test Pass");
		else
			System.out.println("取值不合理, Test Fail");
		
		//复选框案例:判断复选框个数是不是和名称个数相等
		int checkbox = driver.findElements(By.xpath("//div/label/input")).size();
		int label = driver.findElements(By.xpath("//div/label")).size();
		
		if(checkbox == label)
			System.out.println("复选框和标签个数相等，Test Pass");
		else
			System.out.println("复选框和标签个数不相等，Test Fail");
		
	}
}
