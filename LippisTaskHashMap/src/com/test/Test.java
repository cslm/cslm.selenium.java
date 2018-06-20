package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Test 
{
	public static void main(String[] args) 
	{
		HashMap hm = new HashMap();
		
		for(int i = 0; i < 4; i++)
		{
			Staff s = new Staff();
			switch(i)
			{
				case 0: 
					s.setShenfen("足协");
					s.setTask("刺探敌情");
					s.setComplete("60%");
					hm.put("head",s);
					break;
				case 1:
					s.setShenfen("教练组");
					s.setTask("安排训练课");
					s.setComplete("80%");
					hm.put("coach",s);
					break;
				case 2:
					s.setShenfen("球员");
					s.setTask("认真踢球");
					s.setComplete("90%");
					hm.put("player",s);
					break;
				case 3:
					s.setShenfen("后勤");
					s.setTask("负责饮食");
					s.setComplete("100%");
					hm.put("service",s);
					break;	
			}
		}
		System.out.println("人员|任务|完成");
		System.out.println("==========");
		
		//取得键集
		Iterator i = hm.keySet().iterator();
		String key;
		String value;
		
		//用遍历方式打印hashmap的值。遍历键集，如果有下一个键就指向
		//下一个键，然后取值
		while(i.hasNext())
		{
			key = i.next().toString();
			Staff s = (Staff) hm.get(key);
			System.out.println(s.getShenfen() + "|" + s.getTask() 
										+ "|" + s.getComplete());
		}
		
	}
}
