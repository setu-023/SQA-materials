package monster_lab;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RunTestCases {

	public static WebDriver driver;
	public static WebElement element;
	public static String browser;

	@BeforeClass
    public void set_connection() throws InterruptedException {
	  
		
	    setBrowser();
	    setBrowserConfig();
	    setConnection();
	    
	}
	
	@AfterClass
    public void close_connection() throws InterruptedException {
	  
	  driver.close();  
	}
		
  
public static void setBrowser() {

		browser = "Safari";
		System.out.println("setBrowser method executed");
		
	}
	
 public static void setBrowserConfig() {
		
			if (browser.contains("Safari")){
			  	//System.setProperty("webdriver.chrome.driver", "chromedriver");
				driver = new SafariDriver();
				}}
	
  
  public static void setConnection() {
	
	    driver.get("https://monstar-lab.com/global/");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);;
		driver.manage().window().maximize();
		
  }
	
  
@Test (priority = 1)
  public void check_contact_button() throws InterruptedException {
		
			System.out.println("check_contact_button");	

			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@href='https://monstar-lab.com/global/contact/']")).click();
			String expecte_url = "https://monstar-lab.com/global/contact/";
			String current_url =  driver.getCurrentUrl();
//			System.out.println(current_url);	
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@class='cookie-control-js']")).click();

			Assert.assertEquals(current_url, expecte_url);
			


}

@Test(priority = 2)
public void check_contact_form() throws InterruptedException {
	
	System.out.println("check_contact_form");	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//button[@class='send-cta-btn']")).submit();
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//button[text()='Send']")).click();

	String expeted_error_message = "This field is required";
	String actual_error_message = driver.findElement(By.xpath("//p[@class='error-info error-info-email-js']")).getText();
	//System.out.println(actual_error_message);	

	Assert.assertEquals(actual_error_message, expeted_error_message);

}


@Test (priority = 3)
public void check_career_button() throws InterruptedException {
    
			System.out.println("check_career_button");	

			driver.get("https://monstar-lab.com/global/about/careers/");
			driver.findElement(By.xpath("//a[@href='https://monstar-lab.com/global/about/careers/']")).click();
			String expecte_url = "https://monstar-lab.com/global/about/careers/";
			String current_url =  driver.getCurrentUrl();
//			System.out.println(current_url);	
			
			Assert.assertEquals(current_url, expecte_url);

			

}


@Test (priority = 4)
public void check_open_position() throws InterruptedException {
    
			System.out.println("check_open_position");	

			Thread.sleep(2000);

			driver.findElement(By.xpath("//select[@id='career_location']")).click();
			Thread.sleep(2000);


			driver.findElement(By.xpath("//option[@value='https://www.facebook.com/MonstarLab.Bangladesh/']")).click();
			driver.findElement(By.xpath("//a[@id='career_link']")).click();

			// Store the current window handle
			String winHandleBefore = driver.getWindowHandle();

			// Perform the click operation that opens new window

			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}

			//driver.switchTo().window("windowName");
			String expecte_url = "https://monstar-lab.com/global/about/careers/";
			String current_url =  driver.getCurrentUrl();
			
			
//			System.out.println(driver.getCurrentUrl());	
			
			Thread.sleep(7000);
			// Close the new window, if that window no more required
			driver.close();
			Thread.sleep(1000);
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
			
//			System.out.println(driver.getCurrentUrl());	

			Assert.assertEquals(current_url, expecte_url);
			
				

}


}
