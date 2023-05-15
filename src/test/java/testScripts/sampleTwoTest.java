package testScripts;

import org.testng.annotations.Test;

public class sampleTwoTest {
	
	@Test(groups="feature1")
	public void testOne() {
		System.out.println("Test1 in sample two");
		
	}
	@Test(groups="feature1")
	public void testTwo() {
		System.out.println("Test2 in sample two");
		
	}
	@Test(groups="feature3")
	public void testThree() {
		System.out.println("Test21 in sample two");
		
	}
	@Test(groups="feature2")
	public void testFour() {
		System.out.println("Test11 in sample two");
		
	}

}
