package com.test;

class Computer
{
    String brand;
	float price;
	
	public Computer(String brand, float price)
	{
		this.brand = brand;
		this.price = price;
	}	
}

class TypeBag<T>
{
	private T type;

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}
}

public class Test 
{
	public static void main(String[] args) 
	{
		Computer asus = new Computer("华硕", 500);
		Computer dell = new Computer("戴尔", 600);
		Computer mac = new Computer("Mac", 700);
		
		// TypeBag类贴上了Computer类的标签，TypeBag类与Computer类相绑定
		TypeBag<Computer> t1 = new TypeBag<Computer>();
		t1.setType(asus);
		TypeBag<Computer> t2 = new TypeBag<Computer>();
		t2.setType(dell);
		TypeBag<Computer> t3 = new TypeBag<Computer>();
		t3.setType(mac);
		
		System.out.println("小店电脑种类：");
		System.out.println("===========");
		System.out.println(t1.getType().brand + ", " + t1.getType().price);
		System.out.println(t2.getType().brand + ", " + t2.getType().price);
		System.out.println(t3.getType().brand + ", " + t3.getType().price);
	}
}