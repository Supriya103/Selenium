package testDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageForPOM {
	

	    private WebDriver driver;

	    // Locators
	    private By usernameInput = By.id("ctl00_MainContent_username");
	    private By passwordInput = By.id("ctl00_MainContent_password");
	    private By loginButton   = By.id("ctl00_MainContent_login_button");
	    private By errorMessage  = By.id("ctl00_MainContent_status");

	    // Constructor
	    public LoginPageForPOM(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions
	    public void enterUsername(String username) {
	        driver.findElement(usernameInput).clear();
	        driver.findElement(usernameInput).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordInput).clear();
	        driver.findElement(passwordInput).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText();
	    }

	    public void login(String username, String password) {
	        enterUsername(username);
	        enterPassword(password);
	        clickLogin();
	    }

	} 

