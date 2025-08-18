package testDemo;

import org.testng.annotations.DataProvider;

public class SauceDataProvider {
	  @DataProvider(name = "loginData")
	   public Object[][] getData() {
	       return new Object[][]{
	           {"standard_user", "secret_sauce", "success"},  
	           {"locked_out_user", "secret_sauce", "locked"}, 
	           {"performance_glitch_user", "secret_sauce", "success"}, 
	           {"invalid_user", "wrong_pass", "invalid"}     
	       };
	   }

}
