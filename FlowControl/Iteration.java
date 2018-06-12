class Iteration									
{													
	public static void main(String[] args)
	{
		int k = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				k++;
				System.out.println(k + " ");
				break;
			}
		}
		System.out.println();
	}						
}