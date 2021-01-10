package testng.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class Default {
	
	public static WebDriver driver;
	public static WebElement element;
	public static String browser;
	
	@BeforeSuite()
	public static void setBrowser() {

		browser = "Chrome";
		System.out.println("setBrowser() method executed");
		
	}
		
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public static void setBrowserConfig() {
		if (browser.contains("Chrome")){
		  	//System.setProperty("webdriver.chrome.driver", "chromedriver");
			//driver = new ChromeDriver();
			
	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("incognito");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        driver = new ChromeDriver(capabilities);
	        
			System.out.println("setBrowserConfig() method executed");

			}
		}

}
