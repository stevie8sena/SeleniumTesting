package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Rasyid Sholeh Rosena
 *
 */

public class SeleniumTestingModular {
	public static String browser;
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		SeleniumTestingModular test = new SeleniumTestingModular();
		test.setBrowser("Firefox");
		test.setBrowserConfig();
		test.verifyTitle();
		test.setLogin();
		test.verifyLogin();
		test.setLogoutFirefox();

		test.setBrowser("Edge");
		test.setBrowserConfig();
		test.verifyTitle();
		test.setLogin();
		test.verifyLogin();
		test.setLogoutEdge();
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setBrowserConfig() {
		String projectLocation = System.getProperty("user.dir");

		if (browser.contains("Edge")) {
			System.setProperty("webdriver.edge.driver", projectLocation + "\\lib\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\lib\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	public void setLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	public void verifyLogin() throws InterruptedException {

		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

		Assert.assertEquals(expectedURL, actualURL);
		System.out.println("URL match, success login.");

		Thread.sleep(5000);
	}

	public void setLogoutFirefox() {
		String idLogout = "Logout";
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.partialLinkText(idLogout)).click();
		System.out.println("Logout OrangeHRM success with Firefox.");
		driver.close();
	}

	public void setLogoutEdge() {
		driver.findElement(By.id("welcome")).click();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/logout");
		System.out.println("Logout OrangeHRM success with Edge.");
		driver.close();
	}

	//@Test
	public void verifyTitle() {
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();

		// get the actual value of the title
		//actualTitle = driver.getTitle();

		try {
			Assert.assertEquals(actualTitle, expectedTitle);
			System.out.println("Assert web page passed.");
		} catch (AssertionError e) {
			System.out.println("Assert web page not passed.");
			driver.quit();
		}

	}
}
