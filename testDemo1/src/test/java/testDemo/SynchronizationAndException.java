package testDemo;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SynchronizationAndException {
private static final Logger logger = LogManager.getLogger( SynchronizationAndException.class);
	
	WebDriver driver;
	WebDriverWait wait;
	@BeforeClass
	public void Logins() {
		logger.info("starting the login");
		System.out.println("Launching the browser");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		driver.get("https://parabank.parasoft.com/");
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
	}
	@Test
	public void testLogin() {
		try {
//			
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_username"))).sendKeys("Tester");
		       // pause(1);
		        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		       // pause(1);
		        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		       // pause(2);

		        // Verify login
		        Assert.assertTrue(driver.getTitle().contains("Web Orders"), "Login failed - Title mismatch");
		       // pause(2);
			System.out.println(" Login successful, Logout link found!");
		} catch (NoSuchElementException e) {
			System.out.println(" Element not found: " + e.getMessage());
			Assert.fail("Test failed due to missing element.");
		} catch (TimeoutException e) {
			System.out.println("  Timeout while waiting: " + e.getMessage());
			Assert.fail("Test failed due to timeout.");
		} catch (Exception e) {
			System.out.println(" Unexpected error: " + e.getMessage());
			Assert.fail("Test failed due to unexpected exception.");
		}
	}
	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
