package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		/********************第一种取行列数的方法****************************/
		// TODO Auto-generated method stub
		/*System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		
		//求行数
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		//求列数
		List<WebElement> columns = driver.findElements(By.xpath("//tr[1]/td"));
		System.out.println(columns.size());*/
		
		/********************第二种取行列数的方法****************************/
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.get("http://cslm-test.com/webapps/elements/webelements.html");
		driver.manage().window().maximize();
		
		//htmlTable调用findElements()
		WebElement htmlTable = driver.findElement(By.id("automation"));
		List<WebElement> rows2 = htmlTable.findElements(By.tagName("tr"));
		System.out.println("行数: " + rows2.size());
		List<WebElement> columns2 = htmlTable.findElements(By.xpath("//tr[1]/td"));
		System.out.println("列数: " + columns2.size());
		
		//取出每个格里的值
		/*String java = driver.findElement(By.xpath("//tr[1]/td[1]")).getText();
		System.out.println(java);
		String selenium = driver.findElement(By.xpath("//tr[1]/td[2]")).getText();
		System.out.println(selenium);
		String junit = driver.findElement(By.xpath("//tr[1]/td[3]")).getText();
		System.out.println(junit);
		String testng = driver.findElement(By.xpath("//tr[2]/td[1]")).getText();
		System.out.println(testng);
		String appium = driver.findElement(By.xpath("//tr[2]/td[2]")).getText();
		System.out.println(appium);
		String eclipse = driver.findElement(By.xpath("//tr[2]/td[3]")).getText();
		System.out.println(eclipse);
		String xpath = driver.findElement(By.xpath("//tr[3]/td[1]")).getText();
		System.out.println(xpath);
		String sql = driver.findElement(By.xpath("//tr[3]/td[2]")).getText();
		System.out.println(sql);
		String excel = driver.findElement(By.xpath("//tr[3]/td[3]")).getText();
		System.out.println(excel);*/
		
		//用循环取出每个格里的值
		for(int i = 1; i <= rows2.size(); i++)
		{
			for(int j = 1; j <= columns2.size(); j++)
			{
				System.out.println(driver.findElement(By.xpath("//tr[" + i + "]/td[" + j + "]")).getText());
			}
		}
		driver.quit();
	}
}
