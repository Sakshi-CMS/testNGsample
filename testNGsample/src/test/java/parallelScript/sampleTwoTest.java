package parallelScript;

import org.testng.annotations.Test;

public class sampleTwoTest {
	
	@Test
	public void testOne() {
		long id=Thread.currentThread().getId();
		System.out.println("Test1 in sample two...."+id);
		
	}
	@Test
	public void testTwo() {
		long id=Thread.currentThread().getId();
		System.out.println("Test2 in sample two..."+id);
		
	}
	@Test
	public void testThree() {
		long id=Thread.currentThread().getId();
		System.out.println("Test21 in sample two...."+id);
		
	}
	@Test
	public void testFour() {
		long id=Thread.currentThread().getId();
		System.out.println("Test11 in sample two...."+id);
		
	}

}
