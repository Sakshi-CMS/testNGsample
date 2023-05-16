package testScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OneCartRagistration {
 WebDriver driver;
  @BeforeTest
  public void launchWebsite() {
	
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			driver.manage().window().maximize();
  }
	@Test(priority=1)
	 public void MyAccount() 
	{
			  
		driver.get("https://demo.opencart.com/"); 
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
	}
	@Test(priority=2)
	public void Registration() throws InterruptedException{
		driver.findElement(By.id("input-firstname")).sendKeys("Sakshi");
		driver.findElement(By.id("input-lastname")).sendKeys("Bhavsar");
		driver.findElement(By.id("input-email")).sendKeys("sakshibhavsar2018@");
		driver.findElement(By.id("input-password")).sendKeys("sakshi123");
		
		JavascriptExecutor js2 =(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(10, 500)");
		
		/*WebElement subscribe = driver.findElement(By.xpath("//input[@id='input-newsletter-no']"));
		if(!subscribe.isSelected()) 
		{
			subscribe.click();
		}*/
		
		WebElement elem = driver.findElement(By.xpath("//input[@name='agree']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", elem);
	
		WebElement cont = driver.findElement(By.cssSelector("button[type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", cont);
		
         String exp = "";
		
		 WebElement m= driver.findElement(By.id("input-email"));
		 String act = m.getText();
	     System.out.println("Please enter a part following '@', 'sakshibhavsar2018@' is incomplete "+ act);
	      
	      Assert.assertEquals(exp, act);
			
		
	}
	@AfterTest
	public void pageClose() {
		driver.close();
		
	}
}
	

