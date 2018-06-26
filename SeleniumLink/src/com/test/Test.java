package com.test;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com");
		String currentHandle = driver.getWindowHandle();
		//System.out.println(currentHandle);
		driver.findElement(By.linkText("网页控件WebElements")).click();
		
		Set<String> allHandles = driver.getWindowHandles();
		
		for(String handle : allHandles)
		{
			if(!handle.equals(currentHandle))
			{
				driver.switchTo().window(handle);
				System.out.println(driver.getTitle());
			}
		}
		
		//点击图像
		driver.findElement(By.xpath("//img[contains(@src, 'img/big-logo.png')]")).click();
		
		driver.quit();
	}

}

