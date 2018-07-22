package com.testalliance.hrsystem.pageobj;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmpPage 
{
	WebDriver driver;
	Properties prop;
	Objects object;
	
	public EmpPage(WebDriver driver)
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
		    		+ "//empPage.properties");
		    FileInputStream fis = new FileInputStream(f);
		    prop = new Properties();
			prop.load(fis);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void navToEmployee()
	{
		String objName = "link_menu_employee_xpath";
		String objLinkMenuEmp = prop.getProperty("link_menu_employee_xpath");
		By obj = object.getObject(objName, objLinkMenuEmp);
		driver.findElement(obj).click();
	}
	
	public boolean verifyLoginDate(String empCode) throws ParseException
	{
		//get today's date
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String today_str = df.format(today);
		//System.out.println(today_str);
		Calendar c = Calendar.getInstance();
        c.setTime(today); 
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();
        String yesterday_str = df.format(yesterday);
        //System.out.println(yesterday_str);
        
		String objName = "table_lastLoginDate_xpath";
		String objTableLastLoginDate = prop.getProperty(objName);
		objTableLastLoginDate = objTableLastLoginDate.replace("||EMPCODE||", empCode);
		By obj = object.getObject(objName, objTableLastLoginDate);
		String loginDate = driver.findElement(obj).getText();
		
		if(loginDate.equals(today_str) || loginDate.equals(yesterday_str))
		{
			return true;
		}
		return false;
	}
}
