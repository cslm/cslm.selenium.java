package com.testalliance.hrsystem.pageobj;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page 
{
	Properties prop;
	WebDriver driver;
	
	public Page(WebDriver driver)
	{
		this.driver = driver;
		prop = new Properties();
	}
	
	public void getPageObjects(String filePath)
	{
		File f = null;
		FileInputStream fis = null;
		try 
		{
			f = new File(filePath);
			fis = new FileInputStream(f);
			
			prop.load(fis);
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	//定位器判断
	public By getObject(String locator, String objString)
	{
		By obj = null;
		if(locator.equals("id"))
			obj = By.id(prop.getProperty(objString));
		else if(locator.equals("name"))
			obj = By.name(prop.getProperty(objString));
		else if(locator.equals("className"))
			obj = By.className(prop.getProperty(objString));
		else if(locator.equals("tagName"))
			obj = By.tagName(prop.getProperty(objString));
		else if(locator.equals("linkText"))
			obj = By.linkText(prop.getProperty(objString));
		else if(locator.equals("partialLinkText"))
			obj = By.partialLinkText(prop.getProperty(objString));
		else if(locator.equals("cssSelector"))
			obj = By.cssSelector(prop.getProperty(objString));
		else if(locator.equals("xpath"))
			obj = By.xpath(prop.getProperty(objString));
		
		return obj;
	}
	
	//操作方法
	public void openBrowser(String url)
	{
		driver.get(url);
	}
	
	public void maximizeBrowserWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void enter(String locator, String objString, String value) 
	{
		By obj = this.getObject(locator, objString);
		driver.findElement(obj).sendKeys(value);
	}
	
	public void click(String locator, String objString)
	{
		By obj = this.getObject(locator, objString);
		driver.findElement(obj).click();
	}
	
	public Alert getAlert()
	{
		return driver.switchTo().alert();
	}
	
	public boolean verifyElementText(String locator, String objString, String value)
	{
		boolean b = false;
		int count = driver.findElements(this.getObject(locator, objString)).size();
		if(count > 0)
		{
			By obj = this.getObject(locator, objString);
			WebElement element = driver.findElement(obj);
			if(element.getText().equals(value))
				b = true;
		}
		return b;
	}
	
	public boolean verifyElementDisplay(String locator, String objString)
	{
		boolean b = false;
		int count = driver.findElements(this.getObject(locator, objString)).size();
		if(count > 0)
		{
			By obj = this.getObject(locator, objString);
			WebElement element = driver.findElement(obj);
			if(element.isDisplayed())
				b = true;
		}
		return b;
	}
	
	public boolean verifyAlertDisplay()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean verifyAlert(String value)
	{
		boolean b = false;
		if(this.verifyAlertDisplay())
		{
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			if(alertMsg.equals(value))
				b = true;
			alert.accept();
		}
		return b;
	}
}
