class Test
{
	public static void main(String[] args)
	{
		// 创建网红类的对象
		Wanghong wsc = new Wanghong();
		wsc.name = "王思聪";
		wsc.age = 30;
		wsc.hobby = "打游戏";
		System.out.println(wsc.name);
		int num_guai = wsc.countGuai(20, 5);
		System.out.println(num_guai += 10);
		
		// 创建演员类的对象
		Actor lyf = new Actor();
		lyf.name = "刘亦菲";
		lyf.height = 1.65f;
		lyf.partner = "无";
		System.out.println(lyf.name);
		lyf.acting();
	}
}