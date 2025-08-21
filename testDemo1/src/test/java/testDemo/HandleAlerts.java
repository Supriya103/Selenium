package testDemo;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleAlerts {
	 WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

	        // 🔹 Login
	        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	    }

	    @Test
	    public void handleDeleteWithoutAlertTest() {
	        try {
	            // count rows before deletion
	            int rowsBefore = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr")).size();
	            Assert.assertTrue(rowsBefore > 1, "No orders available to delete!");

	            // select first order
	            WebElement firstOrderCheckbox = driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector"));
	            firstOrderCheckbox.click();

	            // click delete (⚠ no alert appears on this site)
	            driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

	            // check if row count decreased
	            int rowsAfter = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr")).size();
	            Assert.assertTrue(rowsAfter < rowsBefore, "Order was not deleted!");
	        } catch (Exception e) {
	            Assert.fail("❌ Delete Test failed: " + e.getMessage());
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
    

   
   

    
   
	
	
