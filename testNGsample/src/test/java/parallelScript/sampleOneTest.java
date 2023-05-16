package parallelScript;

import org.testng.annotations.Test;

public class sampleOneTest {
	
	@Test
	public void testOne() {
		long id=Thread.currentThread().getId();
		System.out.println("Test12 in sample One..."+id);
		
	}
	@Test
	public void testTwo() {
		long id=Thread.currentThread().getId();
		System.out.println("TestTwo in sample One.."+id);
		
	}
	@Test
	public void testThree() {
		long id=Thread.currentThread().getId();
		System.out.println("Test3 in sample One..."+ id);
		
	}
	@Test(invocationCount=6, threadPoolSize=3, timeOut=2000)
	public void testFour() {
		long id=Thread.currentThread().getId();
		System.out.println("Tes22 in sample One..."+id);
		
	}

}
