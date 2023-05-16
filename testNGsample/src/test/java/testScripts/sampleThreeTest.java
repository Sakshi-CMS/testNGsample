package testScripts;

import org.testng.annotations.Test;

public class sampleThreeTest {
	@Test(groups="feature2")
	public void testOne() {
		System.out.println("Test12 in sampleThree");
		
	}
	@Test
	public void testTwo() {
		System.out.println("TestTwo in sampleThree");
		
	}
	@Test(groups="feature1")
	public void testThree() {
		System.out.println("Test3 in sampleThree");
		
	}
	@Test(groups="feature3")
	public void testFour() {
		System.out.println("Test22 in sampleThree");
		
	}

}



