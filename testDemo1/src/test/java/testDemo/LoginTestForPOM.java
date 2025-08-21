package testDemo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestForPOM {
	WebDriver driver;
    LoginPageForPOM loginPage;
    String baseUrl = "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx";

    @BeforeMethod
    public void setUp() {
        driver = UtilityClassforWebDriverInPOM.getDriver();
        driver.get(baseUrl);
        loginPage = new LoginPageForPOM(driver);  // updated usage
    }

    @Test
    public void validLoginTest() {
        loginPage.login("Tester", "test");
        String expectedTitle = "Web Orders";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Login failed with valid credentials!");
    }

    @Test
    public void invalidLoginTest() {
        loginPage.login("WrongUser", "WrongPass");
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Invalid Login"), "Error message mismatch!");
    }

    @AfterMethod
    public void tearDown() {
        UtilityClassforWebDriverInPOM.quitDriver();
    }
}

