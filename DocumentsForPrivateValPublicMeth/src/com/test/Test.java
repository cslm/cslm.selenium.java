package com.test;

import com.document.Document;

public class Test 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Document p1 = new Document();
		String countryGoal = p1.countryPlan();
		//因为调用countryPlan返回了countryGoal，所以可以打印结果
		System.out.println("国家目标: " + countryGoal);  
	}
}
