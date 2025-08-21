package testDemo;



	

	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.*;

	import java.time.Duration;
	public class HandleDatePicker {
	

	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

	        // 🔹 Login
	        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
	        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
	        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

	        // 🔹 Go to Order page
	        driver.findElement(By.linkText("Order")).click();
	    }

	    @Test
	    public void handleDatePickerTest() {
	        try {
	            // wait until date field is visible
	            WebElement dateField = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_MainContent_fmwOrder_txtDate"))
	            );

	            // clear and set new date
	            dateField.clear();
	            String newDate = "08/25/2025";
	            dateField.sendKeys(newDate);

	            // verify entered value
	            String actualDate = dateField.getAttribute("value");
	            Assert.assertEquals(actualDate, newDate, "Date was not entered correctly!");
	            System.out.println("✅ Date successfully entered: " + actualDate);

	        } catch (Exception e) {
	            Assert.fail("❌ Date Picker Test failed: " + e.getMessage());
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

	    

