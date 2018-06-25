package com.test;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/captcha/captcha.html");
		driver.manage().window().maximize();
		
		//用户从终端输入
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入验证码:");
		String captcha = scan.nextLine();
		scan.close();
		
		//程序端获取用户终端输入的值
		driver.findElement(By.id("inputCode")).sendKeys(captcha);
		
		//点击按钮提交
		driver.findElement(By.id("Button1")).click();
	}
}