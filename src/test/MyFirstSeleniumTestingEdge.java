package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * @author Rasyid Sholeh Rosena
 *
 */

public class MyFirstSeleniumTestingEdge {
	public static void main(String [] args) {
		String projectLocation = System.getProperty("user.dir");
		
		System.setProperty("webdriver.edge.driver" , projectLocation+"\\lib\\driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
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
