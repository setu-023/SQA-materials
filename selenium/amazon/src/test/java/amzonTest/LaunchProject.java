package amzonTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchProject {
	
	static String browser;
	static WebDriver driver;
	public static String email= "setu.023@gmail.com";
	public static String pass= "setu2010";
	public static WebElement element;
	public static String expectedUser ="setu";
	
		public static String path = "//html[@class='a-ws a-js a-audio a-video a-canvas a-svg a-drag-drop a-geolocation a-history a-webworker a-autofocus a-input-placeholder a-textarea-placeholder a-local-storage a-gradients a-hires a-transform3d a-touch-scrolling a-text-shadow a-text-stroke a-box-shadow a-border-radius a-border-image a-opacity a-transform a-transition a-ember']//body[@class='ap-locale-en_US a-m-us a-aui_157141-c a-aui_158613-c a-aui_72554-c a-aui_dropdown_187959-c a-aui_pci_risk_banner_210084-c a-aui_perf_130093-c a-aui_tnr_v2_180836-c a-aui_ux_145937-c a-meter-animate']//div[@id='a-page']//div[@class='a-section a-padding-medium auth-workflow']//div[@id='authportal-center-section']//div[@id='authportal-main-section']//div[@class='a-section auth-pagelet-container']//div[@class='a-section a-spacing-base']//div[@class='a-section']/form[@class='auth-validate-form auth-real-time-validation a-spacing-none']//div[@class='a-section']//div[@class='a-box']//div[@class='a-box-inner a-padding-extra-large']//div[@class='a-row a-spacing-base']//input[@id='ap_email']";
		

	public static void main(String[] args) throws InterruptedException {
		
		setBrowser();
		setBrowserConfig();
		runTest();
		loginTest();
		
//		WebDriverWait wait = new WebDriverWait(driver, 120);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner' and text()='Sign in']")));
//		
		//new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.nsg-button"))).click();

		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);;
		//driver.manage().window().maximize();
		
		


	}
	
	
	
	public static void setBrowser() {
		
		browser = "Chrome";
	}
	
	public static void setBrowserConfig() {
		
		if (browser.contains("Chrome")){
			
			System.setProperty("webdriver.chrome.driver","chromedriver");
			driver = new ChromeDriver();
		}
	}
	
	public static void runTest() {
		
		driver.get("https://amazon.com/");
	}
	
	public static void loginTest() throws InterruptedException {
	
		// code for click action using selenium
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		driver.findElement(By.xpath("//div[@id='hmenu-customer-name']")).click();


		// code for writing email in Text box using sendkey method in selenium
		//driver.findElement(By.xpath("//div[@class='a-box-inner a-padding-extra-large']//input[@type='email']")).sendKeys(email);
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys(email);
		
//		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-password']")).sendKeys(pass);

		
		driver.findElement(By.xpath("//div[@class='a-box-inner a-padding-extra-large']//div[@class='a-row a-spacing-base']//input[@id='ap_email']")).sendKeys("hello");

//		driver.findElement(By.xpath("//div[@id='UserLoginCard']//input[@id='input-password']")).sendKeys(pass);
//		Thread.sleep(1000);
//		
//		driver.findElement(By.xpath("//input[@name='login']")).submit();
		
	}
	

}
