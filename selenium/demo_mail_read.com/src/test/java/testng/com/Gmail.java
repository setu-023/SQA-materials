package testng.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Gmail {
	
	public static WebDriver driver;
	public static WebElement element;
	public static String browser;
	public static String message = "মেসেজ পাঠানো হয়েছে!";

	public static String email = "setu0848@gmail.com";
	public static String pass = "setu2009";
	
	@BeforeClass
	public static void setEnv() throws InterruptedException {

		setBrowser();
		setBrowserConfig();
		setConnection();

	}
	public static void setBrowser() {

		browser = "Chrome";
		System.out.println("setBrowser() method executed");
		
	}
	
    public static void setBrowserConfig() {
		
			if (browser.contains("Chrome")){
			  	//System.setProperty("webdriver.chrome.driver", "chromedriver");
				//driver = new ChromeDriver();
			
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
	        options.addArguments("incognito");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		    driver = new ChromeDriver(capabilities);
			}
		}
	
	
	public static void setConnection() {

		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		System.out.println("setConnection() method executed");

	}

	@Test(priority = 1)
	public static void login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		
		driver.findElement(By.xpath("//div[@id='passwordNext']")).click();
		Thread.sleep(1000);
		
		System.out.println("login() method executed");


	}
	@Test(priority= 2)
	public static void sendingMessage() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("hello setu");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys("this is from gmail...");
		Thread.sleep(1000);
		
	    driver.findElement(By.xpath("//div[contains(text(),'প্রাপক')]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//textarea[@role='combobox']")).sendKeys("setu0848@yahoo.com");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='পাঠান']")).click();
		Thread.sleep(5000);
		
		System.out.println("sendingMessage() method executed");

	}
	@Test(priority = 3)
	public static void sendingValidate() throws InterruptedException {

		WebElement getText = driver.findElement(By.xpath("//span[@class='bAq']"));
		String text = getText.getText();
		Thread.sleep(1000);
		System.out.println(text);

		if (text.equals(message)) {
			AssertJUnit.assertTrue(true);
			System.out.println(message);
		}
		else 
		{			
			AssertJUnit.fail();
			System.out.println("msg not delivered");
		}
		
		System.out.println("sendingValidate() method executed");

	}

	@AfterClass
	public static void logout() throws InterruptedException {
//
		driver.findElement(By.xpath("//img[@class='gb_Ia gbii']")).click();		
		driver.findElement(By.xpath("//a[@class='gb_Ib gb_eg gb_mg gb_1e gb_7c']")).click();
		Thread.sleep(1000);
		
		System.out.println("logout() method executed");
		
		driver.quit();


	}
	
	@AfterSuite
	public static void afterSuit() {
		/* this method will execute one time only after executing everything 
		 * may be all environment related connection we may disconnect here.
		 */
		System.out.println("This is after Suite");
		
	}

}
