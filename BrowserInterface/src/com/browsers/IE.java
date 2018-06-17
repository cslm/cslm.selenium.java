package com.browsers;

public class IE extends Browser
{
	public float getActualResponseTime(int expectedResponseTime)
	{
		//实际时间不包括网络延时
		float actualResponseTime = (float)(expectedResponseTime * 2) - CONGESTION; 
		return actualResponseTime;
	}
}
