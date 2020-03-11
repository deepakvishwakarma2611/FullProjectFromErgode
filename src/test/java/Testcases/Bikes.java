package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Bikes {


	@Test
	public void Yamaha()
	{
		System.out.println("I am Yamaha");

	}
	
	@Test
	public void Honda()
	{
		System.out.println("I am Honda");

	}
	
	@Test
	public void Pulsar()
	{
		System.out.println("I am Pulsar");

	}
	
	@Test
	public void FailTestCaseTry()
	{
		Assert.assertTrue(true);
	}
	
	

}
