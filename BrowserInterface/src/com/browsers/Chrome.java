package com.browsers;

public class Chrome extends Browser
{
	public float getActualResponseTime(int expectedResponseTime)
	{
		//实际时间不包括网络延时
		float actualResponseTime = (float)(expectedResponseTime * 0.5) - CONGESTION;
		return actualResponseTime;
	}
}
