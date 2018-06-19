package com.test;

import java.util.ArrayList;

public class Test 
{
	public static void main(String[] args)
	{
		ArrayList al = new ArrayList();
		String name = "iphone X";
		float size = 6.6f;
		int price = 100;
		
		al.add(name);
		al.add(size);
		al.add(price);
		
		// size()方法返回的是整个ArrayList的长度
		for(int i = 0; i < al.size(); i++)
		{
			System.out.println(al.get(i));
		}
	}
}