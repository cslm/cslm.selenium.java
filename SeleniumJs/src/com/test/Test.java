package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test 
{
	public static void main(String[] args)
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
			WebDriver driver = new ChromeDriver();		
			driver.get("http://cslm-test.com/hrsystem/index.php");
			driver.manage().window().maximize();
			
			//输入用户名密码
	        driver.findElement(By.name("usercode")).sendKeys("1001");					
	        driver.findElement(By.name("password")).sendKeys("123");
	        
	        //定位登录按钮
	        WebElement loginBtn =driver.findElement(By.cssSelector(".btn-primary"));
	        
	        //用javascript点击按钮
	        JavascriptExecutor js = (JavascriptExecutor)driver;	
	        js.executeScript("arguments[0].click();", loginBtn);   
	        
	        //用javascript跳转网页
	        js.executeScript("window.location = 'http://news.163.com/'");
	        Thread.sleep(5000);
	        
	        //用javascript控制滚动栏，滚10次
	        for(int i = 0; i < 10; i++)
	        {
	        	String jsQuery = "window.scrollTo(0,document.body.scrollHeight-" + String.valueOf(1) + ")";
	        	js.executeScript(jsQuery);
	        	Thread.sleep(2000);
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
