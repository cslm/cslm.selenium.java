package com.test;

class TypeBag<K,V>
{
	private int key;
	private String value;
	
	public TypeBag(int key, String value)
	{
		this.key = key;
		this.value = value;
	}
	
	public int getKey()
	{
		return key;
	}
	
	public String getValue()
	{
		return value;
	}
}

public class Test 
{
	public static void main(String[] args)
	{
		TypeBag<Integer, String> t1 = new TypeBag<Integer, String>(1, "类型1");
		TypeBag<Integer, String> t2 = new TypeBag<Integer, String>(2, "类型2");
		System.out.println(t1.getKey() + ", " + t1.getValue());
		System.out.println(t2.getKey() + ", " + t2.getValue());
	}
}