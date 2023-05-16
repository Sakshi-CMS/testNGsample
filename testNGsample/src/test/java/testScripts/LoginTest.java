package testScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.j2objc.annotations.Property;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class LoginTest {

	WebDriver driver;
	Properties prop;
	/*@Parameters("browser")
	@BeforeMethod
	public void setUp(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
	     driver=new ChromeDriver() ;
		}
		else if(strBrowser.equalsIgnoreCase("edge")) {
	     driver=new EdgeDriver();
		}
		  driver.manage().window().maximize();
		
	}*/
	
	@BeforeMethod
	public void setup() throws IOException {
		
		String path=System.getProperty("user.dir")+"//src//test//resources//ConfigFolder//Config.property";
		FileInputStream fin = new FileInputStream(path);
		prop = new Properties();
		prop.load(fin);
		String strBrowser = prop.getProperty("browser");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="logindata")
	public void vaildLogin(String strUser, String strpwd) throws IOException {
	
		    driver.get(prop.getProperty("url"));
		    driver.findElement(By.id(readObjectPath("user_name"))).sendKeys(strUser);
		    driver.findElement(By.id(readObjectPath("user_pwd"))).sendKeys(strpwd);
		    driver.findElement(By.tagName(readObjectPath("loginButton"))).click();
		   // boolean isDsp=driver.findElement(By.cssSelector(readObjectPath("SuccessMsg"))).isDisplayed();
		    //Assert.assertTrue(isDsp);
		    	
	}
	public String readObjectPath(String objName) throws IOException {
		String objPath="";
		String path=System.getProperty("user.dir")+"//src//test//resources//dataFiles//LoginPage.xlsx";
		//HSSF
		
		
		FileInputStream fin;
		XSSFWorkbook workbook=null;
		try {
			fin=new FileInputStream(path);
			workbook =new XSSFWorkbook(fin);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
		   e.printStackTrace();
		}
		XSSFSheet LoginSheet = workbook.getSheet("loginPage");
		int numRows = LoginSheet.getLastRowNum();
		for(int i=1;i<=numRows;i++) {
			XSSFRow row = LoginSheet.getRow(i);
			if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
				objPath = row.getCell(1).getStringCellValue();
			}
				
		}
		
		return objPath;
		
	}
	@DataProvider(name="logindata")
	public Object [][] getData() throws CsvValidationException, IOException{
		String path=System.getProperty("user.dir")+"//src//test//resources//dataFiles//logindata.csv";
		CSVReader reader=new CSVReader (new FileReader(path));
		String cols[];
		ArrayList <Object> dataList=new ArrayList<Object>();
		while((cols=reader.readNext()) !=null){
			Object record[]= {cols[0],cols[1]};
			dataList.add(record);
		}
		reader.close();
		return dataList.toArray(new Object[dataList.size()][]);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}