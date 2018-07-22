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
	private By xpath_menuEmployee;
	private By xpath_lastLoginDate;
	WebDriver driver;
	Properties prop;
	
	public EmpPage(WebDriver driver)
	{
		this.driver = driver;
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
		xpath_menuEmployee = By.xpath(prop.getProperty("link_menu_employee"));
		driver.findElement(xpath_menuEmployee).click();
	}
	
	public boolean verifyLoginDate(String empCode) throws ParseException
	{
		//get today's date
		Date today = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		String today_str = df.format(today);
		
		Calendar c = Calendar.getInstance();

        //get yesterday's date
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();
        String yesterday_str = df.format(yesterday);
        
        //get tomorrow's date
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = c.getTime();
        String tomorrow_str = df.format(tomorrow);
        
        String tableLastLoginDate = prop.getProperty("table_lastLoginDate");
        tableLastLoginDate = tableLastLoginDate.replace("||EMPCODE||", empCode);
        xpath_lastLoginDate = By.xpath(tableLastLoginDate);
		String loginDate = driver.findElement(xpath_lastLoginDate).getText();
		
		if(loginDate.equals(today_str) || loginDate.equals(yesterday_str) 
				|| loginDate.equals(tomorrow_str))
		{
			return true;
		}
		return false;
	}
}
