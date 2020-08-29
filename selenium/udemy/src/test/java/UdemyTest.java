import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class UdemyTest {
	
	
	public static WebDriver driver;
	public static WebElement element;
	
	public static String browser;
	public static String full_name		= "mursalin setu";
	public static String email  		= "setu.023@gmail.com";
	public static String password  		= "setu2009";
	public static String expectedUser	= "There was a problem creating your account. Check that your email address is spelled correctly.";

	@Test
  
  public void f() throws InterruptedException {
	  
		
	    setBrowser();
	    setBrowserConfig();
	    setConnection();
	    
	    testSignUp();
	    Thread.sleep(1000);
		testSignInWithIncorrectData();
		Thread.sleep(1000);
		testSignIn();
		Thread.sleep(5000);
	
		//testSearch();

		driver.quit(); 
		

	}
		
  
  public static void setBrowser() {
		
		browser = "Chrome";
	}
	
  public static void setBrowserConfig() {
		
		if (browser.contains("Chrome")){
		  	System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
	}
  
  public static void setConnection() {
	
	    driver.get("https://www.udemy.com/");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		
  }
	
  
@Test
  public void testSignIn() throws InterruptedException {
			
			driver.findElement(By.xpath("//a[@class='udlite-btn udlite-btn-small udlite-btn-secondary udlite-heading-sm']")).click();
			
			driver.findElement(By.xpath("//input[@id='email--1']")).sendKeys(email);
			//input[@id='id_password']
			driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys(password);
			
			driver.findElement(By.xpath("//input[@id='submit-id-submit']")).click();
			Thread.sleep(1000);
			


		}
  
 @Test

  public void testSignInWithIncorrectData() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@class='udlite-btn udlite-btn-small udlite-btn-secondary udlite-heading-sm']")).click();
		
		driver.findElement(By.xpath("//input[@id='email--1']")).sendKeys("@setu.023.gmail.com");
		//input[@id='id_password']
		driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@id='submit-id-submit']")).click();
		Thread.sleep(1000);
		String actualAlert = driver.findElement(By.xpath("//input[@id='submit-id-submit']")).getText();
		Thread.sleep(1000);
		
		String expectedAlert = "Please enter a part followed by '@'. '@setu.023.gmail.com' is incomplete.";
		
		
		if(!actualAlert.equals(expectedAlert)) {
			AssertJUnit.assertTrue(true);
			//System.out.println("PASS");
		    driver.get("https://www.udemy.com/");

			
		}else {
			System.out.println("Fail");
			AssertJUnit.fail();
		}
		
		
//		Alert alert = driver.switchTo().alert();
//		Thread.sleep(1000);
//		driver.switchTo().alert();
//		Thread.sleep(1000);

		


	}
	
  
@Test
  public void testSignUp() throws InterruptedException {
	  
			driver.findElement(By.xpath("//span[text()='Sign up']")).click();
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
			}
			else{
				Assert.assertFalse(true);
				System.out.println("Okay");	
			}
			
			driver.get("https://www.udemy.com/");
		}
//  public static void testSearch() throws InterruptedException {
//	  
//		driver.findElement(By.xpath("//input[@id='u277-search-form-autocomplete--4']")).sendKeys("selenium");
//		driver.findElement(By.xpath("//input[@id='u277-search-form-autocomplete--4']")).submit();
//		Thread.sleep(1000);
//
//
//	}
  
}
