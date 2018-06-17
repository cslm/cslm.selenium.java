package com.browsers;

public class Chrome extends Browser
{
	public float getActualResponseTime(int expectedResponseTime)
	{
		//Chrome响应最快，甚至比期望时间还快一倍
		float actualResponseTime = (float)(expectedResponseTime * 0.5); 
		
		return actualResponseTime;
	}
}
