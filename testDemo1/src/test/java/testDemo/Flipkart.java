package testDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Flipkart {
      WebDriver driver;
      @BeforeSuite
      public void beforeSuite() {
     	 System.out.println("Start of the suite");
      }
      @BeforeClass
      public void setUp() {
    	  System.out.println("Launching the browser");
     	 
     	 driver=new ChromeDriver();
     	 driver.manage().window().maximize();
     	 driver.get("https://www.flipkart.com/");;
      }
      @BeforeMethod
      public void beforeMethod() {
    	  System.out.println("Navigating to home page");
    	  driver.get("https://www.flipkart.com/");
      }
      @Test
      public void testValidSearch() {
    	  WebElement searchBox=driver.findElement(By.name("q"));
    	  searchBox.sendKeys("i phone 15 pro max");
    	  searchBox.submit();
    	  driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 15 Pro Max(Black Titanium, 1 TB)']")).click();
      }
//      @AfterClass
//      public void TearDown() {
//  		if(driver!=null) {
//  			driver.quit();
//  		}
//  	}
}
