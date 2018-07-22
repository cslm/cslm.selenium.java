package com.testalliance.hrsystem.managers;
import com.testalliance.hrsystem.tests.TCLogin1;
import com.testalliance.hrsystem.tests.TCLogin2;
import com.testalliance.hrsystem.tests.TCLogin3;
import com.testalliance.hrsystem.tests.TCLogin4;

public class TestRunner 
{
	public static void main(String[] args)
	{
		TCLogin1 tcLogin1 = new TCLogin1();
		tcLogin1.test();
		TCLogin2 tcLogin2 = new TCLogin2();
		tcLogin2.test();
		TCLogin3 tcLogin3 = new TCLogin3();
		tcLogin3.test();
		TCLogin4 tcLogin4 = new TCLogin4();
		tcLogin4.test();
	}
}
