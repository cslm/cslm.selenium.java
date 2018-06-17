package com.browsers;

public class IE extends Browser
{
	public float getActualResponseTime(int expectedResponseTime)
	{
		//IE响应最慢，实际时间比期望还要慢一倍
		float actualResponseTime = (float)(expectedResponseTime * 2); 
		
		return actualResponseTime;
	}
}
