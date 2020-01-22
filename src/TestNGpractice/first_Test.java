package TestNGpractice;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;


public class first_Test {
	
	WebDriver driver;
		
	@BeforeTest
	public void setup ()
	{
		//System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "lib/chromedriver.exe");
		//driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		driver= new FirefoxDriver();
	}
	@Test 
	public void openOrangeHRM()
	{
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		String currentURL=driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("index.php/auth/login"));
				
	}
	
	
	@Test (dependsOnMethods="openOrangeHRM")
	void loggingIn()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		String status=driver.getCurrentUrl();
		Assert.assertTrue(status.equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard"));
	}
	
	@Test (dependsOnMethods="loggingIn")
	public void Logout()
	{
		
		//driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[2]")).click();
	//	driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/ul/li[2]/a")).click();
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.quit();
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	@Test (priority=1,description=" this is to test login page")
	public void loginapplication()
	{
		System.out.println("Please login");
		AssertJUnit.assertEquals(12, 13);
				
	}

	@Test (priority=2,description=" this is for adding the items to the cart",dependsOnMethods="loginapplication")
	public void selectItems()
	{
		System.out.println("The selected items are");
	}
	
	@Test (priority=3,description=" this is for checkout",dependsOnMethods="selectItems")
	public void Checkout()
	{
		System.out.println("Please pay the amount and checkout");
	
	}*/

