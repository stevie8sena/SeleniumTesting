package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Rasyid Sholeh Rosena
 *
 */

public class MyFirstSeleniumTestingFirefox {
	public static void main(String [] args) {
		String projectLocation = System.getProperty("user.dir");
		
		System.setProperty("webdriver.gecko.driver" , projectLocation+"\\lib\\driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String expectedTitle = "OrangeHRM";
		String actualTitle = "";
		
		actualTitle = driver.getTitle();
		
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
		
	}
}
