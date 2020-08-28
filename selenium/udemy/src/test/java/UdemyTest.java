import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UdemyTest {
	
	
	public static WebDriver driver;
	public static WebElement element;
	
	public static String full_name		= "mursalin setu";
	public static String email  		= "amursalin143056@bscse.uiu.ac.bd";
	public static String password  		= "setu2009";
	public static String expectedUser	= "There was a problem creating your account. Check that your email address is spelled correctly.";

	

	

	
  @Test
  public void f() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
		
		driver.get("https://www.udemy.com/join/signup-popup/?locale=en_US&response_type=html&next=https%3A%2F%2Fwww.udemy.com%2F/");
		
		//System.out.print(driver.getTitle());		//code for navigating to the URL & maximizing browser
		//driver.get("https://www.udemy.com/");
		
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		
		
//		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='id_fullname']")).sendKeys(full_name);
		driver.findElement(By.xpath("//input[@id='email--1']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='submit-id-submit']")).submit();
		
		
		element = driver.findElement(By.xpath("//div [@class='alert alert-danger js-error-alert']"));
		
		Thread.sleep(1000);
		String actualUIUser = element.getText();
		System.out.println(actualUIUser);
		
		
		// code for validation using if else condition
		if(actualUIUser.equals(expectedUser)) {
			Assert.assertTrue(true);
			System.out.println("pls use another email");
		}else {
			System.out.println("Okay");
			Assert.fail();
		}
  }
}
