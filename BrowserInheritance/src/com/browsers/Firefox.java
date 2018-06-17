package com.browsers;

public class Firefox extends Browser
{
	public float getActualResponseTime(int expectedResponseTime)
	{
		//Firefox相应适中，正好卡在期望时间上
		float actualResponseTime = (float)(expectedResponseTime * 1); 
		
		return actualResponseTime;
	}
}
