package com.testalliance.hrsystem.pageobj;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{	
	WebDriver driver;
	Properties prop;
	Objects object;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		prop = new Properties();
		object = new Objects();
	}
	
	public void getPageObjects()
	{
		try
		{
			//读取page object
		    File f = new File(System.getProperty("user.dir") + 
		    		"//src//com//testalliance//hrsystem//objrepository"
		    		+ "//loginPage.properties");
		    FileInputStream fis = new FileInputStream(f);
		    prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void openBrowser()
	{
		String objName = "url";
		String objUrl = prop.getProperty(objName);
		driver.get(objUrl);
	}
	
	public void maximizeBrowserWindow()
	{
		driver.manage().window().maximize();
	}
	
	public void enterEmpCode(String empcode) 
	{
		if(!empcode.equals("null"))
		{
			String objName = "textbox_usercode_id";
			String objEmpCode = prop.getProperty(objName);
			By obj = object.getObject(objName, objEmpCode);
			driver.findElement(obj).sendKeys(empcode);
		}
	}
	
	public void enterPassword(String password)
	{
		if(!password.equals("null"))
		{
			String objName = "textbox_password_id";
			String objPassword = prop.getProperty(objName);
			By obj = object.getObject(objName, objPassword);
			driver.findElement(obj).sendKeys(password);
		}
	}
	
	public void clickLogin()
	{
		String objName = "btn_login_cssSelector";
		String objLogin = prop.getProperty(objName);
		By obj = object.getObject(objName, objLogin);
		driver.findElement(obj).click();
	}
	
	public void login(String empcode, String password)
	{
		this.enterEmpCode(empcode);
		this.enterPassword(password);
		this.clickLogin();
	}
	
	public void clickLogout()
	{
		String objName = "btn_logout_linkText";
		String objLogout = prop.getProperty(objName);
		By obj = object.getObject(objName, objLogout);
		driver.findElement(obj).click();
	}
	
	public boolean verifyMenuHomeText()
	{
		String objName = "link_menu_home_xpath";
		String objMenuHome = prop.getProperty(objName);
		By obj = object.getObject(objName, objMenuHome);
		int numOfMenuHome = driver.findElements(obj).size();
		if(numOfMenuHome > 0)
		{
			WebElement menu_home = driver.findElement(obj);
			if(menu_home.getText().equals("Home"))
				return true;
		}
		return false;
	}
	
	public boolean verifyLoginBtnExist()
	{
		String objName = "btn_login_cssSelector";
		String objLogin = prop.getProperty(objName);
		By obj = object.getObject(objName, objLogin);
		int numOfLoginBtn = driver.findElements(obj).size();
		if(numOfLoginBtn > 0)
		{
			WebElement btn_login = driver.findElement(obj);
			if(btn_login.isDisplayed())
				return true;
		}
		return false;
	}
	
	public boolean verifyErrMsgDisplay()
	{
		String objName = "textarea_errmsg_xpath";
		String objErrMsg = prop.getProperty(objName);
		By obj = object.getObject(objName, objErrMsg);
		int count = driver.findElements(obj).size();
		if(count > 0)
		{
			WebElement textarea_errmsg = driver.findElement(obj);
			if(textarea_errmsg.isDisplayed())
				return true;
		}
		return false;
	}
	
	public boolean verifyErrAlertDisplay()
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
	
	public boolean verifyErrAlertMsg(String value)
	{
		boolean b = false;
		if(this.verifyErrAlertDisplay())
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

