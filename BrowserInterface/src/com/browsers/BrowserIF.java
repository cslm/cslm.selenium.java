package com.browsers;

public interface BrowserIF 
{
	int CONGESTION = 1; //网络延时1秒
	public float getActualResponseTime(int expected);
}
