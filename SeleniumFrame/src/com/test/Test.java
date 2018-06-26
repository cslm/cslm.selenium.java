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
		driver.get("http://cslm-test.com/webapps/frames/frames.html");
		driver.manage().window().maximize();
		
		/*************用索引定位frame***************************/
		driver.switchTo().frame(1);
		driver.findElement(By.name("user")).sendKeys("marco");
		//回到上一层级
		driver.switchTo().parentFrame();
		//再次转到0号frame
		driver.switchTo().frame(0);
		//点击确定按钮
		driver.findElement(By.id("confirmId")).click();
		
		/*************用定位器定位frame***************************/
		//driver.switchTo().frame("f0002");
		//driver.findElement(By.name("user")).sendKeys("marco");
		
		
		/*************用frame本身定位frame***************************/
		//WebElement wFrame = driver.findElement(By.id("f0002"));
		//driver.switchTo().frame(wFrame);
		//driver.findElement(By.name("user")).sendKeys("marco");
	}
}