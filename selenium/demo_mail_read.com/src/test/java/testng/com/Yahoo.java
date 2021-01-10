package testng.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Yahoo {
	
	public static WebDriver driver;
	public static WebElement element;
	public static String browser;

	public static String email = "setu0848@yahoo.com";
	public static String pass = "uiu@2009";

	public static String subject = "hello setu";
	public static String body = "this is from gmail...";
	

	@BeforeClass
	public static void setEnv() throws InterruptedException {

		setBrowser();
		setBrowserConfig();
		setConnection();

	}


	public static void setBrowser() {

		browser = "Safari";
		System.out.println("setBrowser() method executed for yahoo");
		
	}
	
    public static void setBrowserConfig() {
		
			if (browser.contains("Safari")){
			  	//System.setProperty("webdriver.chrome.driver", "chromedriver");
				driver = new SafariDriver();
				}
			
//	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//            ChromeOptions options = new ChromeOptions();
//	        options.addArguments("incognito");
//	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//		        driver = new ChromeDriver(capabilities);
//			}
		}
	
	
	public static void setConnection() {

		driver.get("https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%2Ffolders%2F1");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println("setConnection() method executed for yahoo");


	}

	@Test(priority = 1)
	public static void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@value='Next']")).click();
		Thread.sleep(1000);
		
		System.out.println("login() method executed for yahoo");


	}

	@Test(priority = 2)
	public static void validatingMail() throws InterruptedException {

		driver.findElement(By.xpath("//span[text()='hello setu']")).click();
		Thread.sleep(1000);
		
		WebElement subjectElement = driver.findElement(By.xpath("//span[@data-test-id='message-group-subject-text']"));
		String getSubject = subjectElement.getText();
		System.out.println(getSubject);
		
		WebElement bodyElement = driver.findElement(By.xpath("//div[@dir='ltr']"));
		String getBody = bodyElement.getText();
		System.out.println(getBody);
		
//
//		// code for validation using if else condition
		if ( getSubject.equals(subject) && getBody.equals(body) ) {
				AssertJUnit.assertTrue(true);
				System.out.println("Received mail from gmail");
		}
		else 
		{
			AssertJUnit.fail();
			System.out.println("Mail not Received from gmail");
		}
		
		System.out.println("validatingMail() method executed for yahoo");

	}
//
	@Test(priority = 3)
	public static void replyingMail() throws InterruptedException {


		driver.findElement(By.xpath("//button[text()='Reply']")).click();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);

		WebElement enement = driver.findElement(By.xpath("//button[text()='Reply']"));
		enement.sendKeys("Thanx for ur mail...");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		
		System.out.println("replyingMail() method executed for yahoo");


	}
	
	@AfterClass
	public static void logout() throws InterruptedException {


		driver.findElement(By.xpath("//img[@class='_yb_1oxqp']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Sign out']")).click();
		Thread.sleep(5000);
		
		System.out.println("logout() method executed for yahoo");
		
		driver.quit();

	
	}


}
