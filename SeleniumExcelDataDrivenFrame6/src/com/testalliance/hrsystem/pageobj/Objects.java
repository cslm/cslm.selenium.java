package com.testalliance.hrsystem.pageobj;

import org.openqa.selenium.By;

public class Objects 
{
	//定位器判断
	public By getObject(String objName, String objVal)
	{
		By obj = null;
		if(objName.contains("_id"))
			obj = By.id(objVal);
		else if(objName.contains("_name"))
			obj = By.name(objVal);
		else if(objName.contains("_className"))
			obj = By.className(objVal);
		else if(objName.contains("_tagName"))
			obj = By.tagName(objVal);
		else if(objName.contains("_linkText"))
			obj = By.linkText(objVal);
		else if(objName.contains("_partialLinkText"))
			obj = By.partialLinkText(objVal);
		else if(objName.contains("_cssSelector"))
			obj = By.cssSelector(objVal);
		else if(objName.contains("_xpath"))
			obj = By.xpath(objVal);
		
		return obj;
	}
}
