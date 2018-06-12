class Wanghong
{
	String name;
	int age;
	String hobby;
	
	public static void main(String[] args)
	{
		Wanghong wsc = new Wanghong();
		Wanghong mm = new Wanghong();
		
		wsc.age = 30; 
		mm.age = 18; 
		wsc.name = "王思聪"; 
		mm.name = "咪蒙";
		wsc.hobby = "打游戏"; 
		mm.hobby = "写文章";
		
		System.out.println(wsc.name);
		System.out.println(wsc.age);
		System.out.println(wsc.hobby);
		
		System.out.println(mm.name);
		System.out.println(mm.age);
		System.out.println(mm.hobby);
	}
}