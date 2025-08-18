package testDemo;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
    @DataProvider(name="getdata")
    public Object[][]getData(){
    	return new Object[][] {
    		{"Admin","admin123"},
    		{"WrongUser","wrongPass"}
    	};
    }
}
