package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		
		WebElement link = driver.findElement(By.id("hyperlink")); //用id定位链接
		System.out.println(link.getText());
		
		//跳转到百度然后再尝试打印原先网页的link值
		driver.navigate().to("http://www.baidu.com");
		Thread.sleep(3000);
		System.out.println(link.getText());
		
		driver.quit();
	}
}