package com.test;

public class Test 
{
	public static void main(String[] args)
	{
		Wanghong[] w = new Wanghong[3];
		
		for(int i = 0; i < w.length; i++)
		{
			w[i] = new Wanghong();
			if(i == 0)
			{
				w[i].setName("王思聪");
				w[i].setAge(30);
				w[i].setHobby("打游戏");
			}
			else if(i == 1)
			{
				w[i].setName("咪蒙");
				w[i].setAge(18);
				w[i].setHobby("吃小龙虾");
			}
			else
			{
				w[i].setName("杨幂");
				w[i].setAge(18);
				w[i].setHobby("啃鸡腿");
			}
		}
		System.out.println("网红|年龄|爱好");
		System.out.println("==========");
		for(int i = 0; i < w.length; i++)
		{
			System.out.println(w[i].getName() + "|" + w[i].getAge() + "|" 
											+ w[i].getHobby());
		}
	}
}