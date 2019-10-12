package acme;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SearchVendor {
	@Test
	public void search() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Actions builder = new Actions(driver); 
		WebElement action = driver.findElementByXPath("//button[text() = ' Vendors']");
		builder.moveToElement(action).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		WebElement country = driver.findElementByXPath("//tr[2]/td[5]");
	    System.out.println(country.getText());
	    driver.findElementByLinkText("Log Out");
	    driver.close();
}
}