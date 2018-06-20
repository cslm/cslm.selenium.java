package com.test;

import java.util.HashMap;
import java.util.Iterator;

public class Test 
{
	public static void main(String[] args)
	{
		HashMap hm = new HashMap();
		hm.put("name", "iphone X");
		hm.put("size", 6.6f);
		hm.put("price", 100);
		
		//取得键集
		Iterator i = hm.keySet().iterator();
		String key;
		String value;
		
		//遍历键集，如果有下一个键就指向下一个键
		while(i.hasNext())
		{
			key = i.next().toString();
			System.out.println(hm.get(key));
		}
	}
}
