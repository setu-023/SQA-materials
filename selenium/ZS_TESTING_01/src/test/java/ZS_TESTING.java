
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




public class ZS_TESTING{

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
	
	    driver.get("https://nmed-c.zssbd.com/auth/user/login/?next=/alerts/list/");
		driver.manage().window().maximize();
		
  }
	
  
@Test (priority = 1)
  public void check_login_button() throws InterruptedException {
		
			System.out.println("check_login_button");	
			Thread.sleep(1000);

			driver.findElement(By.xpath("//input[@id='id_username']")).sendKeys("testdoc");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@id='id_password']")).sendKeys("Test123456");
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//button[@id='clinicianLogin']")).click();
			Thread.sleep(5000);
			


}

@Test(priority = 2)
public void add_patient() throws InterruptedException {
	
	System.out.println("add_patient");	
	Thread.sleep(5000);
	
	//check patient is availability
	driver.findElement(By.xpath("//input[@name='clinic_patient_ref']")).sendKeys("202020202020");
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
	driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
	Thread.sleep(5000);
	
    //insert patient info
	driver.findElement(By.xpath("//input[@name='id_username']")).click();


	//insert other fields, TODO 
	
	//confirm
	driver.findElement(By.xpath("//input[@name='id_username']")).click();

	
}

//
//
@Test (priority = 3)
public void verify_patients() throws InterruptedException {
    
			System.out.println("verify_patients");	
			
			driver.navigate().refresh();
			String actual_patient_id = driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//tr/td[contains(text(), '202020202020')]")).getText();
     		System.out.println(actual_patient_id);	

     		String expecte_patient_id = "202020202020";
			Assert.assertEquals(actual_patient_id, expecte_patient_id);

			

}


@Test (priority = 4)
public void check_logout() throws InterruptedException {
    
	        System.out.println("check_logout");	

			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[@class='username-block']")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//a[@href='/auth/user/logout/']")).click();
			Thread.sleep(5000);
						

}


}	
	