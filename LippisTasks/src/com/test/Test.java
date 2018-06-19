package com.test;
import java.util.ArrayList;

public class Test 
{
	public static void main(String[] args) 
	{
		ArrayList al = new ArrayList();
		
		for(int i = 0; i < 4; i++)
		{
			Staff s = new Staff();
			switch(i)
			{
				case 0: 
					s.setShenfen("足协");
					s.setTask("刺探敌情");
					s.setComplete("60%");
					al.add(s);
					break;
				case 1:
					s.setShenfen("教练组");
					s.setTask("安排训练课");
					s.setComplete("80%");
					al.add(s);
					break;
				case 2:
					s.setShenfen("球员");
					s.setTask("认真踢球");
					s.setComplete("90%");
					al.add(s);
					break;
				case 3:
					s.setShenfen("后勤");
					s.setTask("负责饮食");
					s.setComplete("100%");
					al.add(s);
					break;	
			}
		}
		System.out.println("人员|任务|完成");
		System.out.println("==========");
		
		String shenfen = null;
		String task = null;
		String complete = null;
		
		// 循环打印时把Staff对象按顺序从ArrayList中取出，因为默认取出的东西
		//是Object类型，所以要强制转换
		for(int i = 0; i < al.size(); i++)
		{
			Staff s = (Staff) al.get(i);
			shenfen = s.getShenfen();
			task = s.getTask();
			complete = s.getComplete();
			System.out.println(shenfen + "|" + task + "|" + complete);
		}
		
	}

}
