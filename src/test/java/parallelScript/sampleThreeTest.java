package parallelScript;

import org.testng.annotations.Test;

public class sampleThreeTest {
	@Test
	public void testOne() {
		long id=Thread.currentThread().getId();
		System.out.println("Test12 in sampleThree..."+id);
		
	}
	@Test
	public void testTwo() {
		long id=Thread.currentThread().getId();
		System.out.println("TestTwo in sampleThree..."+id);
		
	}
	@Test
	public void testThree() {
		long id=Thread.currentThread().getId();
		System.out.println("Test3 in sampleThree..."+id);
		
	}
	@Test
	public void testFour() {
		long id=Thread.currentThread().getId();
		System.out.println("Test22 in sampleThree..."+id);
		
	}

}



