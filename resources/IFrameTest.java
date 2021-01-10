package com.w2a.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrameTest {
	
	
	public static WebDriver driver;
	public static WebElement element;
	public static String browser;
	public static int expectedFrame = 3;

	@BeforeTest	
	public static void iframeTest() throws InterruptedException  {
		
		
		setBrowser();
		setBrowserConfig();
		setConnection();
		frameCount();
		getIframeText();
		
		System.out.println("before method execution ends.");
			
		
	}
	

	  public static void setBrowser() {
			
			browser = "Chrome";
			System.out.println("setBrowser() method executed");
		}
		
	  public static void setBrowserConfig() {
			
			if (browser.contains("Chrome")){
			  	System.setProperty("webdriver.chrome.driver", "chromedriver");
				driver = new ChromeDriver();
				System.out.println(" setBrowserConfig() method executed");
			}
		}
	  
	  
	  @Test
	  public static void setConnection() {
		
			driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html");
			driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);;
			driver.manage().window().maximize();
			System.out.println(" URL opened");
			System.out.println(" test 1 : setConnection() complete ");
			
	  }
	  @Test
	  public static void frameCount() {
			//check total iframe
			int iframeCount = driver.findElements(By.tagName("frame")).size();
			//System.out.println(iframeCount);
			
			if(iframeCount == expectedFrame) {
				AssertJUnit.assertTrue(true);
				System.out.println("Total Frame count = " + iframeCount);
			}
			else {
				System.out.println("Total Frame count = " + iframeCount);
				AssertJUnit.fail();
			}
			
			System.out.println(" test 2 : frameCount() complete ");
			
		}
	  
	  @Test
	  public static void getIframeText() throws InterruptedException {
		  
		    //by name
			driver.switchTo().frame("packageListFrame");
			// get the text
			element = driver.findElement(By.xpath("//a[@href='allclasses-frame.html']"));
			Thread.sleep(5000);
			String text1 = element.getText();
			System.out.println("Frame1 Extraction = " + text1);

			driver.switchTo().defaultContent();

		  
		  
		    //by name
			driver.switchTo().frame("classFrame");
			// get the text
			element = driver.findElement(By.xpath("//a[@href='com/thoughtworks/selenium/package-summary.html']"));
			Thread.sleep(5000);
			String text2 = element.getText();
			System.out.println("Frame1 Extraction = " + text2);

			driver.switchTo().defaultContent();
			
			System.out.println(" test 3 : getIframeText() complete ");
			

	  }



}
