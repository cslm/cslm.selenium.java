class Wanghong
{
	String name;
	int age;
	String hobby;
	
	public void writing()
	{
		System.out.println("今晚写文章");
	}
	
	public int countGuai(int numOfEach, int n)
	{
		int total = 0;
		for(int i = 0; i <= 5;i++)
		{
			total += numOfEach;
		}
		return total;
	}
}