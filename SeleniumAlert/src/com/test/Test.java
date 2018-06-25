package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		Alert alert = null;
		
		try 
		{
			//点击网页上的确定按钮，并把焦点转移到提示框上
			driver.findElement(By.id("confirmId")).click();
			Thread.sleep(5000);
			alert = driver.switchTo().alert();
			alert.accept();
			
			//点击CANCEL按钮后点击OK
			driver.findElement(By.className("CANCEL")).click();
			Thread.sleep(5000);
			alert = driver.switchTo().alert();
			alert.accept();
			
			//点击CANCEL按钮后点击cancel
			driver.findElement(By.className("CANCEL")).click();
			Thread.sleep(5000);
			alert = driver.switchTo().alert();
			alert.dismiss();
			
			//提示框中输入文字
			driver.findElement(By.name("exit")).click();
			Thread.sleep(5000);
			alert = driver.switchTo().alert();
			alert.sendKeys("你猜");
			alert.accept();
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
