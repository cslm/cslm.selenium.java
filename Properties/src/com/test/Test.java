package com.test;

class Person 
{
	private String name;
	private int age;
	private String hobby;
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setHobby(String hobby) 
	{
		this.hobby = hobby;
	}
	
	public String getHobby() 
	{
		return hobby;
	}
}

public class Test 
{
	public static void main(String[] args)
	{
		Person p = new Person();
		//赋值
		p.setName("张鹏");
		p.setAge(31);
		p.setHobby("踢足球");
		//取值
		System.out.println("姓名： " + p.getName());
		System.out.println("年龄： " + p.getAge());
		System.out.println("爱好：" + p.getHobby());
	}
}
