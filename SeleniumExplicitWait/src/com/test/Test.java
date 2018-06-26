package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		//隐式等待
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("http://cslm-test.com/hrsystem/index.php");
		driver.manage().window().maximize();
		
		//登录
        driver.findElement(By.name("usercode")).sendKeys("1001");					
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.cssSelector(".btn-primary")).click();
        
        //点击Employee菜单，但由于Employee菜单出来得比较慢，所以我设置一个显式等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Employee")));
        //出现后再点击
        driver.findElement(By.linkText("Employee")).click();
        
        //点击Timesheet菜单
        driver.findElement(By.linkText("Timesheet")).click();
        
        //退出
        driver.findElement(By.linkText("Log Off")).click();  
        driver.quit();
	}
}
