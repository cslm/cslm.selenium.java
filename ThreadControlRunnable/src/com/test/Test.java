package com.test;

class A implements Runnable
{
	int i = 1;
	public void run()
	{
		while(i <= 100)
		{
			synchronized(this)
			{
				//加一个判断语句
				if(i > 100)
					break;
				else
				{
					System.out.println(Thread.currentThread().getName() 
										+ "正在执行第" + i + "个任务");
				
					try 
					{
						Thread.sleep(1000);
					} 
					catch (InterruptedException e) 
					{
						e.printStackTrace();
					}
					i++;
				}
			}
		}
	}
}
public class Test 
{
	public static void main(String[] args)
	{
		A a = new A();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(a);
		Thread t3 = new Thread(a);
		Thread t4 = new Thread(a);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}